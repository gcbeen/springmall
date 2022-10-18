package com.gcbeen.springmall.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gcbeen.springmall.model.UmsAdmin;
import com.gcbeen.springmall.model.UmsPermission;

public interface IUmsAdminMapper extends BaseMapper<UmsAdmin> {
    public List<UmsPermission> permissionList(Long adminId);
}
