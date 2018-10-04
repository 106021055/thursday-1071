import javax.swing.*;
import java.awt.*;

public class encrypt extends JFrame {
    private Container cp;
    private JPanel jpl1 = new JPanel(new GridLayout(9,1,1,1));
    private JPanel jpl2 = new JPanel(new GridLayout(1,1,1,1));
    private JPanel jpl3 = new JPanel(new GridLayout(1,1,1,1));
    private JTextArea jtaL = new JTextArea("");
    private JTextArea jtaR = new JTextArea("");
    private JScrollPane jspL = new JScrollPane();
    private JScrollPane jspR = new JScrollPane();
    private JLabel jlbMethod = new JLabel("Method");
    private String methodStr[] = {"DES" , "AES" , "XOR" , "Caesar"};
    private JComboBox jcomb = new JComboBox<String>(methodStr);
    private JLabel jlbPW = new JLabel("Password");
    private JTextField jtfPW = new JTextField();
    private JRadioButton jrbtn1 = new JRadioButton("Encrypt");
    private JRadioButton jrbtn2 = new JRadioButton("Decrypt");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclose = new JButton("close");
    private ButtonGroup btnGroup = new ButtonGroup();

    public static void main(String[] args) {
        new encrypt().setVisible(true);
    }
    public encrypt(){
        z();
    }
    public void z(){
        this.setBounds(0,0,500,500);
        cp.add(jtaL, BorderLayout.WEST);
        cp.add(jpl1, BorderLayout.CENTER);
        cp.add(jtaR, BorderLayout.EAST);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(1,1));
        jpl1.add(jlbMethod); jpl1.add(jcomb); jpl1.add(jlbPW); jpl1.add(jtfPW); jpl1.add(jrbtn1); jpl1.add(jrbtn2); jpl1.add(jbtnrun); jpl1.add(jbtnclose);
        jpl2.add(jtaL); jpl2.add(jspL);   jpl3.add(jtaR); jpl3.add(jspR);

        btnGroup.add(jrbtn1);
        btnGroup.add(jrbtn2);

    }
}
