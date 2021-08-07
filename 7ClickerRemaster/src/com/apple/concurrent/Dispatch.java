/*
 * Decompiled with CFR 0.151.
 */
package com.apple.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class Dispatch {
    static RuntimeException unimplemented() {
        return new RuntimeException("Unimplemented");
    }

    public static Dispatch getInstance() {
        throw Dispatch.unimplemented();
    }

    public Executor getAsyncExecutor(Priority priority) {
        throw Dispatch.unimplemented();
    }

    public ExecutorService createSerialExecutor(String string) {
        throw Dispatch.unimplemented();
    }

    public Executor getNonBlockingMainQueueExecutor() {
        throw Dispatch.unimplemented();
    }

    public Executor getBlockingMainQueueExecutor() {
        throw Dispatch.unimplemented();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static enum Priority {
        LOW(-2),
        NORMAL(0),
        HIGH(2);


        private Priority(int n2) {
        }
    }
}

