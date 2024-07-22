package com.ruoyi.rent.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.rent.domain.RentHouse;
import com.ruoyi.rent.domain.RentOperatingExpensesRecord;
import com.ruoyi.rent.service.IRentHouseService;
import com.ruoyi.rent.service.IRentOperatingExpensesRecordService;
import com.ruoyi.rent.type.OperatingExpensesItemType;
import com.ruoyi.web.common.SnowFlakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rent.mapper.RentOperatingRecordMapper;
import com.ruoyi.rent.domain.RentOperatingRecord;
import com.ruoyi.rent.service.IRentOperatingRecordService;
import com.ruoyi.common.core.text.Convert;

import javax.transaction.Transactional;

/**
 * 运营记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
@Service
public class RentOperatingRecordServiceImpl implements IRentOperatingRecordService 
{
    @Autowired
    private RentOperatingRecordMapper rentOperatingRecordMapper;
    @Autowired
    private IRentHouseService rentHouseService;
    @Autowired
    private IRentOperatingExpensesRecordService rentOperatingExpensesRecordService;

    /**
     * 查询运营记录
     * 
     * @param id 运营记录主键
     * @return 运营记录
     */
    @Override
    public RentOperatingRecord selectRentOperatingRecordById(String id)
    {
        return rentOperatingRecordMapper.selectRentOperatingRecordById(id);
    }

    /**
     * 查询运营记录列表
     * 
     * @param rentOperatingRecord 运营记录
     * @return 运营记录
     */
    @Override
    public List<RentOperatingRecord> selectRentOperatingRecordList(RentOperatingRecord rentOperatingRecord)
    {
        return rentOperatingRecordMapper.selectRentOperatingRecordList(rentOperatingRecord);
    }

    /**
     * 新增运营记录
     * 
     * @param rentOperatingRecord 运营记录
     * @return 结果
     */
    @Override
    @Transactional
    public int insertRentOperatingRecord(RentOperatingRecord rentOperatingRecord)
    {
        rentOperatingRecord.setCreateTime(DateUtils.getNowDate());
        int result = rentOperatingRecordMapper.insertRentOperatingRecord(rentOperatingRecord);
        //this.addFeeRecord(rentOperatingRecord);
        return result;
    }

    /**
     * 根据运营记录，产生费用记录(需要先保存运营记录，否则ID会空)
     * @param rentOperatingRecord
     */
    private void addFeeRecord(RentOperatingRecord rentOperatingRecord){
        //从最新的运营记录中，查找最近的记录；如果没有，从楼宇管理中获取运营费用；
        long lastWaterNum = 0;
        long lastElectricPowerNum = 0;
        Date lastRecordDate = null;
        RentOperatingRecord searchRentOperatingRecord = new RentOperatingRecord();
        searchRentOperatingRecord.setHouseId(rentOperatingRecord.getHouseId());
        List<RentOperatingRecord> rentOperatingRecords = this.selectRentOperatingRecordList(searchRentOperatingRecord);
        if(rentOperatingRecords.size()>0){
            //需要剔除rentOperatingRecord.getOperateId()=RentOperatingRecord.getOperateId()的记录?
            lastWaterNum = rentOperatingRecords.get(0).getWaterNum();
            lastElectricPowerNum = rentOperatingRecords.get(0).getElectricPowerNum();
            lastRecordDate = rentOperatingRecords.get(0).getRecordTime();
        }else {
            RentHouse rentHouse = new RentHouse();
            rentHouse.setId(rentOperatingRecord.getHouseId());
            rentHouse = rentHouseService.selectRentHouseById(rentHouse.getId());
            lastElectricPowerNum = rentHouse.getElectricPowerNum();
            lastWaterNum = rentHouse.getWaterNum();
            lastRecordDate = rentHouse.getUpdateTime();
        }
        //增加费用记录数据
        RentOperatingExpensesRecord waterRecord = new RentOperatingExpensesRecord();
        waterRecord.setId(SnowFlakeIdGenerator.generate());
        waterRecord.setOperateId(rentOperatingRecord.getId());
        waterRecord.setItemType(OperatingExpensesItemType.WARTER_FEE.getValue());
        waterRecord.setStartNum(lastWaterNum);
        waterRecord.setEndNum(rentOperatingRecord.getWaterNum());
        waterRecord.setStartDate(lastRecordDate);
        waterRecord.setEndDate(rentOperatingRecord.getRecordTime());
        waterRecord.setCreateTime(DateUtils.getNowDate());
        rentOperatingExpensesRecordService.insertRentOperatingExpensesRecord(waterRecord);

        RentOperatingExpensesRecord electricRecord = new RentOperatingExpensesRecord();
        electricRecord.setId(SnowFlakeIdGenerator.generate());
        electricRecord.setOperateId(rentOperatingRecord.getId());
        electricRecord.setItemType(OperatingExpensesItemType.ELECTRICITY_FEE.getValue());
        electricRecord.setStartNum(lastElectricPowerNum);
        electricRecord.setEndNum(rentOperatingRecord.getElectricPowerNum());
        electricRecord.setStartDate(lastRecordDate);
        electricRecord.setEndDate(rentOperatingRecord.getRecordTime());
        electricRecord.setCreateTime(DateUtils.getNowDate());
        rentOperatingExpensesRecordService.insertRentOperatingExpensesRecord(electricRecord);
    }

    private void removeFeeRecord(RentOperatingRecord rentOperatingRecord){
        rentOperatingExpensesRecordService.deleteRentOperatingExpensesRecordByOperateId(rentOperatingRecord.getId());
    }

    /**
     * 修改运营记录
     * 
     * @param rentOperatingRecord 运营记录
     * @return 结果
     */
    @Override
    public int updateRentOperatingRecord(RentOperatingRecord rentOperatingRecord)
    {
        //this.removeFeeRecord(rentOperatingRecord);
        //this.addFeeRecord(rentOperatingRecord);
        rentOperatingRecord.setUpdateTime(DateUtils.getNowDate());
        return rentOperatingRecordMapper.updateRentOperatingRecord(rentOperatingRecord);
    }

    /**
     * 批量删除运营记录
     * 
     * @param ids 需要删除的运营记录主键
     * @return 结果
     */
    @Override
    public int deleteRentOperatingRecordByIds(String ids)
    {
        return rentOperatingRecordMapper.deleteRentOperatingRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除运营记录信息
     * 
     * @param id 运营记录主键
     * @return 结果
     */
    @Override
    public int deleteRentOperatingRecordById(String id)
    {
        return rentOperatingRecordMapper.deleteRentOperatingRecordById(id);
    }
}
