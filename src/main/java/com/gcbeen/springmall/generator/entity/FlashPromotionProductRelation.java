package com.gcbeen.springmall.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 商品限时购与商品关系表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2022-05-19
 */
@TableName("sms_flash_promotion_product_relation")
@ApiModel(value = "FlashPromotionProductRelation对象", description = "商品限时购与商品关系表")
public class FlashPromotionProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long flashPromotionId;

    @ApiModelProperty("编号")
    private Long flashPromotionSessionId;

    private Long productId;

    @ApiModelProperty("限时购价格")
    private BigDecimal flashPromotionPrice;

    @ApiModelProperty("限时购数量")
    private Integer flashPromotionCount;

    @ApiModelProperty("每人限购数量")
    private Integer flashPromotionLimit;

    @ApiModelProperty("排序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getFlashPromotionId() {
        return flashPromotionId;
    }

    public void setFlashPromotionId(Long flashPromotionId) {
        this.flashPromotionId = flashPromotionId;
    }
    public Long getFlashPromotionSessionId() {
        return flashPromotionSessionId;
    }

    public void setFlashPromotionSessionId(Long flashPromotionSessionId) {
        this.flashPromotionSessionId = flashPromotionSessionId;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public BigDecimal getFlashPromotionPrice() {
        return flashPromotionPrice;
    }

    public void setFlashPromotionPrice(BigDecimal flashPromotionPrice) {
        this.flashPromotionPrice = flashPromotionPrice;
    }
    public Integer getFlashPromotionCount() {
        return flashPromotionCount;
    }

    public void setFlashPromotionCount(Integer flashPromotionCount) {
        this.flashPromotionCount = flashPromotionCount;
    }
    public Integer getFlashPromotionLimit() {
        return flashPromotionLimit;
    }

    public void setFlashPromotionLimit(Integer flashPromotionLimit) {
        this.flashPromotionLimit = flashPromotionLimit;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "FlashPromotionProductRelation{" +
            "id=" + id +
            ", flashPromotionId=" + flashPromotionId +
            ", flashPromotionSessionId=" + flashPromotionSessionId +
            ", productId=" + productId +
            ", flashPromotionPrice=" + flashPromotionPrice +
            ", flashPromotionCount=" + flashPromotionCount +
            ", flashPromotionLimit=" + flashPromotionLimit +
            ", sort=" + sort +
        "}";
    }
}
