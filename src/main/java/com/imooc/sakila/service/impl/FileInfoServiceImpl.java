package com.imooc.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.springboot.entity.FileInfo;
import com.imooc.springboot.mapper.FileMapper;
import com.imooc.springboot.service.FileInfoService;
import com.imooc.springboot.utils.IOUtils;
import com.imooc.springboot.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileInfoServiceImpl extends ServiceImpl<FileMapper, FileInfo> implements FileInfoService {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    private static String fileStore = ""; // 获取当前的执行目录

    @Override
    public boolean upload(MultipartFile file, String fileName, int fileSize, int fileType) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(fileName);
        fileInfo.setFileSize(fileSize);
        fileInfo.setFileType(fileType);
        String filePath =  fileStore + file.getOriginalFilename();
        fileInfo.setFilePath(filePath);
        try {
            FileOutputStream wStream = new FileOutputStream(filePath);
            IOUtils.dump(file.getInputStream(), wStream);
        } catch (IOException ex) {
            LogUtil.logDevError(ex.getMessage());
        }
        this.save(fileInfo);
        return true;
    }

    @Override
    public void download(int fileId, HttpServletResponse response) {
        FileInfo fileInfo = this.getById(fileId);
        if (ObjectUtils.isEmpty(fileInfo)) {
            LogUtil.logDevError("文件不存在");
        } else {
            String filePath = fileInfo.getFilePath();
            try {
                FileInputStream inputStream = new FileInputStream(filePath);
                IOUtils.dump(inputStream, response.getOutputStream());
            } catch (IOException ex) {
                LogUtil.logDevError(ex.getMessage());
            }
        }
    }
}
