import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        //创建数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jnshu?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建JdbcTemplate对象，设置数据源
        JdbcTemplate template = new JdbcTemplate(dataSource);


//       /*插入数据*/
//       //生成日期对象
//       Date current_date = new Date();
//       //设置日期格式化样式为：yyyy-MM-dd
//       SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//       //格式化当前日期
//        String d=SimpleDateFormat.format(current_date.getTime());
        //插入测试
//      String sql="insert into jnshu (name,qq,type,Tutor,Expected_admission_time,Graduated_from,Student_number,Daily_link,Intending,Where_to_learn_about_the_JNSHU) values (?,?,?,?,?,?,?,?,?,?);";
//      template.update(sql,"马化腾",911911,"JAVA后端","马云",null,"深圳大学",666,"www.baidu.com","一统天下","弹窗网站");

//       /*修改数据根据学号改名字*/
//        String sqlx="UPDATE jnshu SET name ="+"'秦始皇'"+" WHERE Student_number = 666";
//        template.update(sqlx);
//
//        /*查询所有并返回结果*/
       String sql2="select * from jnshu";
      List<Map<String, Object>> maps = template.queryForList(sql2);        System.out.println(maps);
        //条件查询
//        String sql1="select * from jnshu where  Student_number = 666";
//        List<Map<String, Object>> maps1 = template.queryForList(sql1);
//        System.out.println(maps1);

        //删除数据
        //template.update("DELETE from jnshu where Student_number = 666");
        //删除所有
//      template.update("truncate table jnshu");

    }
}
