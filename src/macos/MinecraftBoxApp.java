import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MinecraftBoxApp extends JFrame {
    public MinecraftBoxApp() {
        setTitle("多玩我的世界盒子");
        setSize(500, 200);
        getContentPane().setBackground(new Color(238, 242, 246)); // 设置应用程序的背景色
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addButton("资源中心", "https://mcbbs.app");
        addButton("论坛", "https://mcbbs.app");
    }

    private void addButton(String buttonText, String url) {
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(250, 30));
        button.setBackground(new Color(171, 205, 239));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(new Font("Sarasa", Font.PLAIN, 14));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage(url);
            }
        });
        add(button);
        add(Box.createRigidArea(new Dimension(0, 10))); // 添加间距
    }

    private void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            JOptionPane.showMessageDialog(this, "打开网页失败", "错误", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MinecraftBoxApp app = new MinecraftBoxApp();
                app.setVisible(true);
            }
        });
    }
}
