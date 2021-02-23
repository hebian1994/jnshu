import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名jnshu
        String url = "jdbc:mysql://localhost:3306/jnshu?useSSL=false";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from jnshu";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");
            System.out.println("序号" + "\t" + "加入时间"+ "\t" + "更新"+ "\t" + "QQ"+ "\t" + "专业方向"+ "\t" + "介绍者"+ "\t" + "预计入学时间"+ "\t" + "毕业学院"+ "\t" + "学号"+ "\t" + "日报链接"+ "\t" + "目标"+ "\t" + "从何处了解到JNSHU");
            System.out.println("-----------------");

            while(rs.next()){
                //输出结果
                System.out.println(rs.getInt("id")+ "\t"
                        +rs.getDate("create_at") + "\t"
                        +rs.getDate("update_at")+ "\t"
                        +rs.getString("name")+ "\t"
                        +rs.getInt("qq") + "\t" +rs.getString("type")+ "\t"
                        +rs.getString("Tutor")+ "\t" +rs.getDate("Expected_admission_time") + "\t"
                        +rs.getString("Graduated_from")+ "\t" +rs.getInt("Student_number") + "\t"
                        +rs.getString("Daily_link") + "\t" +rs.getString("Intending") + "\t"
                        +rs.getString("Where_to_learn_about_the_JNSHU"));
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }
}
