import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class login extends JFrame {
    public static void main(String[] args) {
        new login().setVisible(true);
    }
    Container cp;
    private JLabel jlb1 = new JLabel("ID");
    private JLabel jlb2 = new JLabel("Password");
    private JTextField jtf = new JTextField("");
    private JPasswordField jpf = new JPasswordField("");
    private JButton jbtn1 = new JButton("Keyboard");
    private JButton jbtn2 = new JButton("Login");
    private JButton jbtn3 = new JButton("Exit");
    private JPanel jpn = new JPanel(new GridLayout(2,2,3,3));
    private JPanel jpn1 = new JPanel(new GridLayout(1,3,3,1));
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screew = screenSize.width,screeh = screenSize.height;
    private int frmw = 300,frmh = 120;

    public login(){
        ha();
    }
    public void ha(){
        this.setBounds(500,500,300,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpn, BorderLayout.CENTER);
        cp.add(jpn1, BorderLayout.SOUTH);
        this.setBounds(screew/2 - frmw/2 , screeh/2 - frmh/2 , frmw,frmh);
        jpn.add(jlb1); jpn.add(jtf); jpn.add(jlb2); jpn.add(jpf);
        jpn1.add(jbtn1); jpn1.add(jbtn2); jpn1.add(jbtn3);

//        jbtn1.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                keyboard ha = new keyboard(login.this);
//                ha.setVisible(true);
//
//            }
//        });
        jbtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new String(jtf.getText()).equals("123") && (new String(jpf.getPassword()).equals("0"))){
                    success q = new success();
                    q.setVisible(true);
                    login.this.dispose();  //登入成功後login頁會不見
                }else {
                    JOptionPane.showMessageDialog(login.this,"wrong ID or Password!!");
                }
            }
        });
        jbtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public void setPassWord(String lg){
        jpf.setText(lg);
    }
}
