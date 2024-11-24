package com.imooc.springboot.controller;

import com.imooc.springboot.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/file")
public class FileInfoController {

    @Autowired
    FileInfoService fileInfoService;

    @PostMapping(value = "/upload")
    public boolean upload(@RequestParam("file") MultipartFile file, String fileName, int fileSize, int fileType) {
        return fileInfoService.upload(file, fileName, fileSize, fileType);
    }

    @GetMapping(value = "/download")
    public void download(@RequestParam("fileId") int fileId, HttpServletResponse response) {
        fileInfoService.download(fileId, response);
    }
}
