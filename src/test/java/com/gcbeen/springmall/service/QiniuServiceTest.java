package com.gcbeen.springmall.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.gcbeen.springmall.SpringmallApplication;
import com.qiniu.common.QiniuException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringmallApplication.class)
public class QiniuServiceTest {

    @Autowired
    private IQiniuService qiniuService;

    @Test
    public void testUpload() throws QiniuException {
        File file = new File("/Users/gcbeen/00-guide/back_end_pro/testPic/yangjian.jpg");
        String result = qiniuService.uploadFile(file, "yangjian");
        System.out.println("访问地址：" + result);
    }


    @Test
    public void testUpload2() throws QiniuException, FileNotFoundException {
        File file = new File("/Users/gcbeen/00-guide/back_end_pro/testPic/yangjian.jpg");
        InputStream inputStream = new FileInputStream(file);
        String result = qiniuService.uploadFile(inputStream, "yangjian");
        System.out.println("访问地址：" + result);
    }

    @Test
    public void testDelete() throws QiniuException {
        String result = qiniuService.delete("yangjian");
        System.out.println(result);
    }
}
