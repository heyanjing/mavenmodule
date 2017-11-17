package com.he.spring.he8;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.util.Arrays;

/**
 * Created by heyanjing on 2017/11/17 15:00.
 */
public class Main {
private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args)throws Exception {

        DefaultConversionService cs = new DefaultConversionService();
        boolean b = cs.canConvert(String.class, Boolean.class);
        log.info("{}",b);
        Boolean convert = cs.convert("false", Boolean.class);
        log.info("{}",convert);


//        urlResource();
//        classPathResource();
//        fileSystemResource();

    }

    public static void urlResource()throws Exception{
        UrlResource resource = new UrlResource("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510912610934&di=51e1e9ed982d05a0f765f93ccfc7b4c2&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F19%2F83%2F30J58PICFBZ_1024.jpg");
        FileUtils.copyToFile(resource.getInputStream(),new File("D:\\Temp\\1.jpg"));
    }
    public static void classPathResource()throws Exception{
        ClassPathResource resource = new ClassPathResource("he8/qq.jpg");
        FileUtils.copyToFile(resource.getInputStream(),new File("D:\\Temp\\2.jpg"));
    }
    public static void fileSystemResource ()throws Exception{
        FileSystemResource  resource = new FileSystemResource("D:\\Temp");

        Arrays.asList(resource.getFile().listFiles()).forEach(f->log.info(f.getName()));
    }
}
