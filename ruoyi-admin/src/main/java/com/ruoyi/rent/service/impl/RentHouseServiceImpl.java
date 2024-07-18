package com.ruoyi.rent.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rent.mapper.RentHouseMapper;
import com.ruoyi.rent.domain.RentHouse;
import com.ruoyi.rent.service.IRentHouseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 楼宇管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-18
 */
@Service
public class RentHouseServiceImpl implements IRentHouseService 
{
    @Autowired
    private RentHouseMapper rentHouseMapper;

    /**
     * 查询楼宇管理
     * 
     * @param id 楼宇管理主键
     * @return 楼宇管理
     */
    @Override
    public RentHouse selectRentHouseById(String id)
    {
        return rentHouseMapper.selectRentHouseById(id);
    }

    /**
     * 查询楼宇管理列表
     * 
     * @param rentHouse 楼宇管理
     * @return 楼宇管理
     */
    @Override
    public List<RentHouse> selectRentHouseList(RentHouse rentHouse)
    {
        return rentHouseMapper.selectRentHouseList(rentHouse);
    }

    /**
     * 新增楼宇管理
     * 
     * @param rentHouse 楼宇管理
     * @return 结果
     */
    @Override
    public int insertRentHouse(RentHouse rentHouse)
    {
        return rentHouseMapper.insertRentHouse(rentHouse);
    }

    /**
     * 修改楼宇管理
     * 
     * @param rentHouse 楼宇管理
     * @return 结果
     */
    @Override
    public int updateRentHouse(RentHouse rentHouse)
    {
        return rentHouseMapper.updateRentHouse(rentHouse);
    }

    /**
     * 批量删除楼宇管理
     * 
     * @param ids 需要删除的楼宇管理主键
     * @return 结果
     */
    @Override
    public int deleteRentHouseByIds(String ids)
    {
        return rentHouseMapper.deleteRentHouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除楼宇管理信息
     * 
     * @param id 楼宇管理主键
     * @return 结果
     */
    @Override
    public int deleteRentHouseById(String id)
    {
        return rentHouseMapper.deleteRentHouseById(id);
    }
}
