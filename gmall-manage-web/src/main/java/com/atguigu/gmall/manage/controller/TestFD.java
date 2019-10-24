package com.atguigu.gmall.manage.controller;

import com.atguigu.gmall.manage.util.PmsUploadUtil;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

/**
 * Created by clk on 2019/10/16.
 */
public class TestFD {

    public static void main(String[] args) throws IOException, MyException {
        String imgUrl = "http://hadoop02";

        // 上传图片到服务器
        // 配置fdfs的全局链接地址
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();// 获得配置文件的路径

        ClientGlobal.init(tracker);

        TrackerClient trackerClient = new TrackerClient();

        // 获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        trackerServer = trackerClient.getConnection();

        // 通过tracker获得一个Storage链接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);


        String[] uploadInfos = storageClient.upload_file("d:/bundle.png", "png", null);

        for (String uploadInfo : uploadInfos) {
            imgUrl += "/" + uploadInfo;

            System.out.println(imgUrl);
        }

    }
}
