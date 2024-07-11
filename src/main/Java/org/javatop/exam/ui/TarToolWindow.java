package org.javatop.exam.ui;

import javax.swing.*;

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
    private JComboBox pNumComboBox;
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
    private JComboBox hNumComboBox;
    private JButton chooseYearButton;
    private JButton hAButton;
    private JButton hBButton;
    private JButton hCButton;
    private JButton hDButton;
    private JTextArea hTopicTextPane;
    private JTextArea hAnalysisTextPane;
    private JTable wrongQueTable;
    private JTable collectTable;

    public JComponent getComponent() {
        return mainJPanel;
    }

    public JTextArea getAnalysisTextPane() {
        return hAnalysisTextPane;
    }

    public JTextArea getTopicTextPane() {
        return hTopicTextPane;
    }

    public JComboBox getNumComboBox() {
        return hNumComboBox;
    }
}
