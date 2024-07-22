package com.ruoyi.rent.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rent.mapper.RentOperatingExpensesRecordMapper;
import com.ruoyi.rent.domain.RentOperatingExpensesRecord;
import com.ruoyi.rent.service.IRentOperatingExpensesRecordService;
import com.ruoyi.common.core.text.Convert;

/**
 * 运营费用记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
@Service
public class RentOperatingExpensesRecordServiceImpl implements IRentOperatingExpensesRecordService 
{
    @Autowired
    private RentOperatingExpensesRecordMapper rentOperatingExpensesRecordMapper;

    /**
     * 查询运营费用记录
     * 
     * @param id 运营费用记录主键
     * @return 运营费用记录
     */
    @Override
    public RentOperatingExpensesRecord selectRentOperatingExpensesRecordById(String id)
    {
        return rentOperatingExpensesRecordMapper.selectRentOperatingExpensesRecordById(id);
    }

    /**
     * 查询运营费用记录列表
     * 
     * @param rentOperatingExpensesRecord 运营费用记录
     * @return 运营费用记录
     */
    @Override
    public List<RentOperatingExpensesRecord> selectRentOperatingExpensesRecordList(RentOperatingExpensesRecord rentOperatingExpensesRecord)
    {
        return rentOperatingExpensesRecordMapper.selectRentOperatingExpensesRecordList(rentOperatingExpensesRecord);
    }

    /**
     * 新增运营费用记录
     * 
     * @param rentOperatingExpensesRecord 运营费用记录
     * @return 结果
     */
    @Override
    public int insertRentOperatingExpensesRecord(RentOperatingExpensesRecord rentOperatingExpensesRecord)
    {
        rentOperatingExpensesRecord.setCreateTime(DateUtils.getNowDate());
        return rentOperatingExpensesRecordMapper.insertRentOperatingExpensesRecord(rentOperatingExpensesRecord);
    }

    /**
     * 修改运营费用记录
     * 
     * @param rentOperatingExpensesRecord 运营费用记录
     * @return 结果
     */
    @Override
    public int updateRentOperatingExpensesRecord(RentOperatingExpensesRecord rentOperatingExpensesRecord)
    {
        rentOperatingExpensesRecord.setUpdateTime(DateUtils.getNowDate());
        return rentOperatingExpensesRecordMapper.updateRentOperatingExpensesRecord(rentOperatingExpensesRecord);
    }

    /**
     * 批量删除运营费用记录
     * 
     * @param ids 需要删除的运营费用记录主键
     * @return 结果
     */
    @Override
    public int deleteRentOperatingExpensesRecordByIds(String ids)
    {
        return rentOperatingExpensesRecordMapper.deleteRentOperatingExpensesRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除运营费用记录信息
     * 
     * @param id 运营费用记录主键
     * @return 结果
     */
    @Override
    public int deleteRentOperatingExpensesRecordById(String id)
    {
        return rentOperatingExpensesRecordMapper.deleteRentOperatingExpensesRecordById(id);
    }

    @Override
    public void deleteRentOperatingExpensesRecordByOperateId(String id) {
        rentOperatingExpensesRecordMapper.deleteRentOperatingExpensesRecordByOperateId(id);
    }
}
