package tn.esprit.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
EditText userName,password;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String  userNameText=userName.getText().toString();
               String passwordText=password.getText().toString();
               if (userNameText.isEmpty()||passwordText.isEmpty())
               {
                   Toast.makeText(getApplicationContext(),"Veuillez renseigner les champs!!",Toast.LENGTH_SHORT).show();
               }else
               {
                   UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
                   UserDao userDao=userDatabase.userDao();
                   new Thread(new Runnable() {
                       @Override
                       public void run() {
                    UserEntity userEntity=userDao.login(userNameText,passwordText);
                    if(userEntity==null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"invalide!!",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else
                    {
                        String name=userEntity.name;
                        startActivity(new Intent(login.this,MainActivity3.class).putExtra("name",name));
                    }
                       }
                   }).start();
               }

            }
        });
    }
}