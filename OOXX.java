import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OOXX extends JFrame {
    public static void main(String[] args) {
//        new OOXX().setVisible(true);
    }
    private JButton jbtnRun = new JButton("Run");
    private JButton jbtnReSet = new JButton("ReSet");
    private JButton jbtnExit = new JButton("EXIT");
    private JButton jbtns[][] = new JButton[3][3]; //如果前面拆成9個button 就不用這行

    private Container cp;
    private JPanel jpnC = new JPanel(new GridLayout(3, 3,3,3 ));
    private JPanel jpnR = new JPanel(new GridLayout(3, 1, 3, 3));
    private boolean flag = true;

    private success frame;

    public OOXX(success frame) {
        this.frame = frame;
        w();
    }

    private void w() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(10, 10, 800, 600);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);

            }
        });
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3)); //設定CENTER跟EAST的間格
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnR, BorderLayout.EAST);

        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                jbtns[i][j] = new JButton();
                // jbtns[i][j].setBackground(new Color(225, 41, 56));
                jbtns[i][j].setFont(new Font(null, Font.BOLD, 80));
                jbtns[i][j].setEnabled(false);
                jbtns[i][j].addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmpBtn = (JButton) e.getSource();
                        if (tmpBtn.getText().equals("")) {
                            if (flag) {
                                tmpBtn.setText("o");
                            } else {
                                tmpBtn.setText("x");
                            }
                            flag = !flag;
                        }
                        checkStat();
                        //   tmpBtn.setBackground(new Color(115, 211, 255));
                    }
                });
                jpnC.add(jbtns[i][j]);
            }
        }

        jpnR.add(jbtnRun);
        jpnR.add(jbtnReSet);
        jpnR.add(jbtnExit);

        jbtnRun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        jbtns[i][j].setEnabled(true);
                    }
                }
            }
        });
        jbtnReSet.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        jbtns[i][j].setText("");
                        jbtns[i][j].setEnabled(true);
                    }
                }
            }
        });

        jbtnExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void checkStat() {
        if (jbtns[0][0].getText().equals(jbtns[0][1].getText()) && jbtns[0][0].getText().equals(jbtns[0][2].getText()) && !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][0].getText() + "Win!");
        } else if (jbtns[1][0].getText().equals(jbtns[1][1].getText()) && jbtns[1][0].getText().equals(jbtns[1][2].getText()) && !jbtns[1][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[1][0].getText() + "Win!");
        } else if (jbtns[2][0].getText().equals(jbtns[2][1].getText()) && jbtns[2][0].getText().equals(jbtns[2][2].getText()) && !jbtns[2][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[2][0].getText() + "Win!");
        } else if (jbtns[0][0].getText().equals(jbtns[1][0].getText()) && jbtns[0][0].getText().equals(jbtns[2][0].getText()) && !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][0].getText() + "Win!");
        } else if (jbtns[0][1].getText().equals(jbtns[1][1].getText()) && jbtns[0][1].getText().equals(jbtns[2][1].getText()) && !jbtns[0][1].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][1].getText() + "Win!");
        } else if (jbtns[0][2].getText().equals(jbtns[1][2].getText()) && jbtns[0][2].getText().equals(jbtns[2][2].getText()) && !jbtns[0][2].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][2].getText() + "Win!");
        } else if (jbtns[0][0].getText().equals(jbtns[1][1].getText()) && jbtns[0][0].getText().equals(jbtns[2][2].getText()) && !jbtns[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][0].getText() + "Win!");
        } else if (jbtns[0][2].getText().equals(jbtns[1][1].getText()) && jbtns[0][2].getText().equals(jbtns[2][0].getText()) && !jbtns[0][2].getText().equals("")) {
            JOptionPane.showMessageDialog(OOXX.this, jbtns[0][2].getText() + "Win!");
        }
    }
}
