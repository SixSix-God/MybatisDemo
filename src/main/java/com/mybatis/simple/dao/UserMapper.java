package com.mybatis.simple.dao;

import com.mybatis.simple.model.CountryModel;

import java.util.List;

public interface UserMapper {
    List<CountryModel> GetAll();

    CountryModel GetOne(CountryModel country);

    boolean insert(CountryModel user);

    boolean update(CountryModel user);

    boolean delete(int id);
}
