package com.gcbeen.springmall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gcbeen.springmall.model.PmsProduct;

public interface IPmsProductService extends IService<PmsProduct> {
    public IPage<PmsProduct> pageList(Integer pageNum, Integer pageSize, Integer brandId);
}
