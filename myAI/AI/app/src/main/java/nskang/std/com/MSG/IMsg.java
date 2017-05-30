package nskang.std.com.MSG;
public interface IMsg {
    int getMsgType();
    //
    int getSrc();
    int getDest();

    //
    int TIME_OUT            = (5 * 1000); // 5 seconds

    int IMSG_OK             = 0;
    int IMSG_NOT_OK         = 1;
    int IMSG_WRITE_FAIL     = -1;
}