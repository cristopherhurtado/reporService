package cl.hurtado.reporservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    private EditText E_Codigo, E_Nombre, E_Cliente, E_Fecha, E_Servicio, E_Observacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        E_Codigo = (EditText) findViewById(R.id.editTextCodigo);
        E_Nombre = (EditText) findViewById(R.id.editTextNombre);
        E_Cliente = (EditText) findViewById(R.id.editTextCliente);
        E_Fecha = (EditText) findViewById(R.id.editTextFecha);
        E_Servicio = (EditText) findViewById(R.id.editTextServicio);
        E_Observacion = (EditText) findViewById(R.id.editTextObservacion);
    }

    public void Registrar (View view){
        AdminBD regis = new AdminBD(this, "reporBaseDato", null,1);
        SQLiteDatabase reporBaseDato = regis.getWritableDatabase();

        String Codigo = E_Codigo.getText().toString();
        String Nombre = E_Nombre.getText().toString();
        String Cliente = E_Cliente.getText().toString();
        String Fecha = E_Fecha.getText().toString();
        String Servicio = E_Servicio.getText().toString();
        String Observacion = E_Observacion.getText().toString();

        if (!Codigo.isEmpty() && !Nombre.isEmpty() && !Cliente.isEmpty() && !Fecha.isEmpty() && !Servicio.isEmpty() && !Observacion.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("Codigo", Codigo);
            registro.put("Nombre", Nombre);
            registro.put("Cliente", Cliente);
            registro.put("Fecha", Fecha);
            registro.put("Servicio", Servicio);
            registro.put("Observacion", Observacion);


            if (reporBaseDato.insert("registro", null, registro) == -1){
                Toast.makeText(this, "No guardo datos", Toast.LENGTH_LONG).show();
            }else {

                reporBaseDato.close();

                E_Codigo.setText("");
                E_Nombre.setText("");
                E_Cliente.setText("");
                E_Fecha.setText("");
                E_Servicio.setText("");
                E_Observacion.setText("");
                Toast.makeText(this, "Los datos se estan almacenando", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this,"Debe ingresar correctamente los campos", Toast.LENGTH_LONG).show();
        }
    }

    public void SiguienteReg (View view){

        Intent siguiente = new Intent(this,MenuActivity.class);
        startActivity(siguiente);

    }


}