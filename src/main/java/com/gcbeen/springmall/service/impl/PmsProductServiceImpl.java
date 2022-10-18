package com.gcbeen.springmall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gcbeen.springmall.mapper.IPmsProductMapper;
import com.gcbeen.springmall.model.PmsProduct;
import com.gcbeen.springmall.service.IPmsProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PmsProductServiceImpl extends ServiceImpl<IPmsProductMapper, PmsProduct> implements IPmsProductService {

    @Autowired
    IPmsProductMapper productMapper;

    public IPage<PmsProduct> pageList(Integer pageNum, Integer pageSize, Integer brandId) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个

        Page<PmsProduct> page = new Page<>(pageNum, pageSize);
        return productMapper.pageList(page, brandId);
    }
}
