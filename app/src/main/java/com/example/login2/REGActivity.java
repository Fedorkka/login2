package com.example.login2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class REGActivity extends AppCompatActivity {
    EditText login2;
    EditText password2;
    Button reg;
    Button log_to;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);
        reg = findViewById(R.id.reg);
        log_to = findViewById(R.id.log_to);
        login2 = findViewById(R.id.login2);
        password2 = findViewById(R.id.password2);
        log_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(REGActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Base.base.add(new Client(login2.getText().toString(), password2.getText().toString()));
                Toast toast_s = Toast.makeText(getApplicationContext(),
                        "Регистрация выполнена успешно!", Toast.LENGTH_SHORT);
                toast_s.show();
            }
        });


    }

}
