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
 * 购物车表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2022-05-19
 */
@TableName("oms_cart_item")
@ApiModel(value = "CartItem对象", description = "购物车表")
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    private Long productSkuId;

    private Long memberId;

    @ApiModelProperty("购买数量")
    private Integer quantity;

    @ApiModelProperty("添加到购物车的价格")
    private BigDecimal price;

    @ApiModelProperty("销售属性1")
    private String sp1;

    @ApiModelProperty("销售属性2")
    private String sp2;

    @ApiModelProperty("销售属性3")
    private String sp3;

    @ApiModelProperty("商品主图")
    private String productPic;

    @ApiModelProperty("商品名称")
    private String productName;

    @ApiModelProperty("商品副标题（卖点）")
    private String productSubTitle;

    @ApiModelProperty("商品sku条码")
    private String productSkuCode;

    @ApiModelProperty("会员昵称")
    private String memberNickname;

    @ApiModelProperty("创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty("修改时间")
    private LocalDateTime modifyDate;

    @ApiModelProperty("是否删除")
    private Integer deleteStatus;

    @ApiModelProperty("商品分类")
    private Long productCategoryId;

    private String productBrand;

    private String productSn;

    @ApiModelProperty("商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]")
    private String productAttr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }
    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }
    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }
    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductSubTitle() {
        return productSubTitle;
    }

    public void setProductSubTitle(String productSubTitle) {
        this.productSubTitle = productSubTitle;
    }
    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }
    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }
    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    @Override
    public String toString() {
        return "CartItem{" +
            "id=" + id +
            ", productId=" + productId +
            ", productSkuId=" + productSkuId +
            ", memberId=" + memberId +
            ", quantity=" + quantity +
            ", price=" + price +
            ", sp1=" + sp1 +
            ", sp2=" + sp2 +
            ", sp3=" + sp3 +
            ", productPic=" + productPic +
            ", productName=" + productName +
            ", productSubTitle=" + productSubTitle +
            ", productSkuCode=" + productSkuCode +
            ", memberNickname=" + memberNickname +
            ", createDate=" + createDate +
            ", modifyDate=" + modifyDate +
            ", deleteStatus=" + deleteStatus +
            ", productCategoryId=" + productCategoryId +
            ", productBrand=" + productBrand +
            ", productSn=" + productSn +
            ", productAttr=" + productAttr +
        "}";
    }
}
