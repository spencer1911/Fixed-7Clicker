/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eawt;

import com.apple.eawt.Application;
import java.util.EventObject;

public class ApplicationEvent
extends EventObject {
    ApplicationEvent(Object object) {
        super(object);
        throw Application.unimplemented();
    }

    ApplicationEvent(Object object, String string) {
        super(object);
        throw Application.unimplemented();
    }

    public boolean isHandled() {
        throw Application.unimplemented();
    }

    public void setHandled(boolean bl) {
        throw Application.unimplemented();
    }

    public String getFilename() {
        throw Application.unimplemented();
    }
}

