import javax.swing.*;
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

    public static void main(String[] args) {
        new success().setVisible(true);
    }
    public success(){
        q();
    }
    public void q(){
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200,200,800,800);
        this.setLayout(null);
        this.setJMenuBar(jmb);
        jmb.add(jmF); jmb.add(jmT); jmb.add(jmG); jmb.add(jmH);
        jmF.add(jmiopen); jmF.add(jmiclose); jmF.add(jmiexit);
        jmG.add(jmiooxx);

         jmiooxx.addActionListener(new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 OOXX w = new OOXX(success.this);
                 w.setVisible(true);
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
