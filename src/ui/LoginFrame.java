package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginFrame extends JFrame implements ActionListener {

    JButton jb1,jb2;
    JLabel namelabel,passwordlabel,findpasswordlabel,blanklabel,imagelabel;
    JTextField jtf1;
    JPasswordField jps1;  //密码框
    JCheckBox jCheckBox1;   //复选框
    JPanel jp1,jp2,jp3;
//    demo4 owner;
    //owner代表父窗口
    //title代表窗口名
    //model指定的是模式窗口好事非模式窗口

    public LoginFrame()
    {
        //定义组件
        ImageIcon image=new ImageIcon("C:\\Users\\Administrator\\Desktop\\hospital.jpg");
        image.setImage(image.getImage().getScaledInstance(350,80, Image.SCALE_DEFAULT));
        imagelabel=new JLabel(image);
        namelabel=new JLabel("用户名", JLabel.CENTER);
        passwordlabel=new JLabel("密码", JLabel.CENTER);
        findpasswordlabel=new JLabel("忘记密码？", JLabel.CENTER);
        findpasswordlabel.setForeground(Color.blue);
        blanklabel=new JLabel("");
        jtf1=new JTextField(13);
        jps1=new JPasswordField(13);
        jb1=new JButton("登录");
        //点击登录，触发动作命令
        jb1.addActionListener(this);
        jb2=new JButton("取消");
        jb2.addActionListener(this);
        jCheckBox1=new JCheckBox("记住密码");
        jp1=new JPanel(new GridLayout(3,3,5,10));
        jp2=new JPanel();
        jp3=new JPanel();
        jp1.add(namelabel);
        jp1.add(jtf1);
        jp1.add(blanklabel);
        jp1.add(passwordlabel);
        jp1.add(jps1);
        jp1.add(findpasswordlabel);
        jp1.add(jCheckBox1);



        jp2.add(jb1);
        jp2.add(jb2);
        jp3.add(imagelabel);
        this.add(jp1, BorderLayout.CENTER);
        this.add(jp2, BorderLayout.SOUTH);
        this.add(jp3, BorderLayout.NORTH);
        //设置窗体
        this.setLocation(600,300);
        this.setSize(350,260);
        this.setVisible(true);

//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jb1)

        {
            //取出员工号和密码
            String u=jtf1.getText().trim();  //防止输入时出现空格
            String p=new String(jps1.getPassword());
//            System.out.println(u+"  "+p);
            UserModel userModel=new UserModel();
            ResultSet res=userModel.CheckUser(u,p);
            System.out.println(u+" "+res);
        }
        else if(e.getSource()==jb2){
            this.setVisible(false);

        }

    }

    public static void main(String[] args)
    {
        LoginFrame lf=new LoginFrame();
    }


}




