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
    List<ArrayList<String>> base = new ArrayList<ArrayList<String>>();
    Button log = findViewById(R.id.avt);
    Button reg = findViewById(R.id.reg);
    Button log_to = findViewById(R.id.log_to);
    Button reg_to = findViewById(R.id.reg_to);
    EditText login1 = findViewById(R.id.login1);
    EditText login2 = findViewById(R.id.login2);
    EditText pas1 = findViewById(R.id.password1);
    EditText  pas2= findViewById(R.id.password2);
    Toast toast_s = Toast.makeText(getApplicationContext(), "Вход выполнен успешно!", Toast.LENGTH_SHORT);
    Toast toast_f = Toast.makeText(getApplicationContext(), "Введен неверный логин или пароль!", Toast.LENGTH_SHORT);
    boolean success= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                for(i=0; i<base.size(); i++){
                    if(login1.getText().toString().equals(base.get(i).get(0))){
                        success= true;
                    }else success= false;
                }
                if(success) toast_s.show();
                else toast_f.show();
            }
        });
        reg_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegActyvity.class);
                startActivity(intent);

                }
        });
        }
}

