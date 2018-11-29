import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends JFrame {
    public static void main(String[] args) {
        new server().setVisible(true);
    }
    private JButton jbtn = new JButton("取得");
    private JLabel jlb = new JLabel("");

    public server() {
        ha();
    }

    public void ha() {
        this.setBounds(0,0,600,600);
        jbtn.setBounds(100,100,100,100);
        jlb.setBounds(300,300,100,100);
        this.add(jbtn); this.add(jlb);

        jbtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServerSocket svs = new ServerSocket(2525);


                    jlb.setText("等候客戶端的請求中...");
                    Socket s = svs.accept();
                    jlb.setText("客戶端已和本機連上線...");

                    OutputStream out = s.getOutputStream();
                    String str = "Honor shows the man.";
                    jlb.setText("資料傳送中...");
                    out.write(str.getBytes());
                    out.close();
                    s.close();
                    jlb.setText("資料傳送完畢...");
                } catch (Exception exp) {
                    System.out.println("發生了" + exp + "例外");
                }
            }
        });
    }
}