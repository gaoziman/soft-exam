package org.javatop.exam.factory;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentFactoryImpl;
import org.javatop.exam.ui.TarToolWindow;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


@SuppressWarnings("ALL")
public class ToolFactory implements ToolWindowFactory {

    private TarToolWindow tarToolWindows = new TarToolWindow();

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // 获取内容工厂的实例
        // ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        ContentFactory contentFactory = new ContentFactoryImpl();
        // 获取 ToolWindow 显示的内容
        Content content = contentFactory.createContent(tarToolWindows.getComponent(), "", false);
        // 设置 ToolWindow 显示的内容
        toolWindow.getContentManager().addContent(content);
        //todo 测试展示，之后删除
        tarToolWindows.getAnalysisTextPane().setText("解析为2341231231231231231231231231231231231231231231231");
        JComboBox<String> numComboBox = tarToolWindows.getNumComboBox();
        numComboBox.addItem("1");
        numComboBox.addItem("2");
        numComboBox.addItem("3");
        numComboBox.addItem("4");
        numComboBox.addItem("5");
        numComboBox.addItem("6");
        tarToolWindows.getTopicTextPane().setText("题目为1234567890");
    }

}
