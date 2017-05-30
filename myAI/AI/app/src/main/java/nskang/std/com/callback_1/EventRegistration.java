package nskang.std.com.callback_1;

/**
 * Created by PC4_kangnamsu on 2017-05-17.
 */
public class EventRegistration {
        private CallbackEvent callbackEvent;

        public EventRegistration(CallbackEvent event){
            callbackEvent = event;
        }

        public void doWork(){
            callbackEvent.callbackMethod();
        }
}
