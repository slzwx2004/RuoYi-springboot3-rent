package com.ruoyi.rent.mapper;

import java.util.List;
import com.ruoyi.rent.domain.RentOperatingRecord;

/**
 * 运营记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
public interface RentOperatingRecordMapper 
{
    /**
     * 查询运营记录
     * 
     * @param id 运营记录主键
     * @return 运营记录
     */
    public RentOperatingRecord selectRentOperatingRecordById(String id);

    /**
     * 查询运营记录列表
     * 
     * @param rentOperatingRecord 运营记录
     * @return 运营记录集合
     */
    public List<RentOperatingRecord> selectRentOperatingRecordList(RentOperatingRecord rentOperatingRecord);

    /**
     * 新增运营记录
     * 
     * @param rentOperatingRecord 运营记录
     * @return 结果
     */
    public int insertRentOperatingRecord(RentOperatingRecord rentOperatingRecord);

    /**
     * 修改运营记录
     * 
     * @param rentOperatingRecord 运营记录
     * @return 结果
     */
    public int updateRentOperatingRecord(RentOperatingRecord rentOperatingRecord);

    /**
     * 删除运营记录
     * 
     * @param id 运营记录主键
     * @return 结果
     */
    public int deleteRentOperatingRecordById(String id);

    /**
     * 批量删除运营记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRentOperatingRecordByIds(String[] ids);
}
