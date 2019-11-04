package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI {
    static JTextField jf_rec = new JTextField();  //收件人
    static JTextField jf_sub = new JTextField();  //主题
    static JTextArea jta_body = new JTextArea();  //正文

    static String _url = null;
    static String _payload = null;
    static String _sub = null;

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        JFrame frame = new JFrame("Client");
        frame.setBounds(20, 20, 600, 400);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        //收件人
        JLabel label_rec = new JLabel("收件人");
        label_rec.setBounds(20, 10, 50, 40);
        panel.add(label_rec);
        jf_rec.setBounds(80, 15, 500, 30);
        panel.add(jf_rec);

        //主题
        JLabel label_sub = new JLabel("主题");
        label_sub.setBounds(25, 50, 50, 40);
        panel.add(label_sub);
        jf_sub.setBounds(80, 55, 500, 30);
        panel.add(jf_sub);

        //正文
        JLabel label_body = new JLabel("正文");
        label_body.setBounds(25, 90, 50, 40);
        panel.add(label_body);
        JScrollPane jsp = new JScrollPane(jta_body);
        jsp.setBounds(80, 90, 500, 200);
        jta_body.setVisible(true);
        panel.add(jsp);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //发送按钮
        JButton jb = new JButton("发送");
        jb.setBounds(450, 300, 100, 30);
        panel.add(jb);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                _url = jf_rec.getText();  //收件人
                _payload = jta_body.getText();   //主题
                _sub = jf_sub.getText(); //正文
                WebService web = new WebService();
                web.doget(_url,_sub,_payload);
            }
        });

        frame.setVisible(true);
    }
}
