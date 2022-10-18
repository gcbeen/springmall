package com.gcbeen.springmall.service;

import java.io.File;
import java.io.InputStream;

import com.qiniu.common.QiniuException;

public interface IQiniuService {
    /**
     * 以文件的形式上传
     * 
     * @param file
     * @param fileName
     * @return String
     * @throws QiniuException
     */
    String uploadFile(File file, String fileName) throws QiniuException;

    /**
     * 以流的形式上传
     * 
     * @param InputStream
     * @param fileName
     * @return String
     * @throws QiniuException
     */
    String uploadFile(InputStream InputStream, String fileName) throws QiniuException;

    /**
     * 删除文件 
     * 
     * @param key
     * @return String
     * @throws QiniuException
     */
    String delete(String key) throws QiniuException;

}
