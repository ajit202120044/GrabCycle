package com.grabcycles.library.service;

import com.grabcycles.library.model.Customer;
import com.grabcycles.library.model.Product;
import com.grabcycles.library.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart addItemToCart(Product product, int quantity, Customer customer);

    ShoppingCart updateItemInCart(Product product, int quantity, Customer customer);

    ShoppingCart deleteItemFromCart(Product product, Customer customer);

}
