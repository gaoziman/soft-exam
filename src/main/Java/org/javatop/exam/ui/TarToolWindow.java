package org.javatop.exam.ui;

import org.javatop.exam.infrastructure.DataSetting;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TarToolWindow {
    private JPanel mainJPanel;
    private JTabbedPane tabbedPane;
    private JPanel statisticJPanel;
    private JTextPane sTextPane;
    private JSplitPane randomJPanel;
    private JButton rDownButton;
    private JButton rCollectButton;
    private JButton rUpButton;
    private JComboBox rNumComboBox;
    private JButton refreshButton;
    private JButton rAButton;
    private JButton rBButton;
    private JButton rCButton;
    private JButton rDButton;
    private JTextArea rTopicTextPane;
    private JTextArea rAnalysisTextPane;
    private JSplitPane passageJPane;
    private JButton pDownButton;
    private JButton pCollectButton;
    private JButton pUpButton;
    private JComboBox<String> pNumComboBox;
    private JButton chooseButton;
    private JButton pAButton;
    private JButton pBButton;
    private JButton pCButton;
    private JButton pDButton;
    private JTextArea pTopicTextPane;
    private JTextArea pAnalysisTextPane;
    private JSplitPane historyJPane;
    private JButton hDownButton;
    private JButton hCollectButton;
    private JButton hUpButton;
    private JComboBox<String> hNumComboBox;
    private JButton chooseYearButton;
    private JButton hAButton;
    private JButton hBButton;
    private JButton hCButton;
    private JButton hDButton;
    private JTextArea hTopicTextPane;
    private JTextArea hAnalysisTextPane;
    private JTable wrongQueTable;
    private JTable collectTable;

    // 用于存储用户和密码的集合
    private Map<String, String> users = new HashMap<>();

    // 注册弹框的引用
    private JFrame registerFrame;

    // 标志变量，防止在登录成功后切换到主页时弹出注册框
    private boolean suppressChangeListener = false;

    public TarToolWindow() {
        // 检查是否已经登录
        DataSetting dataSetting = DataSetting.getInstance();
        String loggedInUser = dataSetting.getLoggedInUser();
        if (loggedInUser != null && !loggedInUser.isEmpty()) {
            // 已经登录，直接显示主页统计
            SwingUtilities.invokeLater(() -> {
                hideLoginAndRegisterTabs();
                tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("主页统计"));
            });
        } else {
            // 添加注册选项卡
            JPanel registerPanel = new JPanel();
            tabbedPane.addTab("注册", registerPanel);

            // 添加登录选项卡
            JPanel loginPanel = createLoginPanel();
            tabbedPane.addTab("登录", loginPanel);

            // 为选项卡添加监听器
            tabbedPane.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (suppressChangeListener) {
                        return;
                    }

                    int selectedIndex = tabbedPane.getSelectedIndex();
                    String selectedTabTitle = tabbedPane.getTitleAt(selectedIndex);

                    if ("注册".equals(selectedTabTitle)) {
                        SwingUtilities.invokeLater(() -> showRegisterDialog());
                    }
                }
            });
        }
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("用户名:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("密码:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("登录");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);


        /**
         * 登录按钮事件监听器
         */
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                    if (users.containsKey(username) && users.get(username).equals(password)) {
                        JOptionPane.showMessageDialog(panel, "登录成功！");
                        DataSetting.getInstance().setLoggedInUser(username); // 保存登录状态
                        tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("主页统计"));
                        if (registerFrame != null) {
                            registerFrame.dispose(); // 关闭注册弹框
                            registerFrame = null; // 清空引用
                        }
                        hideLoginAndRegisterTabs();
                        suppressChangeListener = false; // 恢复监听器
                    } else if (users.containsKey(username)) {
                        JOptionPane.showMessageDialog(panel, "密码错误！");
                    } else {
                        JOptionPane.showMessageDialog(panel, "用户不存在！");
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "用户名和密码不能为空！");
                }
            }
        });

        return panel;
    }

    /**
     * 显示登录注册弹框
     */
    private void showRegisterDialog() {
        if (registerFrame != null && registerFrame.isVisible()) {
            registerFrame.dispose(); // 关闭之前的弹框
        }
        SettingUI settingUI = new SettingUI();
        registerFrame = new JFrame("注册");
        registerFrame.setContentPane(settingUI.getComponent());
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.pack();
        // 设置窗口大小
        registerFrame.setSize(400, 300);
        // 设置窗口居中显示
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setVisible(true);
        // 注册完成后添加用户到users集合
        settingUI.getRegButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = settingUI.getLoginTextField().getText();
                String password = new String(settingUI.getPasswordField().getText());
                if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                    users.put(username, password); // 修改为同时存储用户名和密码
                    JOptionPane.showMessageDialog(registerFrame, "注册成功！");
                    registerFrame.dispose();
                    suppressChangeListener = true; // 禁用监听器
                    tabbedPane.setSelectedIndex(tabbedPane.indexOfTab("登录"));
                    suppressChangeListener = false; // 恢复监听器
                } else {
                    JOptionPane.showMessageDialog(registerFrame, "用户名和密码不能为空！");
                }
            }
        });
    }


    /**
     * 隐藏登录和注册选项卡
     */
    private void hideLoginAndRegisterTabs() {
        int loginIndex = tabbedPane.indexOfTab("登录");
        int registerIndex = tabbedPane.indexOfTab("注册");
        if (loginIndex != -1) {
            tabbedPane.removeTabAt(loginIndex);
        }
        if (registerIndex != -1) {
            tabbedPane.removeTabAt(registerIndex);
        }
    }

    public JComponent getComponent() {
        return mainJPanel;
    }

    public JTextArea getAnalysisTextPane() {
        return hAnalysisTextPane;
    }

    public JTextArea getTopicTextPane() {
        return hTopicTextPane;
    }

    public JComboBox<String> getNumComboBox() {
        return hNumComboBox;
    }
}
