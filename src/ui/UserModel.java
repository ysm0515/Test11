package ui;



import java.sql.*;

public class UserModel {
    /**
     *
     * @param用户名
     * @param用户密码
     * @return 该用户的职位，若用户不存在，则返回“”
     */
    public static Connection getConn() {
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/StationDatabase?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection conn = null;
        try {
            //加载驱动
            Class.forName(driver);
            //创建连接
            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet CheckUser(String uname, String up)
    {
        ResultSet rs=null;
        SqHelper sp=null;
        String Position="";
        try {

            PreparedStatement stmt=null;
            Connection conn = getConn();
            //组织sql和参数列表
            String sql="select Position.position from CheckTable,Position where CheckTable.name=Position.name" +
                    "AND CheckTable.name='"+uname+"' AND CheckTable.password='"+up+"'";
            System.out.println("插入监测点信息的SQL语句为：" + sql);
            rs = stmt.executeQuery(sql);
            System.out.println("查询数据成功：" +rs);
//            String paras[]={uname,up};
//            sp=new SqHelper();
//            ResultSet rs=sp.query(sql,paras);
//            if (rs.next())         //如果拿到一个值
//            {
//                //则取出职位
//                Position=rs.getString(1);
//            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
}

