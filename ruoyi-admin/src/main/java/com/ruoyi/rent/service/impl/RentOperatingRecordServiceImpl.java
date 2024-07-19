package com.ruoyi.rent.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rent.mapper.RentOperatingRecordMapper;
import com.ruoyi.rent.domain.RentOperatingRecord;
import com.ruoyi.rent.service.IRentOperatingRecordService;
import com.ruoyi.common.core.text.Convert;

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
    public int insertRentOperatingRecord(RentOperatingRecord rentOperatingRecord)
    {
        rentOperatingRecord.setCreateTime(DateUtils.getNowDate());
        return rentOperatingRecordMapper.insertRentOperatingRecord(rentOperatingRecord);
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
