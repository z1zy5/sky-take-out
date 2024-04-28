package com.sky.mapper;

import com.sky.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {
    /**
     *根据id查询套餐数量
     * @param categoryId
     * @return
     */
    @Select("select count(*) from sky_take_out.setmeal where category_id=#{categoryId}")
    Integer countByCategoryId(Long categoryId);
}
