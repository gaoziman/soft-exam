package org.javatop.exam.ui;

import javax.swing.*;

public class SettingUI {
    private JPanel mainPanel;
    private JTextField loginTextField;
    private JButton loginButton;
    private JButton regButton;
    private JPasswordField passwordField;

    public JComponent getComponent() {
        return mainPanel;
    }

    public JTextField getLoginTextField() {
        return loginTextField;
    }
    public JTextField getPasswordField() {
        return passwordField;
    }
}
