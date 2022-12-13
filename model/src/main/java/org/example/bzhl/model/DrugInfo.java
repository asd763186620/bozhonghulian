package org.example.bzhl.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName drug_info
 */
@TableName(value ="drug_info")
public class DrugInfo implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 药品代码
     */
    private String drugId;

    /**
     * 药品名字
     */
    private String drugName;

    /**
     * 药品价格
     */
    private BigDecimal drugPrice;

    /**
     * 商家名字
     */
    private String business;

    /**
     * 药品类型
     */
    private String drugType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 药品代码
     */
    public String getDrugId() {
        return drugId;
    }

    /**
     * 药品代码
     */
    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    /**
     * 药品名字
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * 药品名字
     */
    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    /**
     * 药品价格
     */
    public BigDecimal getDrugPrice() {
        return drugPrice;
    }

    /**
     * 药品价格
     */
    public void setDrugPrice(BigDecimal drugPrice) {
        this.drugPrice = drugPrice;
    }

    /**
     * 商家名字
     */
    public String getBusiness() {
        return business;
    }

    /**
     * 商家名字
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * 药品类型
     */
    public String getDrugType() {
        return drugType;
    }

    /**
     * 药品类型
     */
    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DrugInfo other = (DrugInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDrugId() == null ? other.getDrugId() == null : this.getDrugId().equals(other.getDrugId()))
            && (this.getDrugName() == null ? other.getDrugName() == null : this.getDrugName().equals(other.getDrugName()))
            && (this.getDrugPrice() == null ? other.getDrugPrice() == null : this.getDrugPrice().equals(other.getDrugPrice()))
            && (this.getBusiness() == null ? other.getBusiness() == null : this.getBusiness().equals(other.getBusiness()))
            && (this.getDrugType() == null ? other.getDrugType() == null : this.getDrugType().equals(other.getDrugType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDrugId() == null) ? 0 : getDrugId().hashCode());
        result = prime * result + ((getDrugName() == null) ? 0 : getDrugName().hashCode());
        result = prime * result + ((getDrugPrice() == null) ? 0 : getDrugPrice().hashCode());
        result = prime * result + ((getBusiness() == null) ? 0 : getBusiness().hashCode());
        result = prime * result + ((getDrugType() == null) ? 0 : getDrugType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drugId=").append(drugId);
        sb.append(", drugName=").append(drugName);
        sb.append(", drugPrice=").append(drugPrice);
        sb.append(", business=").append(business);
        sb.append(", drugType=").append(drugType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}