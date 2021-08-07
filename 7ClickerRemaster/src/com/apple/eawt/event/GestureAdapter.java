/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt.event;

import com.apple.eawt.event.GesturePhaseEvent;
import com.apple.eawt.event.GesturePhaseListener;
import com.apple.eawt.event.GestureUtilities;
import com.apple.eawt.event.MagnificationEvent;
import com.apple.eawt.event.MagnificationListener;
import com.apple.eawt.event.RotationEvent;
import com.apple.eawt.event.RotationListener;
import com.apple.eawt.event.SwipeEvent;
import com.apple.eawt.event.SwipeListener;

public abstract class GestureAdapter
implements GesturePhaseListener,
MagnificationListener,
RotationListener,
SwipeListener {
    @Override
    public void gestureBegan(GesturePhaseEvent gesturePhaseEvent) {
        GestureUtilities.unimplemented();
    }

    @Override
    public void gestureEnded(GesturePhaseEvent gesturePhaseEvent) {
        GestureUtilities.unimplemented();
    }

    @Override
    public void magnify(MagnificationEvent magnificationEvent) {
        GestureUtilities.unimplemented();
    }

    @Override
    public void rotate(RotationEvent rotationEvent) {
        GestureUtilities.unimplemented();
    }

    @Override
    public void swipedDown(SwipeEvent swipeEvent) {
        GestureUtilities.unimplemented();
    }

    @Override
    public void swipedLeft(SwipeEvent swipeEvent) {
        GestureUtilities.unimplemented();
    }

    @Override
    public void swipedRight(SwipeEvent swipeEvent) {
        GestureUtilities.unimplemented();
    }

    @Override
    public void swipedUp(SwipeEvent swipeEvent) {
        GestureUtilities.unimplemented();
    }
}

