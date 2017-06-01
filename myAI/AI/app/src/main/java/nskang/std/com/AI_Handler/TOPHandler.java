package nskang.std.com.AI_Handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import nskang.std.com.MSG.CMSG;
import nskang.std.com.MSG.WHAT;

public abstract class BaseHandler extends Handler {
    protected BaseHandler(Looper looper) {
        super(looper);
    }
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case WHAT.MSG1: {
                handleSysMessage((CMSG) msg.obj);
            }
            break;

            case WHAT.MSG2: {
                handleCtrlMessage((CMSG) msg.obj);
            }
            break;

            case WHAT.MSG3: {
                handleWorksMessage((CMSG) msg.obj);
            }
            break;

            default:
                super.handleMessage(msg);
                break;
        }
    }

    public Message makeHandlerMsg(String obj, int what) {
        Message msg = Message.obtain(null, what);
        {
            msg.obj = obj;
        }
        return msg;
    }

    public Message makeHandlerMsg(CMSG obj, int what) {
        Message msg = Message.obtain(null, what);
        {
            msg.obj = obj;
        }
        return msg;
    }

    protected abstract void handleSysMessage(CMSG msg);

    protected abstract void handleCtrlMessage(CMSG msg);

    protected abstract void handleWorksMessage(CMSG msg);
}
