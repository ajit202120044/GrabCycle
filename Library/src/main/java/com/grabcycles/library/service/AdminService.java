package com.grabcycles.library.service;

import com.grabcycles.library.dto.AdminDto;
import com.grabcycles.library.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);
}
