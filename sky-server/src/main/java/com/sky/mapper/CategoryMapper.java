package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 新增分类
     *
     * @param category
     */
    @Insert("insert into " +
            "sky_take_out.category " +
            "(type, name, sort, status, create_time, update_time, create_user, update_user) " +
            "values " +
            "(#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser});")
    @AutoFill(value = OperationType.INSERT)
    void insert(Category category);

    /**
     * 启用、禁用分类
     *
     * @param category
     */
    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);

    /**
     * 根据id删除分类
     *
     * @param id
     */
    @Delete("delete from sky_take_out.category where id=#{id}")
    void delete(Long id);

    /**
     * 根据类型查询分类
     * @param type
     */
    List<Category> list(Integer type);

    /**
     * 根据菜品id查询分类名称
     * @param categoryId
     * @return
     */
    @Select("select * from sky_take_out.category where id=#{categoryId}")
    String selectNameById(Long categoryId);
}
