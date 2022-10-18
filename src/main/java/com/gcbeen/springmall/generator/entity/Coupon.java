package com.gcbeen.springmall.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 优惠卷表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2022-05-19
 */
@TableName("sms_coupon")
@ApiModel(value = "Coupon对象", description = "优惠卷表")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券")
    private Integer type;

    private String name;

    @ApiModelProperty("使用平台：0->全部；1->移动；2->PC")
    private Integer platform;

    @ApiModelProperty("数量")
    private Integer count;

    @ApiModelProperty("金额")
    private BigDecimal amount;

    @ApiModelProperty("每人限领张数")
    private Integer perLimit;

    @ApiModelProperty("使用门槛；0表示无门槛")
    private BigDecimal minPoint;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ApiModelProperty("使用类型：0->全场通用；1->指定分类；2->指定商品")
    private Integer useType;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("发行数量")
    private Integer publishCount;

    @ApiModelProperty("已使用数量")
    private Integer useCount;

    @ApiModelProperty("领取数量")
    private Integer receiveCount;

    @ApiModelProperty("可以领取的日期")
    private LocalDateTime enableTime;

    @ApiModelProperty("优惠码")
    private String code;

    @ApiModelProperty("可领取的会员类型：0->无限时")
    private Integer memberLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Integer getPerLimit() {
        return perLimit;
    }

    public void setPerLimit(Integer perLimit) {
        this.perLimit = perLimit;
    }
    public BigDecimal getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(BigDecimal minPoint) {
        this.minPoint = minPoint;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }
    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }
    public Integer getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }
    public LocalDateTime getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(LocalDateTime enableTime) {
        this.enableTime = enableTime;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Integer getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    @Override
    public String toString() {
        return "Coupon{" +
            "id=" + id +
            ", type=" + type +
            ", name=" + name +
            ", platform=" + platform +
            ", count=" + count +
            ", amount=" + amount +
            ", perLimit=" + perLimit +
            ", minPoint=" + minPoint +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", useType=" + useType +
            ", note=" + note +
            ", publishCount=" + publishCount +
            ", useCount=" + useCount +
            ", receiveCount=" + receiveCount +
            ", enableTime=" + enableTime +
            ", code=" + code +
            ", memberLevel=" + memberLevel +
        "}";
    }
}
