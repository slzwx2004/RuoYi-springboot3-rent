package com.ruoyi.rent.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.rent.type.OperatingExpensesItemType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运营费用记录对象 rent_operating_expenses_record
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
public class RentOperatingExpensesRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 费用项目类型，1-水费；2-电费 */
//    @Excel(name = "费用项目类型，1-水费；2-电费")
    private String itemType;

    @Excel(name = "费用项目类型，1-水费；2-电费")
    private String itemTypeString;

    public String getItemTypeString(){
        //根据 OperatingExpensesItemType 的value，返回对应name
        if(OperatingExpensesItemType.WARTER_FEE.getValue().equals(itemType)){
            return OperatingExpensesItemType.WARTER_FEE.getName();
        }else {
            return OperatingExpensesItemType.ELECTRICITY_FEE.getName();
        }
    }

    @Excel(name = "费用")
    private String fee;


    public Double getFee() {
        if(endNum == null || startNum == null)  return 0d;
        if(OperatingExpensesItemType.WARTER_FEE.getValue().equals(itemType)){
            return OperatingExpensesItemType.WARTER_FEE.getFee()*(endNum - startNum);
        }else {
            return OperatingExpensesItemType.ELECTRICITY_FEE.getFee()*(endNum - startNum);
        }
    }

    /** 开始计算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始计算时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束计算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束计算时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 关联运营项表 */
    @Excel(name = "关联运营项表")
    private String operateId;

    /** 开始数 */
    @Excel(name = "开始数")
    private Long startNum;

    /** 结束数 */
    @Excel(name = "结束数")
    private Long endNum;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setItemType(String itemType) 
    {
        this.itemType = itemType;
    }

    public String getItemType() 
    {
        return itemType;
    }

    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }

    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    public void setOperateId(String operateId) 
    {
        this.operateId = operateId;
    }

    public String getOperateId() 
    {
        return operateId;
    }

    public void setStartNum(Long startNum) 
    {
        this.startNum = startNum;
    }

    public Long getStartNum() 
    {
        return startNum;
    }

    public void setEndNum(Long endNum) 
    {
        this.endNum = endNum;
    }

    public Long getEndNum() 
    {
        return endNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itemType", getItemType())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("operateId", getOperateId())
            .append("startNum", getStartNum())
            .append("endNum", getEndNum())
            .toString();
    }
}
