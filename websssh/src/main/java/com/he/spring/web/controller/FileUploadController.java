package com.he.spring.web.controller;

import com.he.maven.module.utils.bean.Result;
import com.he.maven.module.utils.bean.Results;
import org.apache.commons.lang3.StringUtils;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    /**
     * 断点续传
     */
    @GetMapping(value = {"/webuploaderchunked","/webuploaderchunked/"})
    public String webuploaderchunked(Model model) {
        return "/upload/webuploader_chunked";
    }
    // Handling single file upload request


    private int count=0;


    /**
     *当使用 Servlet 3.0 multipart 解析时,你也可以使用 javax.servlet.http.Part 作为方法参数
     * @RequestParam("file") Part file
     * @RequestPart("file") MultipartFile file // MEINFO:2017/11/29 16:46 待验证
     */
    @PostMapping("/singleFileUpload")
    @ResponseBody
    public Result singleFileUpload(@RequestParam("file") MultipartFile file,String chunks,String chunk,String fileMd5) throws IOException {
        log.warn("*********************************"+count+++"***********************************************");
        log.warn(chunks);
        log.warn(chunk);
        log.warn(fileMd5);
        chunk=StringUtils.isEmpty(chunk)?"":chunk;

        File tempfile = new File("D:/tempfile"+"/"+fileMd5);
        if(!tempfile.exists()){
            tempfile.mkdir();
        }



        log.info(file.getContentType());//image/jpeg
        log.info(file.getName());//file
        log.info(file.getOriginalFilename());//58dc988e66f35.jpg
        log.info(file.getSize()+"");//402026
        log.info("{}",file.isEmpty());//false

        file.transferTo(new File(tempfile,fileMd5+chunk));//保存文件
//        file.transferTo(new File("D:/Temp"+File.separator+file.getOriginalFilename()));//保存文件

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
    @PostMapping("/checkChunk")
    @ResponseBody
    public Result checkChunk(String fileMd5,String chunk,Long chunkSize){
        Result result=Results.failure(1);
        log.error(fileMd5);
        log.warn("检查分块--"+chunk);
        log.error(chunkSize+"");

        File tempfile = new File("D:/tempfile"+"/"+fileMd5);
        if(!tempfile.exists()){
            tempfile.mkdir();
        }
        File[] files = tempfile.listFiles();
        for (int i = 0; i < files.length; i++) {
            if((files[i].getName().equals(fileMd5+chunk)||files[i].getName().equals(fileMd5))&&files[i].length()==chunkSize){
                result=Results.success();
            }
        }
        return result;

    }
    @PostMapping("/mergeChunk")
    @ResponseBody
    public Result mergeChunk(String fileMd5,String fileName){
        Result result=Results.failure(1);
        FileChannel destFileChannel=null;
        FileChannel sourceFileChannel=null;
        try {
            File sourceDir = new File("D:/tempfile" + "/" + fileMd5);
            File destDir = new File("D:/file");
            List<String> fileNameList = Arrays.asList(sourceDir.list());
            fileNameList.sort(Comparator.naturalOrder());


             destFileChannel = new FileOutputStream(new File(destDir,fileName), true).getChannel();

            for (int i = 0; i < fileNameList.size(); i++) {
                String sourcePath=fileMd5;
                if(fileNameList.size()!=1){
                    sourcePath+=i;
                }
                sourceFileChannel= new FileInputStream(new File(sourceDir,sourcePath)).getChannel();
                destFileChannel.transferFrom(sourceFileChannel, destFileChannel.size(), sourceFileChannel.size());
            }
            result=Results.success();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(sourceFileChannel!=null){
                    sourceFileChannel.close();
                }
                if(destFileChannel!=null){
                    destFileChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //region Description效率低10倍
        //        List<FileInputStream> list= Lists.newArrayList();
//        for (int i = 0; i < fileNameList.size(); i++) {
//            list.add(new FileInputStream(new File(sourceDir,fileMd5+i)));
//        }
//        Enumeration<FileInputStream> en = Collections.enumeration(list);
//        SequenceInputStream sis = new SequenceInputStream(en);
//        FileOutputStream fos = new FileOutputStream(new File(desDir,fileName));
//        byte[] by = new byte[1024];
//        int len = 0;
//        while((len = sis.read(by))!=-1){
//            fos.write(by, 0, len);
//        }
//        fos.close();
//        sis.close();
        //endregion


        return result;

    }
}
