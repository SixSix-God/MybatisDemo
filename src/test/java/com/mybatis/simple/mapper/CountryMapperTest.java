package com.mybatis.simple.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    //创建jackson的核心对象 ObjectMapper
    ObjectMapper mapper = new ObjectMapper();
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
        InitLogRecord.initLog();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //将实体类转为json格式
            String json = mapper.writeValueAsString(userMapper.GetOne(1));
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

}
