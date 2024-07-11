package org.javatop.exam.factory;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.util.NlsContexts;
import org.javatop.exam.ui.SettingUI;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;


public class SettingFactory implements SearchableConfigurable {

    private SettingUI settingUI = new SettingUI();


    @Override
    public @NotNull
    @NonNls String getId() {
        return "soft-setting.id";
    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "soft-setting";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return settingUI.getComponent();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {

    }
}