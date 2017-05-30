package nskang.std.com.AI_Service;

import android.os.Handler;

import java.util.HashMap;

import nskang.std.com.callback_1.EventRegistration;
import nskang.std.com.works.first_class;
import nskang.std.com.works.second_class;
import nskang.std.com.works.third_class;

/**
 * Created by PC4_kangnamsu on 2017-05-17.
 */
public class Main_Hash_and_Handler {
    public boolean isRunning = false;
    public HashMap Main_Service_Start(Handler upHandler) {
        isRunning = true;
        HashMap<Integer, EventRegistration> hashMap = new HashMap<>();
        EventRegistration Event_manager = first_class.create();
        first_class.Set_Handler(upHandler);
        hashMap.put(1, Event_manager);
        Event_manager = second_class.create();
        second_class.Set_Handler(upHandler);
        hashMap.put(2, Event_manager);
        Event_manager = third_class.create();
        third_class.Set_Handler(upHandler);
        hashMap.put(3, Event_manager);
        return hashMap;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
