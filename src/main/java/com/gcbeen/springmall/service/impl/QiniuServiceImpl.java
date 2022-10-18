package com.gcbeen.springmall.service.impl;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import com.gcbeen.springmall.service.IQiniuService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QiniuServiceImpl implements IQiniuService, InitializingBean {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private BucketManager bucketManager;

    @Autowired
    private Auth auth;


    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.domain}")
    private String domain;

    // 上传策略
    private StringMap putPolicy; 

    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"width\":$(imageInfo.width), \"height\":${imageInfo.height}}");
    }

    @Override
    public String uploadFile(File file, String fileName) throws QiniuException {
        Response resp = this.uploadManager.put(file, fileName, getUploadToken());
        int retry = 0;
        while(resp.needRetry() && retry < 3) {
            resp = this.uploadManager.put(file, fileName, getUploadToken());
            retry++;
        }
        if (resp.statusCode == 200) {
            return "http://" + domain + "/" + fileName;
        }
        return "上传失败";
    }

    private String getUploadToken() {
        return this.auth.uploadToken(bucket, null, 3600, putPolicy);
    }

    @Override
    public String uploadFile(InputStream InputStream, String fileName) throws QiniuException {
        Response resp = this.uploadManager.put(InputStream, fileName, getUploadToken(), null, null);
        int retry = 0;
        while(resp.needRetry() && retry < 3) {
            resp = this.uploadManager.put(InputStream, fileName, getUploadToken(), null, null);
            retry++;
        }
        if (resp.statusCode == 200) {
            return "http://" + domain + "/" + fileName;
        }
        return "上传失败";
    }

    @Override
    public String delete(String key) throws QiniuException {
        Response resp = bucketManager.delete(this.bucket, key);
        int retry = 0;
        while(resp.needRetry() && retry < 3) {
            resp = bucketManager.delete(this.bucket, key);
            retry++;
        }
        return resp.statusCode == 200 ? "删除成功" : "删除失败";
    }


    // @Override
	// public String upload(HttpServletRequest request) {
    //     StringMap putPolicy = new StringMap();
    //     putPolicy.put("callbackUrl", "http://api.example.com/qiniu/upload/callback");
    //     putPolicy.put("callbackBody", "key=$(key)&hash=$(etag)&bucket=$(bucket)&fsize=$(fsize)");
    //     long expireSeconds = 3600;
    //     String upToken = this.auth.uploadToken(bucket, null, expireSeconds, putPolicy);
	// }
    
}
