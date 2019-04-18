import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 对数据库操作的类
 */

public class SqHelper {
    //定义连接数据库需要的对象
    PreparedStatement ps=null;
    ResultSet rs=null;
    Connection ct=null;
    String user = "root";

    String password = "123456";
    String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String driver = "com.mysql.cj.jdbc.Driver";
    //构造函数，初始化ct
    public SqHelper()
    {
        try {
            //加载驱动
            Class.forName(driver);
            //创建连接
            ct = DriverManager.getConnection(url, user, password);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public ResultSet query(String sql, String []paras)
    {
//
        try {
            ps=ct.prepareStatement(sql);    //创建预处理对象preparedStatement
            //对sql进行赋值
            for (int i=0;i<paras.length;i++)
            {
                ps.setString(i+1,paras[i]);
            }
            rs=ps.executeQuery();   //处理查询结果集
        }catch (Exception e)
        {
            e.printStackTrace();
        }
         return rs;
    }
    //构造关闭资源的方法
    public void close()
    {
        try {
            if (rs!=null) rs.close();
            if (ct!=null)ct.close();
            if (ps!=null)ps.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }

}
