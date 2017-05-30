package nskang.std.com.MSG;

import java.nio.ByteBuffer;

public interface IMainMsg extends IMsg {
    int getTransId();
    int getTimeOut();
    int getSize();
    int parseData(ByteBuffer msgData);
    boolean generateData(ByteBuffer msgData);
}