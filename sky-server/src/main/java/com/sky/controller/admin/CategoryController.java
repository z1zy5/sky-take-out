package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 分类管理
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分类分页查询:{}",categoryService);
        PageResult pageResult=categoryService.page(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result save(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类:{}",categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 启用、禁用分类
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用、禁用分类")
    public Result startOrStop(@PathVariable Integer status,Long id){
        log.info("启用、禁用分类:status为{},id为{}",status,id);
        categoryService.startOrStop(status,id);
        return Result.success();
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类:{}",categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result delete(Long id){
        log.info("根据id删除分类:{}",id);
        categoryService.delete(id);
        return Result.success();
    }
}