package nskang.std.com.AI_Service;

import java.util.HashMap;

import nskang.std.com.AI_Handler.MainHandler;
import nskang.std.com.callback_1.EventRegistration;
import nskang.std.com.works.first_class;
import nskang.std.com.works.second_class;
import nskang.std.com.works.third_class;

/**
 * Created by PC4_kangnamsu on 2017-05-17.
 */
public class Main_Hash_and_Handler {
    public boolean isRunning = false;
    public HashMap Main_Service_Start(MainHandler upHandler) {
        isRunning = true;
        HashMap<Integer, EventRegistration> hashMap = new HashMap<>();

        first_class mfirst_class = new first_class();
        mfirst_class.prepare_handler();
        EventRegistration Event_manager = mfirst_class.create();
        mfirst_class.Set_Handler(upHandler);
        hashMap.put(1, Event_manager);

        second_class msecond_class = new second_class();
        msecond_class.prepare_handler();
        Event_manager = msecond_class.create();
        msecond_class.Set_Handler(upHandler);
        hashMap.put(2, Event_manager);

        third_class mthird_class = new third_class();
        mthird_class.prepare_handler();
        Event_manager = mthird_class.create();
        mthird_class.Set_Handler(upHandler);
        hashMap.put(3, Event_manager);
        return hashMap;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
