package com.ruoyi.rent.controller;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.rent.domain.RentHouse;
import com.ruoyi.rent.service.IRentHouseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 楼宇管理Controller
 * 
 * @author ruoyi
 * @date 2024-07-18
 */
@Controller
@RequestMapping("/rent/house")
public class RentHouseController extends BaseController
{
    private String prefix = "rent/house";

    @Autowired
    private IRentHouseService rentHouseService;
    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("rent:house:view")
    @GetMapping()
    public String house()
    {
        return prefix + "/house";
    }

    /**
     * 查询楼宇管理列表
     */
    @RequiresPermissions("rent:house:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RentHouse rentHouse)
    {
        startPage();
        List<RentHouse> list = rentHouseService.selectRentHouseList(rentHouse);
        return getDataTable(list);
    }

    /**
     * 导出楼宇管理列表
     */
    @RequiresPermissions("rent:house:export")
    @Log(title = "楼宇管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RentHouse rentHouse)
    {
        List<RentHouse> list = rentHouseService.selectRentHouseList(rentHouse);
        ExcelUtil<RentHouse> util = new ExcelUtil<RentHouse>(RentHouse.class);
        return util.exportExcel(list, "楼宇管理数据");
    }

    /**
     * 新增楼宇管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存楼宇管理
     */
    @RequiresPermissions("rent:house:add")
    @Log(title = "楼宇管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RentHouse rentHouse)
    {
        if(rentHouse != null) rentHouse.setOwerId(getUserId());
        return toAjax(rentHouseService.insertRentHouse(rentHouse));
    }

    /**
     * 修改楼宇管理
     */
    @RequiresPermissions("rent:house:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        RentHouse rentHouse = rentHouseService.selectRentHouseById(id);
        SysUser sysUser = userService.selectUserById(rentHouse.getOwerId());
        if(sysUser != null){
            rentHouse.setOwerName(sysUser.getUserName());
        }
        mmap.put("rentHouse", rentHouse);
        return prefix + "/edit";
    }

    /**
     * 修改保存楼宇管理
     */
    @RequiresPermissions("rent:house:edit")
    @Log(title = "楼宇管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RentHouse rentHouse)
    {
        if(rentHouse != null) {
            RentHouse rentHouseO = rentHouseService.selectRentHouseById(rentHouse.getId());
            rentHouse.setOwerId(rentHouseO.getOwerId());
        }
        return toAjax(rentHouseService.updateRentHouse(rentHouse));
    }

    /**
     * 删除楼宇管理
     */
    @RequiresPermissions("rent:house:remove")
    @Log(title = "楼宇管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rentHouseService.deleteRentHouseByIds(ids));
    }
}
