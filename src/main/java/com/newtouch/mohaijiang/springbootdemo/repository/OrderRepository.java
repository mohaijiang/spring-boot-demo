package com.newtouch.mohaijiang.springbootdemo.repository;

import com.newtouch.mohaijiang.springbootdemo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    /**
     * 根据订单号查询
     * @param orderNo
     * @return
     */
    Order findTop1ByOrderNo(String orderNo);

    Order findTopByOrderByOrderNoDesc();

    /**
     * 允许 Optional 查询
     * @param orderNo
     * @param amount
     * @return
     */
    Optional<Order> findTopByOrderNoAndAmountGreaterThan(String orderNo, BigDecimal amount);

    /**
     * 根据某个属性查询，查询前8个
     * @param status
     * @return
     */
    List<Order> findTop8ByStatus(Integer status);

    /**
     * 根据字段，分页查询
     * @param status
     * @param pageable
     * @return
     */
    Page<Order> findByStatusOrderByOrderNoDesc(Integer status, Pageable pageable);
}
