package com.imooc.springboot.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ExcelWriterUtils {
    private final static Logger logger = LoggerFactory.getLogger(ExcelWriterUtils.class);

    public static void exportExcels(HttpServletResponse response, String fileName, String sheetName, List<List<String>> sheetRowList) {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        response.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
        try(ServletOutputStream outputStream = response.getOutputStream()) {
            ExcelWriter excelWriter = EasyExcel.write(outputStream).build();
            WriteSheet sheet = EasyExcel.writerSheet(sheetName).build();
            excelWriter.write(sheetRowList, sheet);
            excelWriter.finish();
            IOUtils.closeQuietly(excelWriter);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
        }
    }
}
