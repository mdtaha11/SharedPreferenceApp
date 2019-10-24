package com.example.mysharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText myemail;
    EditText mypwd;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myemail=(EditText)findViewById(R.id.myemail);
       mypwd=(EditText)findViewById(R.id.mypwd);

        Button display_btn=(Button)findViewById(R.id.display_btn);
        text =(TextView)findViewById(R.id.text);
    }
    public void saveInfo(View view)
    {
        SharedPreferences sharedPref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPref.edit();
        editor.putString("username", myemail.getText().toString());
        editor.putString("password",mypwd.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved",Toast.LENGTH_LONG).show();





    }

    public void display_Info(View view)

{
    SharedPreferences sharedPref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);

    String name=sharedPref.getString("username","");
    String pwd=sharedPref.getString("password","");
     text.setText(name+" "+pwd);

}



}
