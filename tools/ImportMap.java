package tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ImportMap extends JFrame {

    private JTextField zipFilePathTextField;
    private JTextField extractPathTextField;
    private JButton extractButton;

    public static String extractZip(String zipFilePath, String destDirPath) throws IOException {
    File destDir = new File(destDirPath);
    // 如果目标文件夹不存在，则创建它
    if (!destDir.exists()) {
        destDir.mkdir();
    }

    ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
    ZipEntry entry = zipIn.getNextEntry();
    // 遍历zip文件中的每一个条目
    while (entry != null) {
        String filePath = destDirPath + File.separator + entry.getName();
        if (!entry.isDirectory()) {
            // 如果该条目是一个文件，则将它写入到目标文件夹中
            extractFile(zipIn, filePath);
        } else {
            // 如果该条目是一个文件夹，则创建它
            File dir = new File(filePath);
            dir.mkdir();
        }
        zipIn.closeEntry();
        entry = zipIn.getNextEntry();
    }
    zipIn.close();
    return destDirPath;
}

private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
    byte[] bytesIn = new byte[4096];
    int read = 0;
    // 将zip文件中的数据写入到目标文件中
    while ((read = zipIn.read(bytesIn)) != -1) {
        bos.write(bytesIn, 0, read);
    }
    bos.close();
}
    public ImportMap() {
        setTitle("多玩我的世界盒子地图安装器");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel zipFilePathLabel = new JLabel("请输入您地图压缩包的路径:");
        zipFilePathTextField = new JTextField();
        JLabel extractPathLabel = new JLabel("请输入.minecraft文件夹位置:");
        extractPathTextField = new JTextField();
        extractButton = new JButton("安装");
        extractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extractButtonClicked();
            }
        });

        mainPanel.add(zipFilePathLabel);
        mainPanel.add(zipFilePathTextField);
        mainPanel.add(extractPathLabel);
        mainPanel.add(extractPathTextField);
        mainPanel.add(new JPanel());
        mainPanel.add(extractButton);

        setContentPane(mainPanel);
    }

    private void extractButtonClicked() {
        String zipFilePath = zipFilePathTextField.getText();
        String extractPath = extractPathTextField.getText();

        try {
            String result = ImportMap.extractZip(zipFilePath, extractPath);
            JOptionPane.showMessageDialog(this, "成功安装地图: " + result);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "安装地图失败: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImportMap importMapGUI = new ImportMap();
                importMapGUI.setVisible(true);
            }
        });
    }
}