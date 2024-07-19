package com.ruoyi.rent.controller;

import java.util.List;

import com.ruoyi.rent.domain.RentHouse;
import com.ruoyi.rent.service.IRentHouseService;
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
import com.ruoyi.rent.domain.RentOperatingRecord;
import com.ruoyi.rent.service.IRentOperatingRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运营记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
@Controller
@RequestMapping("/rent/operaterecord")
public class RentOperatingRecordController extends BaseController
{
    private String prefix = "rent/operaterecord";

    @Autowired
    private IRentOperatingRecordService rentOperatingRecordService;
    @Autowired
    private IRentHouseService rentHouseService;

    @RequiresPermissions("rent:operaterecord:view")
    @GetMapping()
    public String operaterecord()
    {
        return prefix + "/operaterecord";
    }

    /**
     * 查询运营记录列表
     */
    @RequiresPermissions("rent:operaterecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RentOperatingRecord rentOperatingRecord)
    {
        startPage();
        List<RentOperatingRecord> list = rentOperatingRecordService.selectRentOperatingRecordList(rentOperatingRecord);
        return getDataTable(list);
    }

    /**
     * 导出运营记录列表
     */
    @RequiresPermissions("rent:operaterecord:export")
    @Log(title = "运营记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RentOperatingRecord rentOperatingRecord)
    {
        List<RentOperatingRecord> list = rentOperatingRecordService.selectRentOperatingRecordList(rentOperatingRecord);
        ExcelUtil<RentOperatingRecord> util = new ExcelUtil<RentOperatingRecord>(RentOperatingRecord.class);
        return util.exportExcel(list, "运营记录数据");
    }

    /**
     * 新增运营记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        RentHouse rentHouse = new RentHouse();
        if(!this.getSysUser().isAdmin() && rentHouse != null)
            rentHouse.setOwerId(this.getUserId());
        List<RentHouse> list = rentHouseService.selectRentHouseList(rentHouse);
        mmap.put("houses", list);
        return prefix + "/add";
    }

    /**
     * 新增保存运营记录
     */
    @RequiresPermissions("rent:operaterecord:add")
    @Log(title = "运营记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RentOperatingRecord rentOperatingRecord)
    {
        return toAjax(rentOperatingRecordService.insertRentOperatingRecord(rentOperatingRecord));
    }

    /**
     * 修改运营记录
     */
    @RequiresPermissions("rent:operaterecord:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        RentHouse rentHouse = new RentHouse();
        if(!this.getSysUser().isAdmin() && rentHouse != null)
            rentHouse.setOwerId(this.getUserId());
        List<RentHouse> list = rentHouseService.selectRentHouseList(rentHouse);
        RentOperatingRecord rentOperatingRecord = rentOperatingRecordService.selectRentOperatingRecordById(id);
        //list中的id与rentOperatingRecord的houseid一致，则设置list中对应的flag为true
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getId().equals(rentOperatingRecord.getHouseId()))
            {
                list.get(i).setFlag(true);
            }
        }
        mmap.put("houses", list);
        mmap.put("rentOperatingRecord", rentOperatingRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存运营记录
     */
    @RequiresPermissions("rent:operaterecord:edit")
    @Log(title = "运营记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RentOperatingRecord rentOperatingRecord)
    {
        return toAjax(rentOperatingRecordService.updateRentOperatingRecord(rentOperatingRecord));
    }

    /**
     * 删除运营记录
     */
    @RequiresPermissions("rent:operaterecord:remove")
    @Log(title = "运营记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rentOperatingRecordService.deleteRentOperatingRecordByIds(ids));
    }
}
