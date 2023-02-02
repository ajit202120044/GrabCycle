package com.grabcycles.library.service;

import com.grabcycles.library.model.ShoppingCart;

public interface OrderService {
    void saveOrder(ShoppingCart cart);
}
