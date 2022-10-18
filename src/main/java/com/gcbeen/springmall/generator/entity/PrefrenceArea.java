package com.gcbeen.springmall.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 优选专区
 * </p>
 *
 * @author mybatis plus generator
 * @since 2022-05-19
 */
@TableName("cms_prefrence_area")
@ApiModel(value = "PrefrenceArea对象", description = "优选专区")
public class PrefrenceArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String subTitle;

    @ApiModelProperty("展示图片")
    private byte[] pic;

    private Integer sort;

    private Integer showStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    @Override
    public String toString() {
        return "PrefrenceArea{" +
            "id=" + id +
            ", name=" + name +
            ", subTitle=" + subTitle +
            ", pic=" + pic +
            ", sort=" + sort +
            ", showStatus=" + showStatus +
        "}";
    }
}
