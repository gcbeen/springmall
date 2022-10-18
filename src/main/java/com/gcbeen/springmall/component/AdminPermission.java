package com.gcbeen.springmall.component;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gcbeen.springmall.mapper.IUmsAdminMapper;
import com.gcbeen.springmall.model.UmsAdmin;
import com.gcbeen.springmall.model.UmsPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class AdminPermission {

    @Autowired
    private IUmsAdminMapper adminMapper;

    public UmsAdmin getAdminByUsername(String username) {
        QueryWrapper<UmsAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UmsAdmin::getUsername, username);
        return adminMapper.selectOne(queryWrapper);
    }

    public List<UmsPermission> getPermissionList(Long adminId) {
        // 查询 角色权限
        return adminMapper.permissionList(adminId);
    }
}
