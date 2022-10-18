package com.gcbeen.springmall.generator.service.impl;

import com.gcbeen.springmall.generator.entity.OrderItem;
import com.gcbeen.springmall.generator.mapper.OrderItemMapper;
import com.gcbeen.springmall.generator.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author mybatis plus generator
 * @since 2022-05-19
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
