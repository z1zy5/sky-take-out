package com.sky.controller.admin;

import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 套餐管理
 */
@RestController
@RequestMapping("/admin/setmeal")
@Slf4j
@Api(tags = "修改套餐相关接口")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    /**
     * 分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("分页查询:{}",setmealPageQueryDTO);
        PageResult pageResult=setmealService.page(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

}
