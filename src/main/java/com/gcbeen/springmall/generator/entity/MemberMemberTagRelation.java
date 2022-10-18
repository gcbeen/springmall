package com.gcbeen.springmall.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户和标签关系表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2022-05-19
 */
@TableName("ums_member_member_tag_relation")
@ApiModel(value = "MemberMemberTagRelation对象", description = "用户和标签关系表")
public class MemberMemberTagRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long memberId;

    private Long tagId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "MemberMemberTagRelation{" +
            "id=" + id +
            ", memberId=" + memberId +
            ", tagId=" + tagId +
        "}";
    }
}
