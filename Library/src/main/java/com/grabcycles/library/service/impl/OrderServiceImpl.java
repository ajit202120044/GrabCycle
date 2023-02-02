package com.grabcycles.library.service.impl;
import com.grabcycles.library.model.CartItem;
import com.grabcycles.library.model.Order;
import com.grabcycles.library.model.OrderDetail;
import com.grabcycles.library.model.ShoppingCart;
import com.grabcycles.library.repository.CartItemRepository;
import com.grabcycles.library.repository.OrderDetailsRepository;
import com.grabcycles.library.repository.OrderRepository;
import com.grabcycles.library.repository.ShoppingCartRepository;
import com.grabcycles.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ShoppingCartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public void saveOrder(ShoppingCart cart) {
        Order order = new Order();
        order.setOrderStatus("PENDING");
        order.setOrderDate(new Date());
        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrices());
        List<OrderDetail> orderDetailList= new ArrayList<>();
        for(CartItem item:cart.getCartItem()){
            OrderDetail orderDetail= new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setProduct(item.getProduct());
            orderDetail.setUnitPrice(item.getProduct().getCostPrice());
            orderDetailsRepository.save(orderDetail);
            orderDetailList.add(orderDetail);
            cartItemRepository.delete(item);
        }
        order.setOrderDetailList(orderDetailList);
        cart.setCartItem(new HashSet<>());
        cart.setTotalItems(0);
        cart.setTotalPrices(0);
        cartRepository.save(cart);
        orderRepository.save(order);

    }
}
