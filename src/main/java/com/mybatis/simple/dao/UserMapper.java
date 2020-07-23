package com.mybatis.simple.dao;

import com.mybatis.simple.model.Country;

import java.util.List;

public interface UserMapper {
    List<Country> GetAll();

    Country GetOne(int id);

    void insert(Country user);

    void update(Country user);

    void delete(int id);
}
