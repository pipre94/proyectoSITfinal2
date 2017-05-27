package com.example.andresteran_i014213.projectofinal_sti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andresteran_i014213.projectofinal_sti.Data.DataUser;
import com.example.andresteran_i014213.projectofinal_sti.Models.User;
import com.example.andresteran_i014213.projectofinal_sti.Views.ContainerActivity;
import com.example.andresteran_i014213.projectofinal_sti.Views.CreateAccountActivity;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    DataUser dataUser;
    Button login;
    EditText usernameLogin,passwordLogin;
    User userLogin;
    List<User> userList;
    String[] findUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.buttonLogin);
        usernameLogin = (EditText) findViewById(R.id.id_login_username);
        passwordLogin = (EditText) findViewById(R.id.id_login_password);
        dataUser = new DataUser(this);
        dataUser.open();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameLogin.getText().toString().equals("")||passwordLogin.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_SHORT).show();
                }
                else {
                    findUser = new String[3];
                    findUser = dataUser.findUser(usernameLogin.getText().toString(),passwordLogin.getText().toString());
                    if (findUser[0].toString()==(usernameLogin.getText().toString())){
                        Toast.makeText(getApplicationContext(), "EXITO", Toast.LENGTH_SHORT).show();
                    }else if (findUser[2]=="no"){Toast.makeText(getApplicationContext(), "Mierda", Toast.LENGTH_SHORT).show();}

                }
            }
        });

    }

    public void onShowAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goCreateContainer(){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }


}