package cn.ldj.util;

        import org.junit.Test;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.datasource.DriverManagerDataSource;

        import java.util.List;
        import java.util.Map;

public class DatabaseConnectionJDBCtemplate {

    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/jnshu?useSSL=false";// 数据库地址
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "123456";
    private JdbcTemplate template = null;
    public DatabaseConnectionJDBCtemplate() throws Exception {
        //创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DBDRIVER);
        dataSource.setUrl(DBURL);
        dataSource.setUsername(DBUSER);
        dataSource.setPassword(DBPASSWORD);
        //创建JdbcTemplate对象，设置数据源
        this.template = new JdbcTemplate(dataSource); // 加载驱动// 连接数据库
    }
    public JdbcTemplate getJdbcTemplate() {
        return this.template;// 取连接
    }

    @Test
    public void test(){
        //测试该工具类
        String sql1="select * from jnshu where id = 1";
        List<Map<String, Object>> maps1 = this.getJdbcTemplate().queryForList(sql1);
        System.out.println(maps1);
    }


}
