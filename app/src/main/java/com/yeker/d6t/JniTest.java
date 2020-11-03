package com.yeker.d6t;

public class JniTest {
    static {
        System.loadLibrary("JniLib");
    }
    public static native String getString();
}
