import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class fishbox extends JFrame {
    public static void main(String[] args) {
    }
    private Container cp;
    private ArrayList <fish> fishList = new ArrayList<fish>();
    private ArrayList <Thread> threads = new ArrayList<>();
    private JLabel fish = new JLabel("");
    private success mainframe;

    public fishbox(success mainframe){
        this.mainframe = mainframe;
        haha();
    }
    public void haha(){
        cp = this.getContentPane();
        cp.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,800,800);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if (e.getKeyCode() == 32){
                    fishList.add(new fish());
                    cp.add(fishbox.get(fishList.size()-1));
                    System.out.println(fishbox.get(fishList.size()-1));
                    threads.add(new Thread(fishbox.get(fishbox.size()-1)));
                    threads.get(threads.size()-1).start();
                }
                System.out.println(fishbox.size());
            }
        });


    }
}
