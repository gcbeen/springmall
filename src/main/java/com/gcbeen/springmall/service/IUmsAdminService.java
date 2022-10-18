package com.gcbeen.springmall.service;

import java.util.List;

import com.gcbeen.springmall.model.UmsAdmin;
import com.gcbeen.springmall.model.UmsPermission;

/**
 * 后台管理员 Service
 */
public interface IUmsAdminService {
    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
