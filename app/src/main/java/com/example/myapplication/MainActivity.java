package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ecnryptButton,decryptButton;
    private EditText key,plain_cyper_txt;
    private TextView resultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initWorks();
    }

    private void initWorks()
    {
        ecnryptButton = (Button) findViewById(R.id.ecnryptButton);
        decryptButton = (Button) findViewById(R.id.decryptButton);


        key = (EditText) findViewById(R.id.key);
        plain_cyper_txt = (EditText) findViewById(R.id.plain_cyper_txt);


        resultLabel = (TextView) findViewById(R.id.resultLabel);


        ecnryptButton.setOnClickListener(this);
        decryptButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==ecnryptButton.getId())
            this.encryptProcess();
        else if(view.getId()==decryptButton.getId())
            this.decryptProcess();

    }

    private void encryptProcess() {
        int int_key = Integer.parseInt(this.key.getText().toString());
        if (int_key<0)
            return;


       Algorithm algorithm = new  Algorithm(int_key,this);
       String result = algorithm.encrypt(this.plain_cyper_txt.getText().toString());
//
       this.resultLabel.setText(result);
    }

    private void decryptProcess() {

        int int_key =Integer.parseInt(this.key.getText().toString());
        if (int_key<0)
            return;

        Algorithm algorithm = new  Algorithm(int_key,this);
        String result = algorithm.decrypt(this.plain_cyper_txt.getText().toString());

        this.resultLabel.setText(result);
    }
}
