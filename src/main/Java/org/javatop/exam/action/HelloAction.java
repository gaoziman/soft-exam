package org.javatop.exam.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class HelloAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // TODO: insert action logic here
        Messages.showInfoMessage("您好，我是HelloWorld，第一个插件提示","Hello World");

       String selectedText = e.getDataContext().getData(PlatformDataKeys.EDITOR)
               .getCaretModel().getCurrentCaret()
              .getSelectedText();
       Messages.showInfoMessage(selectedText, "Hello");
    }

}
