package com.he.spring.web.controller;

import com.he.maven.module.utils.bean.Result;
import com.he.maven.module.utils.bean.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by heyanjing on 2017/11/8 17:03.
 */
@Controller
@RequestMapping("/file/upload")
public class FileUploadController {
    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping(value = {"","/"})
    public String upload(Model model) {
        return "/upload/upload";
    }
    @GetMapping(value = {"/webuploader","/webuploader/"})
    public String webuploader(Model model) {
        return "/upload/webuploader";
    }
    // Handling single file upload request
    @PostMapping("/singleFileUpload")
    @ResponseBody
    public Result singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info(file.getContentType());//image/jpeg
        log.info(file.getName());//file
        log.info(file.getOriginalFilename());//58dc988e66f35.jpg
        log.info(file.getSize()+"");//402026
        log.info("{}",file.isEmpty());//false
        file.transferTo(new File("D:/Temp"+File.separator+file.getOriginalFilename()));//保存文件

        return Results.success();
    }

    // Handling multiple files upload request
    @PostMapping("/multipleFileUpload")
    @ResponseBody
    public Result multipleFileUpload(@RequestParam("files") MultipartFile[] files) throws IOException {

        // Save file on system
        for (MultipartFile file : files) {
            log.info(file.getContentType());//image/jpeg
            log.info(file.getName());//file
            log.info(file.getOriginalFilename());//58dc988e66f35.jpg
            log.info(file.getSize()+"");//402026
            log.info("{}",file.isEmpty());//false
            file.transferTo(new File("D:/Temp"+File.separator+file.getOriginalFilename()));//保存文件
        }
        return Results.success();
    }
}
