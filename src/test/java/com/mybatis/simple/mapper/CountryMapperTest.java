package com.mybatis.simple.mapper;

import com.mybatis.simple.dao.UserMapper;
import com.mybatis.simple.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import util.InitLogRecord;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName CountryMapperTest
 * @Description
 * @Author ShiZhiQian
 * @Date 2020/6/13 12:54
 **/
public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    private UserMapper userMapper;
    @BeforeClass
    public static void init(){
        InitLogRecord.initLog();
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
            resourceAsReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectAll(){
        InitLogRecord.initLog();
            SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.GetAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }

    @Test
    public void testSelectName(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Country selectAll = userMapper.GetOne(1);
            System.out.println(selectAll.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
