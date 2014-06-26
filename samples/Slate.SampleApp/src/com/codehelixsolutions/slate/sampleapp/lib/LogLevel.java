package com.codehelixsolutions.slate.sampleapp.lib;

public enum LogLevel
{
	 Debug(0),
     Info(1),
     Warn(2),
     Error(3),
     Off(4);
     
     
     private final int value;
     private LogLevel(int value) {
         this.value = value;
     }

     public int getValue() {
         return value;
     }
}

