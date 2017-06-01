package nskang.std.com.MSG;

public class CMSG {
    private static Integer mTransSeq = 0;
    private final int mMsgFrom;
    private int mTransId = 0;
    private int mSrc = 0;
    private int mDest = 0;
    private int mTimeOut = 5 * 1000;
    private long mEventTime = 0;

    public CMSG(int msgFrom) {
        mMsgFrom = msgFrom;
        mTransId = generateTransId();
        mEventTime = System.currentTimeMillis();
    }

    public int getMsgFrom() {
        return mMsgFrom;
    }

    public int getTransId() {
        return mTransId;
    }

    public void setTransId(int transId) {
        mTransId = transId;
    }

    public int getSrc() {
        return mSrc;
    }

    public void setSrc(int src) {
        mSrc = src;
    }

    public long getmEventTime() {
        return mEventTime;
    }

    public int getDest() {
        return mDest;
    }

    public void setDest(int dest) {
        mDest = dest;
    }

    public int getTimeOut() {
        return mTimeOut;
    }

    public void setTimeOut(int timeOut) {
        mTimeOut = timeOut;
    }

    private static int generateTransId() {
        synchronized (mTransSeq) {
            mTransSeq = (++mTransSeq & 0xEFFFFFFF);
            return mTransSeq;
        }
    }
}