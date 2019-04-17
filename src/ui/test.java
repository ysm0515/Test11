package ui;

/**
 * @author xiaoming
 * @date 2019/4/17 0017
 */
public class test {
    public static void main(String[] args) {
        try {
            String n = "张三";
            String p = "12345";
            UserModel nm = new UserModel();
            nm.CheckUser(n, p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
