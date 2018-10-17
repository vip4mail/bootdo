package com.bootdo.jin10.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.jin10.domain.Jin10newsDO;
import com.bootdo.jin10.service.Jin10newsService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-30 13:30:05
 */
 
@Controller
@RequestMapping("/jin10/jin10news")
public class Jin10newsController {
	@Autowired
	private Jin10newsService jin10newsService;
	
	@GetMapping()
	@RequiresPermissions("jin10:jin10news:jin10news")
	String Jin10news(){
	    return "jin10/jin10news/jin10news";
	}
	
	@GetMapping("/add")
	@RequiresPermissions("jin10:jin10news:add")
	String add(){
	    return "jin10/jin10news/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("jin10:jin10news:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		Jin10newsDO jin10news = jin10newsService.get(id);
		model.addAttribute("jin10news", jin10news);
	    return "jin10/jin10news/edit";
	}

    /**
     * 查询
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("jin10:jin10news:jin10news")
    public PageUtils list(@RequestParam Map<String, Object> params){
        //查询列表数据
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
	@RequiresPermissions("jin10:jin10news:add")
	public R save( Jin10newsDO jin10news){
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
	@RequiresPermissions("jin10:jin10news:edit")
	public R update( Jin10newsDO jin10news){
		jin10newsService.update(jin10news);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("jin10:jin10news:remove")
	public R remove( Integer id){
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
	@RequiresPermissions("jin10:jin10news:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		jin10newsService.batchRemove(ids);
		return R.ok();
	}

}
