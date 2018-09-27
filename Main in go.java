import javax.security.auth.login.LoginContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame {

    private Container cp;
    private JLabel jlb = new JLabel("");
    private JPanel jpn = new JPanel(new GridLayout(4, 3, 3, 3));
    private JPanel jpnt = new JPanel(new GridLayout(1, 1, 2, 2));
    private JButton [] jbtns = new JButton[12];
    private String jbtnlabel[]=new String[10];
    private Font fnt = new Font(null, Font.BOLD, 40);
    private go lg;


    public Main(go lg1) {
        lg = lg1;
        haha();
    }

    public void haha() {
        this.setBounds(0, 0, 200, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.add(jpn, BorderLayout.CENTER);
        cp.add(jpnt, BorderLayout.NORTH);
        jbtns[10] = new JButton("GO");
        jbtns[11] = new JButton("Submit");
        for (int i = 0; i < 10; i++) {
            jbtns[i] = new JButton(Integer.toString(i));
            jbtns[i].setFont(fnt);
            jpn.add(jbtns[i]);
            jbtns[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbtn = (JButton) e.getSource();
                    jlb.setText(jlb.getText() + jbtn.getText());
                }
            });

            jbtns[10].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    genLabel(jbtnlabel);
                    for (int i = 0; i < 10; i++) {
                        jbtns[i].setText(jbtnlabel[i]);
                    }
                }
            });
            jbtns[11].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lg.setPassWord(jlb.getText());
                    Main.this.setVisible(false);
                }
            });

            jpnt.add(jlb);
            jpn.add(jbtns[10]);
            jpn.add(jbtns[11]);
        }
    }
    private void genLabel(String str[]){
        int i=0;
        Random rnd=new Random(System.currentTimeMillis());
        while (i<10){
            jbtnlabel[i]=Integer.toString(rnd.nextInt(10));
            int j=0;
            boolean flag=false;
            while (j<i){
                if (jbtnlabel[i].equals(jbtnlabel[j])){
                    flag=true;
                    j=i;
                }
                j++;
            }
            if (!flag){
                i++;
            }
        }
    }
}



