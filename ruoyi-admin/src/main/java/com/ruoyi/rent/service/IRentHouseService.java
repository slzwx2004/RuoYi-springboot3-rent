package com.ruoyi.rent.service;

import java.util.List;
import com.ruoyi.rent.domain.RentHouse;

/**
 * 楼宇管理Service接口
 * 
 * @author ruoyi
 * @date 2024-07-18
 */
public interface IRentHouseService 
{
    /**
     * 查询楼宇管理
     * 
     * @param id 楼宇管理主键
     * @return 楼宇管理
     */
    public RentHouse selectRentHouseById(String id);

    /**
     * 查询楼宇管理列表
     * 
     * @param rentHouse 楼宇管理
     * @return 楼宇管理集合
     */
    public List<RentHouse> selectRentHouseList(RentHouse rentHouse);

    /**
     * 新增楼宇管理
     * 
     * @param rentHouse 楼宇管理
     * @return 结果
     */
    public int insertRentHouse(RentHouse rentHouse);

    /**
     * 修改楼宇管理
     * 
     * @param rentHouse 楼宇管理
     * @return 结果
     */
    public int updateRentHouse(RentHouse rentHouse);

    /**
     * 批量删除楼宇管理
     * 
     * @param ids 需要删除的楼宇管理主键集合
     * @return 结果
     */
    public int deleteRentHouseByIds(String ids);

    /**
     * 删除楼宇管理信息
     * 
     * @param id 楼宇管理主键
     * @return 结果
     */
    public int deleteRentHouseById(String id);
}
