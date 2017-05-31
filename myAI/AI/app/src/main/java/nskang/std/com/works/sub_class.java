package nskang.std.com.works;

import nskang.std.com.DLOG.DebugLog;

public class sub_class  {
    public int Get_current_count(String TAG, int current_count,int Trigger_Base) {
        ++current_count;
        if(((current_count / Trigger_Base) * Trigger_Base == current_count)) {
            DebugLog.e(TAG, "===============   first call callback method from callee   ==================");
        }
        return current_count;
    }
}
