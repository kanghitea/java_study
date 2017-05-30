package nskang.std.com.DLOG;

import android.util.Log;

/**
 * Created by PC4_kangnamsu on 2017-05-30.
 */
public class DebugLog{
    private final static boolean Log_i = true;
    private final static boolean Log_d = true;
    private final static boolean Log_e = true;

    public static void i(String tag,String msg) {
       if(Log_i) Log.i(tag,msg);
    }

    public static void e(String tag,String msg) {
        if(Log_e) Log.i(tag,msg);
    }

    public static void d(String tag,String msg) {
        if(Log_d) Log.i(tag,msg);
    }
}
