package com.gcbeen.springmall.service;
/**
 * 前台订单管理 Service
 */

import com.gcbeen.springmall.dto.OrderParam;
import com.gcbeen.springmall.util.Result;

import org.springframework.transaction.annotation.Transactional;
/**
 * 前台订单管理 Service
 */
public interface IOmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     * @param orderParam
     * @return
     */
    @Transactional
    Result<Object> generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);

}
