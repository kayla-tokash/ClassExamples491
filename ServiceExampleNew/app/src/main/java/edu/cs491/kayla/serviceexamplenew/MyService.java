package edu.cs491.kayla.serviceexamplenew;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {
    /*
     A bound service allows for active communication between the service and the main activity

     it acts as a pipe
     */

    private IBinder myTempBinder = new myBinder();

    public MyService() {
    }

    public class myBinder extends Binder {
        MyService getService() {
            // Getting the parent of the embedded class
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myTempBinder;
    }

    public String sendJunk() {
        return "JUNK"; // Example of a method accessible via the binder
    }
}
