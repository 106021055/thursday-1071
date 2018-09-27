//0927登入視窗的成功畫面
import javax.swing.*;

public class success extends JFrame{
    public static void main(String[] args) {
        new success().setVisible(true);
    }
    private JLabel jlb = new JLabel("成功");
    public success(){
        q();
    }
    public void q(){
        this.setBounds(500,500,100,100);
        jlb.setBounds(100,50,100,100);
        this.add(jlb);
    }
}
