/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt;

import com.apple.eawt.ApplicationEvent;
import java.util.EventListener;

public interface ApplicationListener
extends EventListener {
    public void handleAbout(ApplicationEvent var1);

    public void handleOpenApplication(ApplicationEvent var1);

    public void handleOpenFile(ApplicationEvent var1);

    public void handlePreferences(ApplicationEvent var1);

    public void handlePrintFile(ApplicationEvent var1);

    public void handleQuit(ApplicationEvent var1);

    public void handleReOpenApplication(ApplicationEvent var1);
}

