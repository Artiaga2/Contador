package com.example.a2_daw.contador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ContActivity extends AppCompatActivity {

    private TextView contadorTextView;
    private Button contadorBtn;
    private Button siguienteBtn;
//    private Intent infoActivity;
    private static final String TAG = "MainActivity";
    private static final String CONTADOR = "Contador";
    private static final String EXTRA_CONTADOR = "CONTADOR";



    //Modelo
    private int mvalor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate() llamado");
        setContentView(R.layout.activity_cont);


        contadorBtn = (Button) findViewById(R.id.button);
        contadorTextView = (TextView) findViewById(R.id.contador);
        siguienteBtn = (Button) findViewById(R.id.siguiente);

        if (savedInstanceState != null){
            mvalor = savedInstanceState.getInt(CONTADOR);
        }

        contadorTextView.setText("" + mvalor);

     contadorBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             //Actualizo el modelo
             mvalor++;

             //Actualizo la vista
             contadorTextView.setText(mvalor + "");
         }
     });

     siguienteBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = InfoActivity.newIntent(ContActivity.this, mvalor);
             intent.putExtra(EXTRA_CONTADOR, mvalor);
             startActivity(intent);
         }
     });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart llamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause llamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop llamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume llamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy llamado");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(CONTADOR, mvalor);
    }
}
