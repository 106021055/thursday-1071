import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class success extends JFrame{
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmF = new JMenu("File");
    private JMenu jmT = new JMenu("Tool");
    private JMenu jmG = new JMenu("Game");
    private JMenu jmH = new JMenu("Help");
    private JMenuItem jmiopen = new JMenuItem("Open");
    private JMenuItem jmiclose = new JMenuItem("Close");
    private JMenuItem jmiexit = new JMenuItem("Exit");
    private JMenuItem jmiooxx = new JMenuItem("OOXX");
    private JMenuItem jmiencrypt = new JMenuItem("encrypt");
    private JMenuItem jmiencryptfile = new JMenuItem("encryptfile");
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screew = screenSize.width,screeh = screenSize.height;
    private int frmw = 700,frmh = 700;

    public static void main(String[] args) {
        new success().setVisible(true);
    }
    public success(){
        q();
    }
    public void q(){
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(screew/2 - frmw/2 , screeh/2 - frmh/2 , frmw,frmh);
        this.setLayout(null);
        this.setJMenuBar(jmb);
        jmb.add(jmF); jmb.add(jmT); jmb.add(jmG); jmb.add(jmH);
        jmF.add(jmiopen); jmF.add(jmiclose); jmF.add(jmiexit);
        jmG.add(jmiooxx); jmT.add(jmiencrypt); jmT.add(jmiencryptfile);

//        jmiooxx.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                OOXX w = new OOXX(success.this);
//                w.setVisible(true);
//                success.this.setVisible(false);
//            }
//        });

        jmiencrypt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encrypt op = new encrypt(success.this);
                op.setVisible(true);
                success.this.setVisible(false);
            }
        });

        jmiencryptfile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryptfile op = new encryptfile(success.this);
                op.setVisible(true);
                success.this.setVisible(false);
            }
        });

        jmiexit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}