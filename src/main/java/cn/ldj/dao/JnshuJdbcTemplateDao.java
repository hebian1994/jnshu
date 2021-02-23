package cn.ldj.dao;

import cn.ldj.pojo.Jnshu;

import java.sql.SQLException;
import java.util.List;

import java.util.Set;

public interface JnshuJdbcTemplateDao<K,V> {

    public boolean doCreate(Jnshu vo)throws SQLException;

    public boolean doUpdate(Jnshu vo) throws SQLException;

    public boolean doRemove(int StudentNumbers)throws SQLException;

    public V findByStudentNumber(K StudentNumber)throws SQLException;

    public List<V> findAll()throws SQLException;

    public List<V> findAllBySplit(String column,String keyWord,Integer currentPage,Integer  lineSize)throws SQLException;

    public Integer getAllCount(String column,String keyWord)throws SQLException;
}

