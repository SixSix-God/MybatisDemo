package com.mybatis.simple.controller;

import com.mybatis.simple.dao.UserMapper;
import com.mybatis.simple.model.CountryModel;
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

    @RequestMapping("/getAll")
    public List<CountryModel> getUsers() {
        List<CountryModel> users=userMapper.GetAll();
        return users;
    }

    @RequestMapping("/getOne")
    public CountryModel getUser(CountryModel countryModel) {

        CountryModel user=userMapper.GetOne(countryModel);
        return user;
    }

    @RequestMapping("/add")
    public void save(CountryModel user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(CountryModel user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        userMapper.delete(id);
    }
}
