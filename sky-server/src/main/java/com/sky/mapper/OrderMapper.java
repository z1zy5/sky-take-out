package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface OrderMapper {

    /**
     * 添加订单表
     * @param orders
     */
    void insert(Orders orders);


    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);


    @Select("select * from orders where number = #{orderNumber} and user_id= #{userId}")
    Orders getByNumberAndUserId(String orderNumber, Long userId);


    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 订单分页查询
     * @param ordersPageQueryDTO
     * @return
     */
    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    Orders getById(Long id);


    /**
     * 根据状态统计订单数量
     * @param toBeConfirmed
     * @return
     */
    @Select("select count(id) from orders where status=#{status}")
    Integer countStatus(Integer toBeConfirmed);

}
