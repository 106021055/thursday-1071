import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class password extends JFrame {
    private Container cp;
    private JPasswordField jpf = new JPasswordField("");
    private JLabel jlb = new JLabel("123");
    private JPanel jpnl = new JPanel(new GridLayout(4, 3, 4, 3));
    private JButton jbtn1 = new JButton("1");
    private JButton jbtn2 = new JButton("2");
    private JButton jbtn3 = new JButton("3");
    private JButton jbtn4 = new JButton("4");
    private JButton jbtn5 = new JButton("5");
    private JButton jbtn6 = new JButton("6");
    private JButton jbtn7 = new JButton("7");
    private JButton jbtn8 = new JButton("8");
    private JButton jbtn9 = new JButton("9");
    private JButton jbtn10 = new JButton("0");
    private JButton jbtn11 = new JButton("送出");
    private JButton jbtn12 = new JButton("Exit");
    public static void main(String[] args) {
        new password().setVisible(true);
    }

    public password() {
        haha();
    }

    private void haha() {
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 1));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 600, 400);
        cp.add(jpf, BorderLayout.NORTH);
        jpf.setOpaque(true);
        jpf.setBackground(new Color(255, 255, 0));
        jpf.setFont(new Font(null, Font.BOLD, 26));
        jlb.setSize(600,100);
        jlb.setFont(new Font(null,Font.BOLD,40));
        jbtn1.setFont(new Font(null,Font.BOLD,50));
        jbtn2.setFont(new Font(null,Font.BOLD,50));
        jbtn3.setFont(new Font(null,Font.BOLD,50));
        jbtn4.setFont(new Font(null,Font.BOLD,50));
        jbtn5.setFont(new Font(null,Font.BOLD,50));
        jbtn6.setFont(new Font(null,Font.BOLD,50));
        jbtn7.setFont(new Font(null,Font.BOLD,50));
        jbtn8.setFont(new Font(null,Font.BOLD,50));
        jbtn9.setFont(new Font(null,Font.BOLD,50));
        jbtn10.setFont(new Font(null,Font.BOLD,50));
        jbtn11.setFont(new Font(null,Font.BOLD,50));
        jbtn12.setFont(new Font(null,Font.BOLD,50));
        cp.add(jpnl, BorderLayout.CENTER);
        cp.add(jlb, BorderLayout.SOUTH);

        jpnl.add(jbtn1);jpnl.add(jbtn2);jpnl.add(jbtn3);jpnl.add(jbtn4);jpnl.add(jbtn5);jpnl.add(jbtn6);jpnl.add(jbtn7);jpnl.add(jbtn8);jpnl.add(jbtn9);jpnl.add(jbtn10);jpnl.add(jbtn11);jpnl.add(jbtn12);

        jbtn1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(1));
            }
        });
        jbtn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(2));
            }
        });
        jbtn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(3));
            }
        });
        jbtn4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(4));
            }
        });
        jbtn5.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(5));
            }
        });
        jbtn6.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(6));
            }
        });
        jbtn7.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(7));
            }
        });
        jbtn8.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(8));
            }
        });
        jbtn9.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(9));
            }
        });
        jbtn10.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpf.setText(jpf.getText() + Integer.toString(0));
            }
        });
        jbtn11.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(new String(jpf.getPassword()).equals("23323456")){
                    jlb.setText("成功");
                }else {
                    jlb.setText("失敗");
                }
            }
        });
        jbtn12.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}




