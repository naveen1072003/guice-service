package com.gwidgets.service.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.gwidgets.dao.DBConfig;
import com.gwidgets.dto.ApiResponse;
import com.gwidgets.model.User;
import com.gwidgets.service.SimpleService;
import org.modelmapper.ModelMapper;

import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class SimpleServiceImpl implements SimpleService {

    @Inject
    private DBConfig dbConfig;

    @Inject
    private ModelMapper modelMapper;

    @Override
    public User getUser(String username) {
        try {
            Connection connection = DBConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from user");
            ResultSet rst = statement.executeQuery();
            User user = new User();
            while (rst.next()) {
                if (rst.getString(2).trim().equals(username)) {
                    user = User.builder().name(rst.getString(2)).build();
                    break;
                }
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return new User();
    }

    @Override
    public ApiResponse saveUser(User user) {
        try {
            Connection connection = DBConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into user (name) values (?)");
            User user1 = getUser(user.getName());
            if (user1.getName() == null) {
                statement.setString(1, user.getName());
                statement.execute();
                return new ApiResponse(Response.ok().build(), "User registered", user);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ApiResponse(Response.notModified().build(), "User already registered", "");
    }

    @Override
    public ApiResponse getAllUsers() {
        try {
            Connection connection = DBConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from user");
            ResultSet rst = statement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (rst.next()) {
                User user = new User();
                user.setName(rst.getString(2));
                userList.add(user);
            }
            User user = new User();
            modelMapper.map(userList.get(0),user);
            System.out.println(user);
            return new ApiResponse(Response.ok().build(), "Users fetched", userList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ApiResponse(Response.noContent().build(), "No user Found", "");
    }
}