package src.macos;

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

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("多玩我的世界盒子");
        label.setFont(new Font("Sarasa", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label, gbc);

        JButton button1 = new JButton("资源中心");
        button1.setPreferredSize(new Dimension(250, 30));
        button1.setBackground(new Color(171, 205, 239));
        button1.setBorder(BorderFactory.createEmptyBorder());
        button1.setFont(new Font("Sarasa", Font.PLAIN, 14));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://mcbbs.app");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(button1, gbc);

        JButton button2 = new JButton("论坛");
        button2.setPreferredSize(new Dimension(250, 30));
        button2.setBackground(new Color(171, 205, 239));
        button2.setBorder(BorderFactory.createEmptyBorder());
        button2.setFont(new Font("Sarasa", Font.PLAIN, 14));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://mcbbs.app");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(button2, gbc);
    }

    private void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
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