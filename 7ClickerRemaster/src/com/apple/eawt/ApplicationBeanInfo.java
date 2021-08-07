/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt;

import java.awt.Image;
import java.awt.Toolkit;
import java.beans.SimpleBeanInfo;

public class ApplicationBeanInfo
extends SimpleBeanInfo {
    @Override
    public Image getIcon(int n) {
        return Toolkit.getDefaultToolkit().getImage("NSImage://NSGenericApplication");
    }
}

