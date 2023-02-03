package com.grabcycles.customer.controller;

import com.grabcycles.library.model.*;
import com.grabcycles.library.repository.ProductRepository;
import com.grabcycles.library.service.CustomerService;
import com.grabcycles.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class OrderController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private  OrderService orderService;
    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/check-out")
    public String checkout(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        String username = principal.getName();
        Customer customer = customerService.findByUsername(username);
        if(customer.getPhoneNumber().trim().isEmpty() || customer.getAddress().trim().isEmpty()
                || customer.getCity().trim().isEmpty() || customer.getCountry().trim().isEmpty()){

            model.addAttribute("customer", customer);
            model.addAttribute("error", "You must fill the information after checkout!");
            return "account";
        }else{
            model.addAttribute("customer", customer);
            ShoppingCart cart = customer.getShoppingCart();
            model.addAttribute("cart", cart);
        }
        return "checkout";
    }

    @GetMapping("/order")
    public String order(Principal principal,Model model) throws Exception{
        try{
            if (principal == null) {
                return "redirect:/login";
            }
            String username = principal.getName();
            Customer customer = customerService.findByUsername(username);
            List<Order> orderList = customer.getOrders();
            model.addAttribute("orders", orderList);
        }catch(Exception e){
            throw new Exception("redirect:/404");
        }
        return "order";
    }
    @GetMapping("/save-order")
    public String saveOrder(Principal principal, RedirectAttributes attributes)throws Exception{
        try{
            if (principal == null) {
                return "redirect:/login";
            }
            String username = principal.getName();
            Customer customer = customerService.findByUsername(username);
            ShoppingCart cart = customer.getShoppingCart();

            Set<CartItem> cartItemSet = cart.getCartItem();

            for (CartItem cartItem:
                 cartItemSet) {
                Product product = cartItem.getProduct();
                product.setCurrentQuantity(product.getCurrentQuantity() - cartItem.getQuantity());
                productRepository.save(product);
            }

            orderService.saveOrder(cart);

        }catch(Exception e){
            throw new Exception("redirect:/404");

        }
        return "redirect:/order";
    }


}
