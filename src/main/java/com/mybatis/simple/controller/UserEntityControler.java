package com.mybatis.simple.controller;

import com.mybatis.simple.dao.UserMapper;
import com.mybatis.simple.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntityControler {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<Country> getUsers() {
        List<Country> users=userMapper.GetAll();
        return users;
    }

    @RequestMapping("/getUser")
    public Country getUser(int id) {
        Country user=userMapper.GetOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(Country user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(Country user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        userMapper.delete(id);
    }
}
