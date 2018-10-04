package homworklogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class encrypt extends JFrame {
    public static void main(String[] args) {
      //  new encrypt().setVisible(true);
    }
    Container cp;
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

    private JPanel jpl1 = new JPanel(new GridLayout(9,1,1,1));
    private JPanel jpl2 = new JPanel(new GridLayout(1,1,1,1));
    private JPanel jpl3 = new JPanel(new GridLayout(1,1,1,1));

    private success mainframe;

    public encrypt(success mainframe){
        this.mainframe = mainframe;
        init();
    }
    public void init(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(0,0,500,500);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainframe.setVisible(true);

            }
        });
        cp = this.getContentPane();
        cp.add(jpl2, BorderLayout.WEST);
        cp.add(jpl1, BorderLayout.CENTER);
        cp.add(jpl3, BorderLayout.EAST);
        jtaL.setSize(150,500);
        jtaL.setSize(150,500);
//        cp.setLayout(new BorderLayout(1,1));

        jpl1.add(jlbMethod);
        jpl1.add(jcomb);
        jpl1.add(jlbPW);
        jpl1.add(jtfPW);
        jpl1.add(jrbtn1);
        jpl1.add(jrbtn2);
        jpl1.add(jbtnrun);
        jpl1.add(jbtnclose);

        jpl2.add(jtaL);
        jtaL.add(jspL);

        jpl3.add(jtaR);
        jtaR.add(jspR);

        btnGroup.add(jrbtn1);
        btnGroup.add(jrbtn2);

    }
}
