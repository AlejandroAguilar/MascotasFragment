package com.alexaguilar.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;


public class ContactoActivity extends AppCompatActivity {

    private Button buttonEnviar;
    private EditText TextMail;
    private EditText TextAsunto;
    private EditText TextMensaje;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        //agrega la toolbar
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        //agrega la flecha hacia atras.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.huella);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }

    /*
    public void fabClicked(View v){
        Toast.makeText(this, "Subir", Toast.LENGTH_SHORT).show();
    }
    */

    private void sendEmail(View v) {

        Toast.makeText(this, "Email!", Toast.LENGTH_SHORT).show();

        //Getting content for email
        String email = TextMail.getText().toString().trim();
        String subject = TextAsunto.getText().toString().trim();
        String message = TextMensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}
