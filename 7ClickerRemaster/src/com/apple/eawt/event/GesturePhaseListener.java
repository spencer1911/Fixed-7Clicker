/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt.event;

import com.apple.eawt.event.GestureListener;
import com.apple.eawt.event.GesturePhaseEvent;

public interface GesturePhaseListener
extends GestureListener {
    public void gestureBegan(GesturePhaseEvent var1);

    public void gestureEnded(GesturePhaseEvent var1);
}

