package com.mybatis.simple.mapper;

import com.mybatis.simple.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @ClassName CountryMapperTest
 * @Description
 * @Author ShiZhiQian
 * @Date 2020/6/13 12:54
 **/
public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    @BeforeClass
    public static void init(){
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

            SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Country> selectAll = sqlSession.selectList("selectAll");
            System.out.println(selectAll.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }


}
