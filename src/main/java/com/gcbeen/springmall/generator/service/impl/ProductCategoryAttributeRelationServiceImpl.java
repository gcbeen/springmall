package com.gcbeen.springmall.generator.service.impl;

import com.gcbeen.springmall.generator.entity.ProductCategoryAttributeRelation;
import com.gcbeen.springmall.generator.mapper.ProductCategoryAttributeRelationMapper;
import com.gcbeen.springmall.generator.service.IProductCategoryAttributeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author mybatis plus generator
 * @since 2022-05-19
 */
@Service
public class ProductCategoryAttributeRelationServiceImpl extends ServiceImpl<ProductCategoryAttributeRelationMapper, ProductCategoryAttributeRelation> implements IProductCategoryAttributeRelationService {

}
