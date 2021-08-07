/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt;

import com.apple.eawt.Application;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class CocoaComponent
extends Canvas {
    public abstract int createNSView();

    @Override
    public void update(Graphics graphics) {
        throw Application.unimplemented();
    }

    @Override
    public void paint(Graphics graphics) {
        throw Application.unimplemented();
    }

    public long createNSViewLong() {
        throw Application.unimplemented();
    }

    public final void sendMessage(int n, Object object) {
        throw Application.unimplemented();
    }

    @Override
    public abstract Dimension getMaximumSize();

    @Override
    public abstract Dimension getMinimumSize();

    @Override
    public abstract Dimension getPreferredSize();
}

