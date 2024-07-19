package com.ruoyi.rent.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运营记录对象 rent_operating_record
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
public class RentOperatingRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 楼宇名称 */
    @Excel(name = "楼宇名称")
    private String houseName;

    /** 水表数 */
    @Excel(name = "水表数")
    private Long waterNum;

    /** 电表数 */
    @Excel(name = "电表数")
    private Long electricPowerNum;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    /** 关联出租楼宇表 */
    @Excel(name = "关联出租楼宇表")
    private String houseId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
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

    public void setRecordTime(Date recordTime) 
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime() 
    {
        return recordTime;
    }

    public void setHouseId(String houseId) 
    {
        this.houseId = houseId;
    }

    public String getHouseId() 
    {
        return houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("waterNum", getWaterNum())
            .append("electricPowerNum", getElectricPowerNum())
            .append("recordTime", getRecordTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("houseId", getHouseId())
            .toString();
    }
}
