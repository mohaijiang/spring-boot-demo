package com.newtouch.mohaijiang.springbootdemo.repository;

import com.newtouch.mohaijiang.springbootdemo.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {


}
