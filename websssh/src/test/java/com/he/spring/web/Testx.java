package com.he.spring.web;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by heyanjing on 2017/11/10 8:34.
 */
public class Testx {
    private static final Logger log = LoggerFactory.getLogger(Testx.class);

    @Test
    public void test(){

        //region Description
        ////        性能相差10倍
//        try {
//            long startTime2=System.nanoTime(); //获取开始时间
//            MergerFile_2();
//            long endTime2=System.nanoTime(); //获取结束时间
//            log.warn("2程序运行时间： "+(endTime2-startTime2)+"ns");//2877394202ns
//            long startTime1=System.nanoTime(); //获取开始时间
//            MergerFile_1();
//            long endTime1=System.nanoTime(); //获取结束时间
//            log.warn("1程序运行时间： "+(endTime1-startTime1)+"ns");//200370474ns
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //endregion


        //region Description
        //        List<String > list= Lists.newArrayList();
//
//        list.add("asfdasdfasdf0");
//        list.add("asfdasdfasdf1");
//        list.add("asfdasdfasdf2");
//        list.add("asfdasdfasdf5");
//        list.add("asfdasdfasdf4");
//        list.add("asfdasdfasdf3");
//        list.add("asfdasdfasdf6");
//        list.add("asfdasdfasdf7");
//
//        list.sort(Comparator.naturalOrder());
//
//        log.info("{}",list);
        //endregion

    }


    public static void MergerFile_2() throws Exception {
        File sourceDir = new File("D:\\tempfile\\3288734ba6b703369ca796abc93e7b29");
        File destDir = new File("D:\\file");

        // 创建集合
        List<FileInputStream> list = new ArrayList<FileInputStream>();
        String[] list1 = sourceDir.list();
        List<String> strList = Arrays.asList(sourceDir.list());
        strList.sort(Comparator.naturalOrder());


        for (int i = 0; i < strList.size(); i++) {
            list.add(new FileInputStream(new File(sourceDir,"3288734ba6b703369ca796abc93e7b29"+i)));
        }

        // 通过流工具类，获取一个枚举对象
        Enumeration<FileInputStream> en = Collections.enumeration(list);

        // 源
        SequenceInputStream sis = new SequenceInputStream(en);

        // 写入目的文件
        FileOutputStream fos = new FileOutputStream(new File(destDir,"eclipse2.zip"));

        byte[] by = new byte[1024];
        int len = 0;
        while((len = sis.read(by))!=-1){
            fos.write(by, 0, len);
        }

        fos.close();
        sis.close();

    }
    public static void MergerFile_1() throws Exception {
        File path = new File("D:\\tempfile\\3288734ba6b703369ca796abc93e7b29");
        File destDir = new File("D:\\file");
        // 创建集合
        List<FileInputStream> list = new ArrayList<FileInputStream>();
        String[] list1 = path.list();
        List<String> strList = Arrays.asList(path.list());
        strList.sort(Comparator.naturalOrder());

        FileChannel destFileChannel = new FileOutputStream(new File(destDir,"eclipse1.zip"), true).getChannel();

        for (int i = 0; i < strList.size(); i++) {
            FileChannel sourceFileChannel = new FileInputStream(new File(path,"3288734ba6b703369ca796abc93e7b29"+i)).getChannel();
            destFileChannel.transferFrom(sourceFileChannel, destFileChannel.size(), sourceFileChannel.size());
            sourceFileChannel.close();
        }
        destFileChannel.close();

    }
    public static boolean mergeFiles(String[] fpaths, String resultPath) {
        if (fpaths == null || fpaths.length < 1 || StringUtils.isEmpty(resultPath)) {
            return false;
        }
        if (fpaths.length == 1) {
            return new File(fpaths[0]).renameTo(new File(resultPath));
        }

        File[] files = new File[fpaths.length];
        for (int i = 0; i < fpaths.length; i ++) {
            files[i] = new File(fpaths[i]);
            if (StringUtils.isEmpty(fpaths[i]) || !files[i].exists() || !files[i].isFile()) {
                return false;
            }
        }

        File resultFile = new File(resultPath);

        try {
            FileChannel resultFileChannel = new FileOutputStream(resultFile, true).getChannel();
            for (int i = 0; i < fpaths.length; i ++) {
                FileChannel blk = new FileInputStream(files[i]).getChannel();
                resultFileChannel.transferFrom(blk, resultFileChannel.size(), blk.size());
                blk.close();
            }
            resultFileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        for (int i = 0; i < fpaths.length; i ++) {
            files[i].delete();
        }

        return true;
    }
}








































