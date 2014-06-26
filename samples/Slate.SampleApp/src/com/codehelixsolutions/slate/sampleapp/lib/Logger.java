package com.codehelixsolutions.slate.sampleapp.lib;

import android.util.Log;



// Very light-weight implementation of the full logger
// in the Slate.Core.Logging namespace.
public class Logger {
	private static LogLevel _logLevel = LogLevel.Debug;

    /**
    * The log level.
    */
    public static LogLevel getLevel()  {
        return _logLevel;
    }

    
    /**
    * Logs debug information
    * 
    *  @param message The message to log
    *  @param ex The exception
    */
    public static void debug(String tag, String message, Exception ex)  {
        log(LogLevel.Debug, tag, message, ex);
    }
    

    /**
    * Logs info information
    * 
    *  @param message The message to log
    *  @param ex The exception
    */
    public static void info(String tag, String message, Exception ex)  {
        log(LogLevel.Info, tag, message, ex);
    }
    

    /**
    * Logs warning information
    * 
    *  @param message The message to log
    *  @param ex The exception
    */
    public static void warn(String tag, String message, Exception ex)  {
        log(LogLevel.Warn, tag, message, ex);
    }
    

    /**
    * Logs error information
    * 
    *  @param message The message to log
    *  @param ex The exception
    */
    public static void error(String tag, String message, Exception ex)  {
        log(LogLevel.Error, tag, message, ex);
    }
    

    /**
    * Logs debug information
    * 
    *  @param message The message to log
    *  @param ex The exception
    */
    public static void log(LogLevel level, String tag, String message, Exception ex)  {
        try
    	{
        	if(level.getValue() == LogLevel.Error.getValue())
    			Log.e(tag, message);
    		if(level.getValue() == LogLevel.Warn.getValue())
    			Log.w(tag, message);
    		if(level.getValue() == LogLevel.Info.getValue())
    			Log.i(tag, message);
    		if(level.getValue() == LogLevel.Debug.getValue())
    			Log.d(tag, message);
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}
