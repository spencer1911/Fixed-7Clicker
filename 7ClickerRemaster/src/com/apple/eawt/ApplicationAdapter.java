/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt;

import com.apple.eawt.Application;
import com.apple.eawt.ApplicationEvent;
import com.apple.eawt.ApplicationListener;

public class ApplicationAdapter
implements ApplicationListener {
    @Override
    public void handleAbout(ApplicationEvent applicationEvent) {
        throw Application.unimplemented();
    }

    @Override
    public void handleOpenApplication(ApplicationEvent applicationEvent) {
        throw Application.unimplemented();
    }

    @Override
    public void handleOpenFile(ApplicationEvent applicationEvent) {
        throw Application.unimplemented();
    }

    @Override
    public void handlePreferences(ApplicationEvent applicationEvent) {
        throw Application.unimplemented();
    }

    @Override
    public void handlePrintFile(ApplicationEvent applicationEvent) {
        throw Application.unimplemented();
    }

    @Override
    public void handleQuit(ApplicationEvent applicationEvent) {
        throw Application.unimplemented();
    }

    @Override
    public void handleReOpenApplication(ApplicationEvent applicationEvent) {
        throw Application.unimplemented();
    }
}

