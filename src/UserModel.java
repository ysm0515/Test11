import java.sql.ResultSet;

public class UserModel {
    /**
     *
     * @param uname 用户名
     * @param up 用户密码
     * @return 该用户的职位，若用户不存在，则返回“”
     */
//    Test oper;
    public String CheckUser(String uname, String up)
    {

        SqHelper sp=null;
//        Statement stm=null;
        String Position="";
        try {
             sp=new SqHelper();
            String paras[]={uname,up};
            //组织sql和参数列表
            String sql="select position from CheckTable,Position where CheckTable.name=Position.name" +
                    " and CheckTable.name=? and CheckTable.password=?";
            System.out.println("插入监测点信息的SQL语句为：" + sql);
            ResultSet rs=sp.query(sql,paras);
            System.out.println("查询数据成功：" +rs);
            if (rs.next())         //如果拿到一个值
            {
                //则取出职位
                Position=rs.getString(1);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            sp.close();
        }
        return Position;
    }
}
