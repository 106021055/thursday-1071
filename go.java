//0927上課寫的登入視窗
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class go extends JFrame {
    public static void main(String[] args) {
        new go().setVisible(true);
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

    public go(){
        ha();
        }
        public void ha(){
        this.setBounds(0,0,300,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpn, BorderLayout.CENTER);
        cp.add(jpn1, BorderLayout.SOUTH);
        jpn.add(jlb1); jpn.add(jtf); jpn.add(jlb2); jpn.add(jpf);
        jpn1.add(jbtn1); jpn1.add(jbtn2); jpn1.add(jbtn3);

        jbtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main ha = new Main(go.this);
                ha.setVisible(true);
            }
        });
        jbtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new String(jtf.getText()).equals("123456789") && (new String(jpf.getPassword()).equals("000000"))){
                    success q = new success();
                    q.setVisible(true);
                }else {
                    fail a = new fail();
                    a.setVisible(true);
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

