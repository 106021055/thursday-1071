package homworklogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class encryptfile extends JFrame {
    public static void main(String[] args) {
       // new encryptfile().setVisible(true);
    }
    private Container cp;
    private JPanel jplW = new JPanel(new GridLayout(2,1,3,3));
    private JPanel jplE = new JPanel(new GridLayout(2,1,3,3));
    private JPanel jplC = new JPanel(new GridLayout(2,1,3,3));
    private JPanel jplN = new JPanel(new GridLayout(1,6,3,3));
    private JPanel jplS = new JPanel(new GridLayout(1,1,0,0));
    private JLabel jlb1 = new JLabel("原始檔");
    private JLabel jlb2 = new JLabel("加密檔");
    private JLabel jlb3 = new JLabel("加密法");
    private JLabel jlbkey = new JLabel("key");
    private String algoLabels[] = {"Caesar", "XOR", "DES", "AES"};
    private JComboBox jcomb = new JComboBox(algoLabels);
    private JFileChooser jfcopen = new JFileChooser();
    private JFileChooser jfcsave = new JFileChooser();
    private JTextField jtf1 = new JTextField();
    private JTextField jtf2 = new JTextField();
    private JTextField jtfkey = new JTextField("1723");
    private JButton jbtnload = new JButton("Choose");
    private JButton jbtnsave = new JButton("Choose");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclose = new JButton("Close");
    private JProgressBar jpb = new JProgressBar();
    private int frmw = 500, frmh = 250;
    private Timer t1;
    private int val = 10;
    private success good;

    public encryptfile(success good){
        this.good = good;
        iii();
    }
    public void iii(){
        this.setBounds(120,120,frmw,frmh);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                good.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jplN, BorderLayout.NORTH);
        cp.add(jplW, BorderLayout.WEST);
        cp.add(jplC, BorderLayout.CENTER);
        cp.add(jplE, BorderLayout.EAST);
        cp.add(jplS, BorderLayout.SOUTH);

        jplN.add(jlb3);
        jplN.add(jcomb);
        jplN.add(jlbkey);
        jplN.add(jtfkey);
        jplN.add(jbtnrun);
        jplN.add(jbtnclose);

        jplW.add(jlb1);
        jplW.add(jlb2);

        jplC.add(jtf1);
        jplC.add(jtf2);

        jplE.add(jbtnsave);
        jplE.add(jbtnload);

        jplS.add(jpb);
    }
}