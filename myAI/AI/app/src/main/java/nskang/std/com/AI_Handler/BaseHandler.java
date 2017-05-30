package nskang.std.com.AI_Handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import nskang.std.com.MSG.ICtrlMsg;
import nskang.std.com.MSG.IMainMsg;
import nskang.std.com.MSG.IMsg;
import nskang.std.com.MSG.ISysMsg;
import nskang.std.com.MSG.WHAT;

public abstract class BaseHandler extends Handler {
    protected BaseHandler(Looper looper) {
        super(looper);
    }
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case WHAT.SYSTEM: {
                Log.e("DEBUG", "==== nskang ==== I'm here in WHAT.SYSTEM " + msg.obj.toString() + msg.obj);
                handleSysMessage((ISysMsg) msg.obj);
            }
            break;

            case WHAT.CONTROL: {
                Log.e("DEBUG", "==== nskang ==== I'm here in WHAT.CONTROL " + msg.obj.toString());
                handleCtrlMessage((ICtrlMsg) msg.obj);
            }
            break;

            case WHAT.UGS: {
                Log.e("DEBUG", "==== nskang ==== I'm here in WHAT.UGS " + msg.obj.toString());
                handleUgsMessage((IMainMsg) msg.obj);
            }
            break;

            default:
                super.handleMessage(msg);
                break;
        }
    }

    public Message makeHandlerMsg(IMsg hrMsg, int what) {
        Message msg = Message.obtain(null, what);
        {
            msg.obj = hrMsg;
        }
        return msg;
    }

    protected abstract void handleSysMessage(ISysMsg sysMsg);

    protected abstract void handleCtrlMessage(ICtrlMsg ctrlMsg);

    protected abstract void handleUgsMessage(IMainMsg ugsMsg);
}
