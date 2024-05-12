package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface SetmealMapper {
    /**
     *根据id查询套餐数量
     * @param categoryId
     * @return
     */
    @Select("select count(*) from sky_take_out.setmeal where category_id=#{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    Page<Setmeal> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 新增套餐
     * @param setmeal
     */
    @AutoFill(value = OperationType.INSERT)
    void insert(Setmeal setmeal);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @Select("select * from sky_take_out.setmeal where id=#{id}")
    Setmeal selectById(Long id);

    /**
     * 批量删除套餐
     * @param ids
     */
    void delete(List<Long> ids);
}
