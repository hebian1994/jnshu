package cn.ldj.dao;

import cn.ldj.pojo.Jnshu;

import java.sql.SQLException;
import java.util.List;

public interface JnshuMybatisDao {

    public List findAll()throws SQLException;
    public Jnshu findByStudentNumber(int StudentNumber);
    public void doCreate(Jnshu jnshu)throws SQLException;
    public void doUpdate(Jnshu vo) throws SQLException;
    public void doRemove(int StudentNumber)throws SQLException;

}
