package nskang.std.com.ai;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import nskang.std.com.AI_Service.AI_Service_Main;

/**
 * Created by PC4_kangnamsu on 2015-07-07.
 */
public class AI_BroadcReceiver extends BroadcastReceiver {
    private static final String TAG = "mBroadcReciever";
    static Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            Log.i(TAG, "AI Service Start");
            mContext = context;
            Intent start_mainService;
            if(!AI_Service_Main.Get_Is_Running()) {
                start_mainService = new Intent(mContext, AI_Service_Main.class);
                mContext.startService(start_mainService);
            }
        }
    }
}