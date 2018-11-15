import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class tacoauto extends JFrame {
    public JLabel jlb = new JLabel();
    public JLabel jlb2 = new JLabel();
    public ImageIcon imgdragonleft = new ImageIcon("taco.png");
    public ImageIcon imgdragonright = new ImageIcon("taco.png");
//    public ImageIcon imgfire = new ImageIcon("fire.png");
    public Timer tim1;
    private int dir =0 ,objx=200,objy=200,objw=50,objh=50;
    Container cp;
    private success frame;

    int flag = 0;


    public tacoauto(success frame){
        this.ha();
    }
    public void ha(){
        this.setBounds(1,1,700,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(null);

        jlb.setBounds(200,200,200,200);


        Image img = imgdragonleft.getImage();
        Image img2 = img.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        imgdragonleft.setImage(img2);
        jlb.setIcon(imgdragonleft);

        Image img3 = imgdragonright.getImage();
        Image img4 = img3.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        imgdragonright.setImage(img4);
        jlb.setIcon(imgdragonright);

//        img = imgfire.getImage();
//        img2 = img.getScaledInstance(100,120,Image.SCALE_SMOOTH);
//        imgfire.setImage(img2);
//        jlb2.setIcon(imgfire);

        cp.add(jlb);

        tim1 =new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dir){
                    case 1:
                        if (objy-2>-240){
                            objy-=5;
                        }else {
                            dir=2;
                        }
                        break;
                    case 2:
                        if (objy<300-objh){
                            objy+=5;
                        }else {
                            dir=1;
                        }
                        break;
                    case 3:
                        if (objx-2>0){
                            objx-=5;
                        }else {
                            dir=4;
                        }
                        break;
                    case 4:
                        if (objx<600-objw){
                            objx+=5;
                        }else {
                            dir=3;
                        }
                        break;
                }
                jlb.setLocation(objx,objy);
            }
        });



        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 32:
                        tim1.start();
                        break;
                    case 37:
                        dir = 3;
                        break;
                    case 38:
                        dir = 1;
                        break;
                    case 39:
                        dir = 4;
                        break;
                    case 40:
                        dir = 2;
                        break;

                }
            }
        });
    }
}