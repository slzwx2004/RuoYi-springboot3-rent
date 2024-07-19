package com.ruoyi.rent.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 楼宇管理对象 rent_house
 * 
 * @author ruoyi
 * @date 2024-07-18
 */
public class RentHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String id;

    /** 名字 */
    @Excel(name = "名字")
    private String name;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 房东ID */
    @Excel(name = "房东ID")
    private Long owerId;

    private String owerName = "未知";

    /** 状态：1-出租、0-闲置 */
    @Excel(name = "状态：1-出租、0-闲置")
    private String status;

    /** 水表数 */
    @Excel(name = "水表数")
    private Long waterNum;

    /** 电表数 */
    @Excel(name = "电表数")
    private Long electricPowerNum;

    /** 楼宇是否选中 默认不存在 */
    private boolean flag = false;

    public String getOwerName() {
        return owerName;
    }

    public void setOwerName(String owerName) {
        this.owerName = owerName;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setOwerId(Long owerId) 
    {
        this.owerId = owerId;
    }

    public Long getOwerId() 
    {
        return owerId;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setWaterNum(Long waterNum)
    {
        this.waterNum = waterNum;
    }

    public Long getWaterNum()
    {
        return waterNum;
    }

    public void setElectricPowerNum(Long electricPowerNum)
    {
        this.electricPowerNum = electricPowerNum;
    }

    public Long getElectricPowerNum()
    {
        return electricPowerNum;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("address", getAddress())
            .append("owerId", getOwerId())
            .append("waterNum", getWaterNum())
            .append("electricPowerNum", getElectricPowerNum())
            .append("status", getStatus())
            .toString();
    }
}
