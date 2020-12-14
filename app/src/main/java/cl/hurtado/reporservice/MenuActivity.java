package cl.hurtado.reporservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void IrRegistro (View view){

        Intent siguiente = new Intent(this,RegistroActivity.class);
        startActivity(siguiente);

    }

    public void IrVer (View view){

        Intent siguiente = new Intent(this,VerActivity.class);
        startActivity(siguiente);

    }

    public void Salir (View view){

        Intent siguiente = new Intent(this,MainActivity.class);
        startActivity(siguiente);

    }
}