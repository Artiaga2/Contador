package com.example.a2_daw.contador;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView textView;
    public int valor = 0;
    private static final String EXTRA_CONTADOR = "CONTADOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView =  (TextView) findViewById(R.id.texto);
        valor = getIntent().getIntExtra(EXTRA_CONTADOR, 0);
        textView.setText(valor +"");
    }

    public static Intent newIntent(Context appcontex, int contador){
        Intent intent = new Intent(appcontex, InfoActivity.class);
        intent.putExtra(EXTRA_CONTADOR, contador);

        return intent;
    }

}
