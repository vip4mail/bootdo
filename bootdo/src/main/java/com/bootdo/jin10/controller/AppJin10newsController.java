package com.bootdo.jin10.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.jin10.domain.Jin10newsDO;
import com.bootdo.jin10.service.Jin10newsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-30 13:30:05
 */
 
@Controller
@RequestMapping("app/jin10/jin10news")
public class AppJin10newsController {
	@Autowired
	private Jin10newsService jin10newsService;
	
    /**
     * 查询
     */
    @ResponseBody
    @GetMapping("/list")
    public PageUtils appList(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<Jin10newsDO> jin10newsList = jin10newsService.list(query);
        int total = jin10newsService.count(query);
        PageUtils pageUtils = new PageUtils(jin10newsList, total);
        return pageUtils;
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R appSave( Jin10newsDO jin10news){
        if(jin10newsService.save(jin10news)>0){
            return R.ok();
        }
        return R.error();
    }
    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R appUpdate( Jin10newsDO jin10news){
        jin10newsService.update(jin10news);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping( "/remove")
    @ResponseBody
    public R appRemove( Integer id){
        if(jin10newsService.remove(id)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量删除
     */
    @PostMapping( "/batchRemove")
    @ResponseBody
    public R appBatchRemove(@RequestParam("ids[]") Integer[] ids){
        jin10newsService.batchRemove(ids);
        return R.ok();
    }
	
}
