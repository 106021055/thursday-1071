import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class encrypt extends JFrame {
    public static void main(String[] args) {
        //    new encrypt().setVisible(true);
    }

    Container cp;
    private JTextArea jtaL = new JTextArea("", 30, 15);
    private JTextArea jtaR = new JTextArea("", 30, 15);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JLabel jlbMethod = new JLabel("Method");
    private String methodStr[] = {"DES", "AES", "Caesar", "XOR"};
    private JComboBox jcomb = new JComboBox<String>(methodStr);
    private JLabel jlbPW = new JLabel("Password");
    private JTextField jtfPW = new JTextField();
    private JRadioButton jrbtn1 = new JRadioButton("Encrypt");
    private JRadioButton jrbtn2 = new JRadioButton("Decrypt");
    private JButton jbtnrun = new JButton("Run");
    private JButton jbtnclose = new JButton("close");
    private JButton jbrnclear = new JButton("clear");
    private ButtonGroup btnGroup = new ButtonGroup();

    private JMenuBar jmb = new JMenuBar();
    private JMenu jmf = new JMenu("File");
    private JMenu jma = new JMenu("About");
    private JMenuItem jmiopen = new JMenuItem("Open");
    private JMenuItem jmiclose = new JMenuItem("Close");
    private JMenuItem jmisave = new JMenuItem("Save");
    private JFileChooser jfc = new JFileChooser();

    private JPanel jpl1 = new JPanel(new GridLayout(9, 1, 1, 1));
    private JPanel jpl2 = new JPanel(new GridLayout(1, 1, 1, 1));
    private JPanel jpl3 = new JPanel(new GridLayout(1, 1, 1, 1));

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screew = screenSize.width,screeh = screenSize.height;
    private int frmw = 700,frmh = 700;

    private success mainframe;

    public encrypt(success mainframe) {
        this.mainframe = mainframe;
        init();
    }

    public void init() {
        this.setBounds(screew/2 - frmw/2 , screeh/2 - frmh/2 , frmw,frmh);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        jpl1.add(jbrnclear);
        jpl1.add(jbtnclose);


        jpl2.add(jspL);
        jpl3.add(jspR);

        btnGroup.add(jrbtn1);
        btnGroup.add(jrbtn2);

        this.setJMenuBar(jmb);
        jmb.add(jmf); jmb.add(jma);
        jmf.add(jmiopen); jmf.add(jmiclose); jmf.add(jmisave);

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
                                char data[] = jtaL.getText().toCharArray();
                                char key[] = jtfPW.getText().toCharArray();
                                for (int i = 0 ; i < data.length ; i++){
                                    data[i] = (char)((int)(data[i]^(int)key[i%key.length]));
                                }
                                jtaR.setText(new String(data));
                                break;
                        }
                    }
                } else if (jrbtn2.isSelected()) {
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
                                    JOptionPane.showMessageDialog(encrypt.this, "Error: " +
                                            exp1.toString());
                                }
                                break;
                            case 3:
                                char data[] = jtaR.getText().toCharArray();
                                char key[] = jtfPW.getText().toCharArray();
                                for (int i = 0; i < data.length; i++) {
                                    data[i] = (char) ((int) (data[i] ^ (int) key[i % key.length]));
                                }
                                jtaL.setText(new String(data));
                                break;
                        }
                    }
                }
            }
        });

        jbrnclear.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("");
                jtaR.setText("");
            }
        });

        jmiopen.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (jfc.showOpenDialog(encrypt.this) == JFileChooser.APPROVE_OPTION){
                        jtaL.setText("");
                        String str = "";
                        File selectFile = jfc.getSelectedFile();
                        FileReader fr = new FileReader(selectFile);
                        BufferedReader bfr = new BufferedReader(fr);
                        while ((str = bfr.readLine()) != null){
                            jtaL.append(str);
                        }
                        fr.close();
                    }
                }catch (IOException ioe){
                    JOptionPane.showMessageDialog(encrypt.this, "Open file error: "
                            +ioe.toString());
                }
            }
        });

        jmiclose.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success qw = new success();
                qw.setVisible(true);
                encrypt.this.setVisible(false);
            }
        });

        jmisave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (jtaR.getText().length() > 0) {
                        jfc.setFileFilter(new FileNameExtensionFilter(".txt ", "txt"));
                        if (jfc.showSaveDialog(encrypt.this) == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = new File(jfc.getSelectedFile().getPath() + jfc.getSelectedFile().getName() + ".txt");
                            FileWriter fw = new FileWriter(selectedFile);
                            BufferedWriter bfw = new BufferedWriter(fw);
                            bfw.write(jtaR.getText());
                            bfw.close();
                        }
                    }else {
                        JOptionPane.showMessageDialog(encrypt.this, "No Data Can Write Out!!");
                    }
                }catch(IOException ioe2){
                    JOptionPane.showMessageDialog(encrypt.this, "open file error: " + ioe2.toString());
                } catch (Exception ioe3) {
                    JOptionPane.showMessageDialog(encrypt.this, "Error: " + ioe3.toString());
                }
            }
        });
    }
}