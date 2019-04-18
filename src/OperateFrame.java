import javax.swing.*;
import java.awt.*;

public class OperateFrame extends JFrame {
    //工具栏中所需按钮
    JButton jButton1,jButton2,jButton3;
    JToolBar jToolBar;
    public OperateFrame()
    {
        //设置工具栏
        Font f1=new Font("黑体",Font.PLAIN,12);
        //设置工具栏各属性
        jButton1=new JButton("   添加  ");
        jButton1.setIcon(new ImageIcon("D:\\Intellij\\Censor\\src\\ui\\IMG\\tool1.png"));
        jButton1.setVerticalTextPosition(JButton.BOTTOM);
        jButton1.setHorizontalTextPosition(JButton.CENTER);
        jButton1.setFont(f1);   //设置菜单栏字体
        jButton2=new JButton("  删除  ");
        jButton2.setIcon(new ImageIcon("D:\\Intellij\\Censor\\src\\ui\\IMG\\tool2.png"));
        jButton2.setVerticalTextPosition(JButton.BOTTOM);
        jButton2.setHorizontalTextPosition(JButton.CENTER);
        jButton2.setFont(f1);
        jButton3=new JButton("  修改  ");
        jButton3.setIcon(new ImageIcon("D:\\Intellij\\Censor\\src\\ui\\IMG\\tool3.png"));
        jButton3.setVerticalTextPosition(JButton.BOTTOM);
        jButton3.setHorizontalTextPosition(JButton.CENTER);
        jButton3.setFont(f1);
        //一级工具栏元素加入JMenuBar
        jToolBar=new JToolBar();
        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);
        //从JFrame中获得Container
        Container ct=this.getContentPane();
        ct.add(jToolBar,"North");
        //设置窗体
        this.setSize(800,600);
        this.setLocation(350,80);
        this.setVisible(true);

    }
//    public static void main(String[] args)
//    {
//        OperateFrame o1=new OperateFrame();
//    }
}
