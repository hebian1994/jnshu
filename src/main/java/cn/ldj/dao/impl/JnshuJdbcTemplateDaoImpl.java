package cn.ldj.dao.impl;

import cn.ldj.dao.JnshuJdbcTemplateDao;
import cn.ldj.pojo.Jnshu;
import cn.ldj.util.DatabaseConnectionJDBCtemplate;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JnshuJdbcTemplateDaoImpl implements JnshuJdbcTemplateDao {
    private DatabaseConnectionJDBCtemplate databaseConnectionJDBCtemplate;
    private JdbcTemplate jdbcTemplate;
    public JnshuJdbcTemplateDaoImpl() throws Exception {//构造方法中实例化连接与实例化DAO对象
        this.databaseConnectionJDBCtemplate = new DatabaseConnectionJDBCtemplate();//连接数据库
        this.jdbcTemplate = databaseConnectionJDBCtemplate.getJdbcTemplate();
    }

    public boolean doCreate(Jnshu vo) throws SQLException {

        String sql="insert into jnshu (name,qq,type,Tutor,Expected_admission_time,Graduated_from,Student_number,Daily_link,Intending,Where_to_learn_about_the_JNSHU) values (?,?,?,?,?,?,?,?,?,?);";
        return jdbcTemplate.update(sql,vo.getName(),vo.getQq(),vo.getType(),vo.getTutor(),vo.getExpectedAdmissionTime(),vo.getGraduatedFrom(),vo.getStudentNumber(),vo.getDailyLink(),vo.getIntending(),vo.getWhereToLearnAboutTheJnshu())>0;

    }
    public boolean doUpdate(Jnshu vo) throws SQLException {
        String sql="update jnshu set name = ? ,qq=?,type=?,Tutor=?,Expected_admission_time=?,Graduated_from=?,Student_number=?,Daily_link=?,Intending=?,Where_to_learn_about_the_JNSHU=? where id = ?";
        return jdbcTemplate.update(sql, vo.getName(),vo.getQq(),vo.getType(),vo.getTutor(),vo.getExpectedAdmissionTime(),vo.getGraduatedFrom(),vo.getStudentNumber(),vo.getDailyLink(),vo.getIntending(),vo.getWhereToLearnAboutTheJnshu(),vo.getId())>1;
    }

    public Object findByStudentNumber(Object StudentNumber) throws SQLException {
        String sql1="select * from jnshu where  Student_number = "+StudentNumber;
        List<Map<String, Object>> maps1 = jdbcTemplate.queryForList(sql1);
        return maps1;
    }

    public List findAll() throws SQLException {
        String sql2="select * from jnshu";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql2);
        return maps;
    }

    public List findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    public boolean doRemove(int studentnumber) throws SQLException {
        return jdbcTemplate.update("DELETE from jnshu where Student_number = ?",studentnumber)>1;
    }

    @Test
    public void testDoCreate() throws Exception {
        Jnshu jnshu=new Jnshu();
        jnshu.setName("明太祖");jnshu.setQq(123123);jnshu.setType("太祖");jnshu.setTutor("元");
        jnshu.setExpectedAdmissionTime(Date.valueOf("1018-1-1"));jnshu.setGraduatedFrom("稷下学宫");jnshu.setStudentNumber(111);
        jnshu.setDailyLink("www.ming.com");jnshu.setIntending("一统天下");jnshu.setWhereToLearnAboutTheJnshu("书本");
        System.out.println(this.doCreate(jnshu));
    }

    @Test
    public void testUpdate() throws Exception {
        Jnshu jnshu=new Jnshu();
        jnshu.setId(1);jnshu.setName("修改成功3");jnshu.setQq(123);jnshu.setType("修改成功2");jnshu.setTutor("修改成功2");
        jnshu.setExpectedAdmissionTime(Date.valueOf("2011-1-1"));jnshu.setGraduatedFrom("修改成功2");jnshu.setStudentNumber(999);
        jnshu.setDailyLink("www.修改成功2.com");jnshu.setIntending("修改成功2");jnshu.setWhereToLearnAboutTheJnshu("修改成功2");
        System.out.println(this.doUpdate(jnshu));
    }

    @Test
    public void testfindByStudentNumber() throws Exception {
        System.out.println(this.findByStudentNumber(111));
    }
    @Test
    public void testfindAll() throws Exception {
        System.out.println(this.findAll());
    }

    @Test
    public void testDoRemove() throws Exception {
        System.out.println(this.doRemove(999));
    }

}
