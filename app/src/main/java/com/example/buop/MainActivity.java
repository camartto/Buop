package com.example.buop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    EditText txtUsuario;
    EditText txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_bd);
        txtUsuario= (EditText) findViewById(R.id.txvUsuario);
        txtPass= (EditText) findViewById(R.id.txvPassword);
    }

    private void addUser(String idBD,String user, String pass){

        mDatabase.child("Usuarios").child(idBD).child("Nombre").setValue(user);
        mDatabase.child("Usuarios").child(idBD).child("Contraseña").setValue(pass);
    }

    public void EnviarABD(View view) {
        addUser("45943285", txtUsuario.getText().toString(),txtPass.getText().toString());
    }
}
