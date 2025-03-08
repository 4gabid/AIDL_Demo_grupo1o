package com.grupo10.aidl_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class DemoService extends Service {


    private IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {
        @Override
        public int somar(int a, int b) throws RemoteException {
            return 0;
        }

        @Override
        public int mudar_cor(int color) throws RemoteException {
            return 0;
        }

        @Override
        public void mandar_mensagem(String mensagem) throws RemoteException {

            Log.d(  "Demo Service", "Message sent: "+ mensagem);
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
       return binder;

    }
}