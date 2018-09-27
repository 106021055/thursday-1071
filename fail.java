//0927登入視窗 失敗畫面
import javax.swing.*;

public class fail extends JFrame{
    public static void main(String[] args) {
        new success().setVisible(true);
    }
    private JLabel jlb = new JLabel("失敗");
    public fail(){
        q();
    }
    public void q(){
        this.setBounds(500,500,100,100);
        jlb.setBounds(100,50,100,100);
        this.add(jlb);
    }
}

