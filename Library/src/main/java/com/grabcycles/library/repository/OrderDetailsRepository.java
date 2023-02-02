package com.grabcycles.library.repository;

import com.grabcycles.library.model.Order;
import com.grabcycles.library.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetail,Long> {

}
