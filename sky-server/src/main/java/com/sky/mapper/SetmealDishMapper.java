package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询对应的套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 根据套餐id查询菜品
     * @param id
     * @return
     */
    @Select("select * from sky_take_out.setmeal_dish where setmeal_id=#{id}")
    List<SetmealDish> selectById(Long id);

    /**
     * 批量插入菜品数据
     * @param setmealDishes
     */
    void insert(List<SetmealDish> setmealDishes);

    /**
     * 批量删除套餐关联的菜品数据
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 根据套餐id删除对应的菜品数据
     * @param id
     */
    @Delete("delete from sky_take_out.setmeal_dish where setmeal_id=#{id}")
    void deleteBySetmealId(Long id);
}
