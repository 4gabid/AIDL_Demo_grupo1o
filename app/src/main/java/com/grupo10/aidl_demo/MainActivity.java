package com.grupo10.aidl_demo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private IMyAidlInterface demoService;
    private boolean isBound = false;


    private EditText num1, num2;
    private TextView resultado;
    private Button btnCalcular;


    private ServiceConnection serverConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            demoService = IMyAidlInterface.Stub.asInterface(iBinder);
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound =false;
            demoService = null;

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.grupo10.aidl_demo", "com.grupo10.aidl_demo.DemoService"));

        bindService(intent, serverConnection, BIND_AUTO_CREATE);


        btnCalcular= findViewById(R.id.btnCalcular);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultado = findViewById(R.id.resultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int valor1 = Integer.parseInt(num1.getText().toString());
                    int valor2 = Integer.parseInt(num2.getText().toString());
                    int resultadoSoma = demoService.somar(valor1, valor2);
                    resultado.setText("Resultado: " + resultadoSoma);
                    demoService.mandar_mensagem(" "+ resultadoSoma);
                    int novaCor = demoService.mudar_cor(resultadoSoma);
                    btnCalcular.setBackgroundColor(novaCor);

                }catch (RemoteException e){
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Exemplo de uso do serviço assim que a Activity fica em primeiro plano
        if (isBound && demoService!= null) {
            try {
                int resultado = demoService.somar(2, 3);
                Log.d("AIDL_DEMO", "Resultado da soma: " + resultado);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(isBound){
          isBound = false;
          unbindService(serverConnection);

        }
    }
}