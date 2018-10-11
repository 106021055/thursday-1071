import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class encrypt extends JFrame {
    public static void main(String[] args) {
        //    new encrypt().setVisible(true);
    }
    Container cp;
    private JTextArea jtaL = new JTextArea("",30,15);
    private JTextArea jtaR = new JTextArea("",30,15);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JLabel jlbMethod = new JLabel("Method");
    private String methodStr[] = {"DES" , "AES" , "Caesar" , "XOR"};
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
        this.setBounds(0,0,550,600);
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

//        cp.setLayout(new BorderLayout(1,1));

        jpl1.add(jlbMethod);
        jpl1.add(jcomb);
        jpl1.add(jlbPW);
        jpl1.add(jtfPW);
        jpl1.add(jrbtn1);
        jpl1.add(jrbtn2);
        jpl1.add(jbtnrun);
        jpl1.add(jbtnclose);

        jpl2.add(jspL);

        jpl3.add(jspR);

        btnGroup.add(jrbtn1);
        btnGroup.add(jrbtn2);

        jbtnrun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbtn1.isSelected()) {
                    int dataLength = jtaL.getText().length();
                    if (dataLength > 0) {
                        switch (jcomb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtfPW.getText());
                                    char data[] = jtaL.getText().toCharArray();
                                    for (int i = 0; i < dataLength; i++) {
                                        data[i] = (char) (data[i] + key);
                                    }
                                    jtaR.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(encrypt.this,
                                            "key is not a number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(encrypt.this, "Error:" +
                                            exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                        }
                    }
                }else if (jrbtn2.isSelected()){
                    int dataLength = jtaR.getText().length();
                    if (dataLength > 0) {
                        switch (jcomb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                try {
                                    int key = Integer.parseInt(jtfPW.getText());
                                    char data[] = jtaR.getText().toCharArray();
                                    for (int i = 0; i < dataLength; i++) {
                                         data[i] = (char) (data[i] - key);
                                    }
                                    jtaL.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(encrypt.this,
                                            "key is not a number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(encrypt.this, "Error:" +
                                            exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(encrypt.this, "sorry, "
                                        + jcomb.getSelectedItem() + "not implement yet!");
                        }
                    }
                }
            }
        });
        }
    }

