package cl.hurtado.reporservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VerActivity extends AppCompatActivity {
    private EditText Ev_Codigo;
    private TextView Tv_Nombre, Tv_Cliente, Tv_Fecha, Tv_Servicio, Tv_Observacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        Ev_Codigo = (EditText) findViewById(R.id.editTextVerCod);
        Tv_Nombre = (TextView) findViewById(R.id.textViewNombre);
        Tv_Cliente = (TextView) findViewById(R.id.textViewCliente);
        Tv_Fecha = (TextView) findViewById(R.id.textViewFecha);
        Tv_Servicio = (TextView) findViewById(R.id.textViewServicio);
        Tv_Observacion = (TextView) findViewById(R.id.textViewObservacion);

    }

    public void Consultar (View view){
        AdminBD consul = new AdminBD(this, "reporBaseDato", null, 1);
        SQLiteDatabase reporBaseDato = consul.getWritableDatabase();

        String CODIGO = Ev_Codigo.getText().toString();

        if (!CODIGO.isEmpty()){
            Cursor fila = reporBaseDato.rawQuery("SELECT nombre,cliente,fecha,servicio,observacion FROM registro WHERE codigo = ? ", new String[]{CODIGO});

            if (fila.moveToFirst()){
                Tv_Nombre.setText(fila.getString(0));
                Tv_Cliente.setText(fila.getString(1));
                Tv_Fecha.setText(fila.getString(2));
                Tv_Servicio.setText(fila.getString(3));
                Tv_Observacion.setText(fila.getString(4));
            }else {
                Toast.makeText(this, "Codigo no encontrado", Toast.LENGTH_LONG).show();
            }
            reporBaseDato.close();
        }else {
            Toast.makeText(this, "Ingrese codigo a consultar", Toast.LENGTH_LONG).show();
        }

    }

    public void SiguienteVer (View view){

        Intent siguiente = new Intent(this,MenuActivity.class);
        startActivity(siguiente);

    }
}