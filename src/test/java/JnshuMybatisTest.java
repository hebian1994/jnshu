import cn.ldj.dao.JnshuMybatisDao;
import cn.ldj.pojo.Jnshu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JnshuMybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("JnshuMybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    @Test
//查询所有
    public void findAll() throws SQLException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            JnshuMybatisDao empOperation = session.getMapper(JnshuMybatisDao.class);
            List maps3=empOperation.findAll();
            for(int i=0;i<maps3.size();i++){
                Jnshu jnshu= (Jnshu) maps3.get(i);
                System.out.println(jnshu.getName()+jnshu.getStudentNumber());
            }
            session.commit();
        } finally {
            session.close();
        }
    }
    @Test
//据学号查询
public void findByStudentNumber() throws SQLException {
    SqlSession session = sqlSessionFactory.openSession();
    try {
        JnshuMybatisDao empOperation = session.getMapper(JnshuMybatisDao.class);
        Jnshu jnshu=empOperation.findByStudentNumber(111);
        System.out.println(jnshu.getName()+jnshu.getQq());
        session.commit();
    } finally {
        session.close();
    }
}

@Test
public void doCreate() throws SQLException {
    SqlSession session = sqlSessionFactory.openSession();
    try {
        Jnshu jnshu=new Jnshu();
        jnshu.setName("清圣祖");jnshu.setQq(123123);jnshu.setType("太祖");jnshu.setTutor("元");
        jnshu.setExpectedAdmissionTime(Date.valueOf("1018-1-1"));jnshu.setGraduatedFrom("稷下学宫");jnshu.setStudentNumber(111);
        jnshu.setDailyLink("www.ming.com");jnshu.setIntending("一统天下");jnshu.setWhereToLearnAboutTheJnshu("书本");
        JnshuMybatisDao empOperation = session.getMapper(JnshuMybatisDao.class);
        empOperation.doCreate(jnshu);
        session.commit();
    } finally {
        session.close();
    }
}

    @Test
    public void doUpdate() throws SQLException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Jnshu jnshu=new Jnshu();
            jnshu.setName("唐太宗更新");jnshu.setQq(123123);jnshu.setType("太祖");jnshu.setTutor("元");
            jnshu.setExpectedAdmissionTime(Date.valueOf("1018-1-1"));jnshu.setGraduatedFrom("稷下学宫");jnshu.setStudentNumber(111);
            jnshu.setDailyLink("www.ming.com");jnshu.setIntending("一统天下");jnshu.setWhereToLearnAboutTheJnshu("书本");
            JnshuMybatisDao empOperation = session.getMapper(JnshuMybatisDao.class);
            empOperation.doUpdate(jnshu);
            session.commit();
        } finally {
            session.close();
        }
    }
    @Test
    public void doRemove() throws SQLException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            JnshuMybatisDao empOperation = session.getMapper(JnshuMybatisDao.class);
            empOperation.doRemove(111);
            session.commit();
        } finally {
            session.close();
        }
    }
}


