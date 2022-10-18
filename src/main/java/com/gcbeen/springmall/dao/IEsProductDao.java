package com.gcbeen.springmall.dao;

import java.util.List;


import com.gcbeen.springmall.nosql.elasticsearch.document.EsProduct;

import org.apache.ibatis.annotations.Param;

/**
 * 搜索系统中的商品管理自定义Dao
 */

public interface IEsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}