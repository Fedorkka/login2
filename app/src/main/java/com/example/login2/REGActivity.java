package com.example.login2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class REGActivity extends AppCompatActivity {
    EditText login2;
    EditText password2;
    Button reg;
    Button log_to;
    Bundle arguments;
    private static final String TAG = "MyApp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);
        reg = findViewById(R.id.reg);
        log_to = findViewById(R.id.log_to);
        login2 = findViewById(R.id.login2);
        password2 = findViewById(R.id.password2);
        arguments = getIntent().getExtras();
        try{
            login2.setText(arguments.get("log_text_1").toString());
        }catch (NullPointerException a) {
            login2.setText("");
        }
        try{
            password2.setText(arguments.get("pas_text_1").toString());
        }catch (NullPointerException a) {
            password2.setText("");
        }
        log_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(REGActivity.this, MainActivity.class);
                intent.putExtra("log_text_2", login2.getText());
                intent.putExtra("pas_text_2", password2.getText());
                startActivity(intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean fail = false;

                Toast toast_s = Toast.makeText(getApplicationContext(),
                        "Регистрация выполнена успешно!", Toast.LENGTH_SHORT);
                Toast toast_f = Toast.makeText(getApplicationContext(),
                        "Аккаунт с таким логином уже существует", Toast.LENGTH_SHORT);
                Toast null_t = Toast.makeText(getApplicationContext(),
                        "Недопустимый формат Логина или пароля", Toast.LENGTH_SHORT);
                for (int i = 0; i < Base.base.size(); i++) {
                    fail = login2.getText().toString().equals(Base.base.get(i).login);
                    if (fail) break;
                }
                if (login2.getText().toString().equals("") || login2.getText().toString().equals(""))
                    null_t.show();
                else {
                    if (fail) toast_f.show();
                    else {
                        login2.setText("");
                        password2.setText("");
                        Base.base.add(new Client(login2.getText().toString(),
                                password2.getText().toString()));
                        toast_s.show();
                    }
                }
            }
        });


    }

}
