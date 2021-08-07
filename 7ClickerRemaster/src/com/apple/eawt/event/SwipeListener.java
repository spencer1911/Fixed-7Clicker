/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt.event;

import com.apple.eawt.event.GestureListener;
import com.apple.eawt.event.SwipeEvent;

public interface SwipeListener
extends GestureListener {
    public void swipedUp(SwipeEvent var1);

    public void swipedDown(SwipeEvent var1);

    public void swipedLeft(SwipeEvent var1);

    public void swipedRight(SwipeEvent var1);
}

