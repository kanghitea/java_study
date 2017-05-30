package nskang.std.com.AI_Service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;

import java.util.HashMap;
import java.util.Iterator;

import nskang.std.com.AI_Handler.MainHandler;
import nskang.std.com.DLOG.DebugLog;
import nskang.std.com.ai.MainActivity;
import nskang.std.com.ai.R;
import nskang.std.com.callback_1.EventRegistration;

/**
 * Created by PC4_kangnamsu on 2015-07-07.
 */

public class AI_Service_Main extends Service {
    private static final String TAG = AI_Service_Main.class.getSimpleName();
    private static boolean isRunning = false, looping = false;
    private HashMap<Integer, EventRegistration> mManagerMap;
    private AI_Service_MainThread mAI_Service_MainThread;
    private Main_Hash_and_Handler mMain_Hash_and_Handler;
    private HandlerThread mMainThread;
    private MainHandler mMainHandler;

    private Notification mNotifications;
    private static final int NOTIFICATION_ID = 1;
    private static final String TITLE = "nsApp";

    @Override
    public void onCreate() {
        super.onCreate();
        DebugLog.i(TAG, "============= AI_SERIVCE_MAIN ==========  ");
        if (Get_Is_Running()) {
            Set_Looping_status(false);
            while (Get_Is_Running()) {
            }
        }

        // make it foreground service ...
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            showNotification();
        } else {
            showNotification();
        }

        Set_Looping_status(true);
        mAI_Service_MainThread = new AI_Service_MainThread();
        mAI_Service_MainThread.setName(TAG);
        mAI_Service_MainThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        DebugLog.i(TAG, "============= onStartCommand ==========  ");
        return START_STICKY;
    }

    private class AI_Service_MainThread extends Thread {

        @Override
        public void run() {
            super.run();
            DebugLog.i(TAG, "============= AI_Service_MainThread ==========  ");
            Set_Is_Running(true);

            //hashmap added

            mMainThread = new HandlerThread("MainManager Thread");
            mMainThread.start();
            mMainHandler = new MainHandler(mMainThread.getLooper());
            mMain_Hash_and_Handler = new Main_Hash_and_Handler();
            if (!mMain_Hash_and_Handler.isRunning()) {
                mManagerMap = mMain_Hash_and_Handler.Main_Service_Start(mHandler);
            }

            while (Get_Looping_status()) {
                DebugLog.i(TAG, "===== while(looping)!!");
                loop_countinuasly();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    DebugLog.e(TAG, "===== Interrupt Exception Error occurs!!");
                }
            }
            Set_Is_Running(false);
        }
    }

    public void loop_countinuasly() {
        Iterator<EventRegistration> itr = mManagerMap.values().iterator();

        while (itr.hasNext()) {
            EventRegistration Eventwork = itr.next();
            Eventwork.doWork();
        }
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static boolean Get_Is_Running() {
        return isRunning;
    }

    public static void Set_Is_Running(boolean val) {
        isRunning = val;
    }

    public static boolean Get_Looping_status() {
        return looping;
    }

    public static void Set_Looping_status(boolean val) {
        looping = val;
    }

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    DebugLog.i(TAG, "========  handler RCV : 0 ============");
                    mMainHandler.handleCtrlMessage(null);
                    break;
                case 1:
                    DebugLog.i(TAG, "========  handler RCV : 1 ============");
                    mMainHandler.handleSysMessage(null);
                    break;
                case 2:
                    DebugLog.i(TAG, "========  handler RCV : 2 ============");
                    mMainHandler.handleCtrlMessage(null);
                    break;
                case 3:
                    DebugLog.i(TAG, "========  handler RCV : 3 ============");
                    mMainHandler.handleUgsMessage(null);
                    break;
            }
        }
    };


    private void showNotification() {
        Intent notiIntent = new Intent(getApplicationContext(), MainActivity.class);
        mNotifications = new Notification.Builder(getApplicationContext())
                .setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, notiIntent, 0))
                .setSmallIcon(R.drawable.ic_launcher)
                .setAutoCancel(false).getNotification();
        mNotifications.flags |= Notification.FLAG_ONGOING_EVENT;
        startForeground(NOTIFICATION_ID, mNotifications);
    }
}
