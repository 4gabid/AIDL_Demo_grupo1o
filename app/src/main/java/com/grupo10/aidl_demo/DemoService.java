package com.grupo10.aidl_demo;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.Random;

public class DemoService extends Service {


    private IMyAidlInterface.Stub binder = new IMyAidlInterface.Stub() {
        @Override
        public int somar(int a, int b) throws RemoteException {
            return a+b;
        }

        @Override
        public int mudar_cor(int color) throws RemoteException {

            Random random = new Random(color);

            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            return Color.rgb(red, green, blue);
        }

        @Override
        public void mandar_mensagem(String mensagem) throws RemoteException {

            Log.d(  "Demo_Service", "Resultado:"+ mensagem);
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
       return binder;

    }
}