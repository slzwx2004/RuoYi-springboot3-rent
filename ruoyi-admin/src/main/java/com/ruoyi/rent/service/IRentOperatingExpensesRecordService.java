package com.ruoyi.rent.service;

import java.util.List;
import com.ruoyi.rent.domain.RentOperatingExpensesRecord;

/**
 * 运营费用记录Service接口
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
public interface IRentOperatingExpensesRecordService 
{
    /**
     * 查询运营费用记录
     * 
     * @param id 运营费用记录主键
     * @return 运营费用记录
     */
    public RentOperatingExpensesRecord selectRentOperatingExpensesRecordById(String id);

    /**
     * 查询运营费用记录列表
     * 
     * @param rentOperatingExpensesRecord 运营费用记录
     * @return 运营费用记录集合
     */
    public List<RentOperatingExpensesRecord> selectRentOperatingExpensesRecordList(RentOperatingExpensesRecord rentOperatingExpensesRecord);

    /**
     * 新增运营费用记录
     * 
     * @param rentOperatingExpensesRecord 运营费用记录
     * @return 结果
     */
    public int insertRentOperatingExpensesRecord(RentOperatingExpensesRecord rentOperatingExpensesRecord);

    /**
     * 修改运营费用记录
     * 
     * @param rentOperatingExpensesRecord 运营费用记录
     * @return 结果
     */
    public int updateRentOperatingExpensesRecord(RentOperatingExpensesRecord rentOperatingExpensesRecord);

    /**
     * 批量删除运营费用记录
     * 
     * @param ids 需要删除的运营费用记录主键集合
     * @return 结果
     */
    public int deleteRentOperatingExpensesRecordByIds(String ids);

    /**
     * 删除运营费用记录信息
     * 
     * @param id 运营费用记录主键
     * @return 结果
     */
    public int deleteRentOperatingExpensesRecordById(String id);

    void deleteRentOperatingExpensesRecordByOperateId(String id);
}
