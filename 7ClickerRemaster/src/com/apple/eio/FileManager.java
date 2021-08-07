/*
 * Decompiled with CFR 0.151.
 */
package com.apple.eio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileManager {
    public static final short kOnAppropriateDisk = -32767;
    public static final short kSystemDomain = -32766;
    public static final short kLocalDomain = -32765;
    public static final short kNetworkDomain = -32764;
    public static final short kUserDomain = -32763;

    static RuntimeException unimplemented() {
        return new RuntimeException("Unimplemented");
    }

    public static int OSTypeToInt(String string) {
        throw FileManager.unimplemented();
    }

    public static void setFileTypeAndCreator(String string, int n, int n2) throws IOException {
        throw FileManager.unimplemented();
    }

    public static void setFileType(String string, int n) throws IOException {
        throw FileManager.unimplemented();
    }

    public static void setFileCreator(String string, int n) throws IOException {
        throw FileManager.unimplemented();
    }

    public static int getFileType(String string) throws IOException {
        throw FileManager.unimplemented();
    }

    public static int getFileCreator(String string) throws IOException {
        throw FileManager.unimplemented();
    }

    public static String findFolder(int n) throws FileNotFoundException {
        throw FileManager.unimplemented();
    }

    public static String findFolder(short s, int n) throws FileNotFoundException {
        throw FileManager.unimplemented();
    }

    public static String findFolder(short s, int n, boolean bl) throws FileNotFoundException {
        throw FileManager.unimplemented();
    }

    @Deprecated
    public static void openURL(String string) throws IOException {
        throw FileManager.unimplemented();
    }

    public static String getResource(String string) throws FileNotFoundException {
        throw FileManager.unimplemented();
    }

    public static String getResource(String string, String string2) throws FileNotFoundException {
        throw FileManager.unimplemented();
    }

    public static String getResource(String string, String string2, String string3) throws FileNotFoundException {
        throw FileManager.unimplemented();
    }

    public static String getPathToApplicationBundle() {
        throw FileManager.unimplemented();
    }

    public static boolean moveToTrash(File file) throws FileNotFoundException {
        throw FileManager.unimplemented();
    }

    public static boolean revealInFinder(File file) throws FileNotFoundException {
        throw FileManager.unimplemented();
    }
}

