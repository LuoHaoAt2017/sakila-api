package com.imooc.springboot.service;


import com.imooc.springboot.annotation.NeedTest;
import com.imooc.springboot.annotation.RoomTest;

public class ForumService {

    @NeedTest(value = true)
    public void deleteForum(int forumId) {
        System.out.println("删除论坛模块：" + forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int topicId) {
        System.out.println("删除论坛主题：" + topicId);
    }

    @RoomTest(roomCode = "001", roomName = "F3 503", roomType = "设备间")
    public void createForum(int forumId) {
        System.out.println("新增论坛模块：" + forumId);
    }
}
