package com.grabcycles.library.service;

import com.grabcycles.library.dto.CustomerDto;
import com.grabcycles.library.model.Customer;

public interface CustomerService {

    CustomerDto save(CustomerDto customerDto);

    Customer findByUsername(String username);

    Customer saveInfor(Customer customer);
}
