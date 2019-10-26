package com.atguigu.gmall.interceptor;

import com.atguigu.gmall.annotations.LoginRequired;
import com.atguigu.gmall.util.CookieUtil;
import com.atguigu.gmall.util.HttpclientUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截代码

        //判断被拦截的请求的访问的方法的注解是否需要拦截
        HandlerMethod hm = (HandlerMethod) handler;
        LoginRequired methodAnnotation = hm.getMethodAnnotation(LoginRequired.class);
        //是否拦截
        if (methodAnnotation == null) {
            return true;
        }


        String token = "";
        String oldToken = CookieUtil.getCookieValue(request, "oldToken", true);
        String newToken = request.getParameter("token");
        if (StringUtils.isNotBlank(oldToken)) {
            token = oldToken;
        }
        if (StringUtils.isNotBlank(newToken)) {
            token = newToken;
        }
        //调用认证中心进行验证
        String success = "fail";
        if (StringUtils.isNotBlank(token)) {
            success = HttpclientUtil.doGet("http://passport.gmall.com:8085/verify?token=" + token);
        }
        //是否必须登录
        boolean loginSuccess = methodAnnotation.loginSuccess();//获得该请求是否必须登录成功
        if (loginSuccess) {
            //必须登录成功才能使用
            if (!success.equals("success")) {
                //重定向回passport登录
                response.sendRedirect("http://passport.gmall.com:8085/index?ReturnUrl=" + request.getRequestURL());
                return false;
            }

            //需要将token携带的用户信息写入
            request.setAttribute("memberId", "1");
            request.setAttribute("nickname", "nickname");

        } else {
            //没有登录也能用，但是必须验证
            if (success.equals("success")) {
                request.setAttribute("memberId", "1");
                request.setAttribute("nickname", "nickname");
            }

        }
        //验证通过，覆盖cookie中的token
        if (StringUtils.isNotBlank(token)) {
            CookieUtil.setCookie(request, response, "oldToken", token, 60 * 60 * 2, true);
        }
        System.out.println("进入拦截器的拦截方法");
        return true;
    }
}
