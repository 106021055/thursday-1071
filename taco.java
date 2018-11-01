import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class taco extends JFrame {
    public static void main(String[] args) {
      //  new taco().setVisible(true);
    }
    //    public int dirFlag = 1, objX = 50, objY=50, objW=50, objH=50;
    public JButton Exit = new JButton("Exit");
    public JButton jbtnRun = new JButton("Run");
    public JButton jbtnUp = new JButton("Up");
    public JButton jbtnDown = new JButton("Down");
    public JButton jbtnLeft = new JButton("Left");
    public JButton jbtnRight = new JButton("Right");
    public Container cp;
    public JPanel jpnC = new JPanel(null);
    public JPanel jpnS = new JPanel(new GridLayout(1,6,3,3));
    public JLabel label = new JLabel();
    public ImageIcon image = new ImageIcon("taco.png");
    public Timer t1;
    public int dirFlag = 1;

    private success abc;
    int objX = 0 , objY = 0;
    int objW = 250 , objH = 250;



    public taco(success abc){
        haha();
    }
    public void haha(){

        t1 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (dirFlag){
                    case 1:
                        if (objY > 0){
                            objY-=10;
                        }
                        break;
                    case 2:
                        if (objY < 1000-objH){
                            objY+=10;
                        }
                        break;
                    case 3:
                        if (objX - 10 >0){
                            objX -= 10;
                        }
                        break;
                    case 4:
                        if (objX < 1000 -objW){
                            objX += 10;
                        }
                        break;
                }
                label.setLocation(objX,objY);
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(10,10,1000,1000);

        this.add(label);

        label.setBounds(objX,objY,objH,objW);
        label.setIcon(image);
        this.setResizable(false);


        cp = this.getContentPane();
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnS, BorderLayout.SOUTH);

        jpnC.add(label);
        jpnS.add(jbtnRun);jpnS.add(jbtnUp);jpnS.add(jbtnDown);jpnS.add(jbtnLeft);jpnS.add(jbtnRight);jpnS.add(Exit);


        jbtnRun.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                t1.start(); // ***
            }
        });

        Exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                success qw = new success();
                qw.setVisible(true);
                taco.this.setVisible(false);
            }
        });

        jbtnUp.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirFlag = 1;
            }
        });
        jbtnDown.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirFlag = 2;
            }
        });
        jbtnLeft.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirFlag = 3;
            }
        });
        jbtnRight.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dirFlag = 4;
            }
        });


    }


}
