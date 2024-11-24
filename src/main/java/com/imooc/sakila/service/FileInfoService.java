package com.imooc.springboot.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileInfoService {
    boolean upload(MultipartFile file, String fileName, int fileSize, int fileType);
    void download(int fileId, HttpServletResponse response);
}
