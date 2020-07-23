package com.mybatis.simple.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybatis.simple.dao.UserMapper;
import com.mybatis.simple.model.CountryModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import util.InitLogRecord;

import java.io.IOException;
import java.io.Reader;

public class CountryModelMapperTest {
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
            String json = mapper.writeValueAsString(userMapper.GetAll());
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }

    @Test
    public void testSelectOne(){
        InitLogRecord.initLog();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //将实体类转为json格式
            //String json = mapper.writeValueAsString(userMapper.GetOne(1));
            //System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void Insert(){
        InitLogRecord.initLog();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CountryModel country = new CountryModel("韩国","tr");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            boolean flag = userMapper.insert(country);
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void Update(){
        InitLogRecord.initLog();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CountryModel country1 = new CountryModel();
            country1.setCountryName("韩国");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            CountryModel country2 = userMapper.GetOne(country1);
            country2.setCountryCode("TR");
            boolean flag = userMapper.update(country2);
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

}
