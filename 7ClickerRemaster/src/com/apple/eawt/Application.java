/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt;

import com.apple.eawt.ApplicationListener;
import java.awt.Image;
import java.awt.Point;
import java.awt.PopupMenu;
import javax.swing.JMenuBar;

public class Application {
    static RuntimeException unimplemented() {
        return new RuntimeException("Unimplemented");
    }

    @Deprecated
    public Application() {
        throw Application.unimplemented();
    }

    public static Application getApplication() {
        throw Application.unimplemented();
    }

    public void addApplicationListener(ApplicationListener applicationListener) {
        throw Application.unimplemented();
    }

    public void removeApplicationListener(ApplicationListener applicationListener) {
        throw Application.unimplemented();
    }

    public void setEnabledPreferencesMenu(boolean bl) {
        throw Application.unimplemented();
    }

    public void setEnabledAboutMenu(boolean bl) {
        throw Application.unimplemented();
    }

    public boolean getEnabledPreferencesMenu() {
        throw Application.unimplemented();
    }

    public boolean getEnabledAboutMenu() {
        throw Application.unimplemented();
    }

    public boolean isAboutMenuItemPresent() {
        throw Application.unimplemented();
    }

    public void addAboutMenuItem() {
        throw Application.unimplemented();
    }

    public void removeAboutMenuItem() {
        throw Application.unimplemented();
    }

    public boolean isPreferencesMenuItemPresent() {
        throw Application.unimplemented();
    }

    public void addPreferencesMenuItem() {
        throw Application.unimplemented();
    }

    public void removePreferencesMenuItem() {
        throw Application.unimplemented();
    }

    @Deprecated
    public static Point getMouseLocationOnScreen() {
        throw Application.unimplemented();
    }

    public void requestForeground(boolean bl) {
        throw Application.unimplemented();
    }

    public void requestUserAttention(boolean bl) {
        throw Application.unimplemented();
    }

    public void openHelpViewer() {
        throw Application.unimplemented();
    }

    public void setDockMenu(PopupMenu popupMenu) {
        throw Application.unimplemented();
    }

    public PopupMenu getDockMenu() {
        throw Application.unimplemented();
    }

    public void setDockIconImage(Image image) {
        throw Application.unimplemented();
    }

    public Image getDockIconImage() {
        throw Application.unimplemented();
    }

    public void setDockIconBadge(String string) {
        throw Application.unimplemented();
    }

    public void setDefaultMenuBar(JMenuBar jMenuBar) {
        throw Application.unimplemented();
    }
}

