package com.gcbeen.springmall.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// com.macro.mall.tiny.mbg.mapper.UmsPermissionMapper.BaseResultMap

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsAdminPermissionRelation implements Serializable {
    private Long id;

    private Long adminId;

    private Long permissionId;

    private Integer type;
}
