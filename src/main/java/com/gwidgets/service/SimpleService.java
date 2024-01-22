package com.gwidgets.service;

import com.gwidgets.dto.ApiResponse;
import com.gwidgets.model.User;

public interface SimpleService {

    User getUser(String name);

    ApiResponse saveUser(User user);

    ApiResponse getAllUsers();
}