package tn.esprit.authentification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText userName,email,password;
Button register,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName=findViewById(R.id.userName);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v){
                //Creation d'entité
                UserEntity userEntity=new UserEntity();
                userEntity.setName(userName.getText().toString());
                userEntity.setEmail(email.getText().toString());
                userEntity.setPassword(password.getText().toString());
                if (valideInput(userEntity)) {
                    //Operation insertion
                UserDatabase userDatabase=UserDatabase.getUserDatabase(getApplicationContext());
               final UserDao userDao=userDatabase.userDao();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        userDao.registerUser(userEntity);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"user enregistré",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,login.class));

                            }
                        });
                    }
                }).start();
                }
                else{
                    Toast.makeText(getApplicationContext(),"veuillez renseigner les champs!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,login.class));
            }
        });
    }

    private boolean valideInput(UserEntity userEntity)
    {
        if(userEntity.getEmail().isEmpty()||userEntity.getPassword().isEmpty()||userEntity.getName().isEmpty())
        {return false;}
        return true;
    }
}