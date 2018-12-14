package com.example.login2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean success = false;
    Button log;
    Button reg_to;
    EditText login1;
    EditText pas1;
    Toast toast_s;
    Toast toast_f;
    Bundle arguments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = findViewById(R.id.avt);
        reg_to = findViewById(R.id.reg_to);
        login1 = findViewById(R.id.login1);
        pas1 = findViewById(R.id.password1);
        arguments = getIntent().getExtras();
        try{
            login1.setText(arguments.get("log_text_2").toString());
        }catch (NullPointerException a) {
            login1.setText("");
        }
        try{
            pas1.setText(arguments.get("pas_text_2").toString());
        }catch (NullPointerException a) {
            pas1.setText("");
        }
        toast_s = Toast.makeText(getApplicationContext(),
                "Вход выполнен успешно!", Toast.LENGTH_SHORT);
        toast_f = Toast.makeText(getApplicationContext(),
                "Введен неверный логин или пароль!", Toast.LENGTH_SHORT);


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < Base.base.size(); i++) {
                    success = login1.getText().toString().equals(Base.base.get(i).login) &&
                            pas1.getText().toString().equals(Base.base.get(i).password);
                    if (success) break;
                }
                if (success){
                    login1.setText("");
                    pas1.setText("");
                    toast_s.show();
                }
                else toast_f.show();
            }
        });
        reg_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, REGActivity.class);
                intent.putExtra("log_text_1", login1.getText());
                intent.putExtra("pas_text_1", pas1.getText());
                startActivity(intent);

            }
        });
    }
}

