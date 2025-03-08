package com.grupo10.aidl_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

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

        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}