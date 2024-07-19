package com.ruoyi.rent.controller;

import java.util.List;
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
import com.ruoyi.rent.domain.RentOperatingExpensesRecord;
import com.ruoyi.rent.service.IRentOperatingExpensesRecordService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运营费用记录Controller
 * 
 * @author ruoyi
 * @date 2024-07-19
 */
@Controller
@RequestMapping("/rent/operatefeerecord")
public class RentOperatingExpensesRecordController extends BaseController
{
    private String prefix = "rent/operatefeerecord";

    @Autowired
    private IRentOperatingExpensesRecordService rentOperatingExpensesRecordService;

    @RequiresPermissions("rent:operatefeerecord:view")
    @GetMapping()
    public String operatefeerecord()
    {
        return prefix + "/operatefeerecord";
    }

    /**
     * 查询运营费用记录列表
     */
    @RequiresPermissions("rent:operatefeerecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RentOperatingExpensesRecord rentOperatingExpensesRecord)
    {
        startPage();
        List<RentOperatingExpensesRecord> list = rentOperatingExpensesRecordService.selectRentOperatingExpensesRecordList(rentOperatingExpensesRecord);
        return getDataTable(list);
    }

    /**
     * 导出运营费用记录列表
     */
    @RequiresPermissions("rent:operatefeerecord:export")
    @Log(title = "运营费用记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RentOperatingExpensesRecord rentOperatingExpensesRecord)
    {
        List<RentOperatingExpensesRecord> list = rentOperatingExpensesRecordService.selectRentOperatingExpensesRecordList(rentOperatingExpensesRecord);
        ExcelUtil<RentOperatingExpensesRecord> util = new ExcelUtil<RentOperatingExpensesRecord>(RentOperatingExpensesRecord.class);
        return util.exportExcel(list, "运营费用记录数据");
    }

    /**
     * 新增运营费用记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存运营费用记录
     */
    @RequiresPermissions("rent:operatefeerecord:add")
    @Log(title = "运营费用记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RentOperatingExpensesRecord rentOperatingExpensesRecord)
    {
        return toAjax(rentOperatingExpensesRecordService.insertRentOperatingExpensesRecord(rentOperatingExpensesRecord));
    }

    /**
     * 修改运营费用记录
     */
    @RequiresPermissions("rent:operatefeerecord:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        RentOperatingExpensesRecord rentOperatingExpensesRecord = rentOperatingExpensesRecordService.selectRentOperatingExpensesRecordById(id);
        mmap.put("rentOperatingExpensesRecord", rentOperatingExpensesRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存运营费用记录
     */
    @RequiresPermissions("rent:operatefeerecord:edit")
    @Log(title = "运营费用记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RentOperatingExpensesRecord rentOperatingExpensesRecord)
    {
        return toAjax(rentOperatingExpensesRecordService.updateRentOperatingExpensesRecord(rentOperatingExpensesRecord));
    }

    /**
     * 删除运营费用记录
     */
    @RequiresPermissions("rent:operatefeerecord:remove")
    @Log(title = "运营费用记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rentOperatingExpensesRecordService.deleteRentOperatingExpensesRecordByIds(ids));
    }
}
