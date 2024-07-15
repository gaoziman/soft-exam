package org.javatop.exam.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.javatop.exam.ui.SettingUI;

import javax.swing.*;

public class MyAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // Project project = e.getData(PlatformDataKeys.PROJECT);
        // PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        // String classPath = psiFile.getVirtualFile().getPath();
        //
        // Messages.showMessageDialog(project, "guide-idea-plugin-create-project-by-platform: " + classPath, "Hi IDEA Plugin", Messages.getInformationIcon());

        SettingUI settingUI = new SettingUI();
        JFrame frame = new JFrame("登录注册");
        frame.setContentPane(settingUI.getComponent());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        // 设置窗口大小为400x300像素
        frame.setSize(400, 150);
        // 设置窗口居中显示
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}