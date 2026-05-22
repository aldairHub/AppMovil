package com.edu.uteq;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mostrarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_datos);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvTitulo).getRootView(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvResCedula = findViewById(R.id.tvResCedula);
        TextView tvResNombres = findViewById(R.id.tvResNombres);
        TextView tvResFecha = findViewById(R.id.tvResFecha);
        TextView tvResCiudad = findViewById(R.id.tvResCiudad);
        TextView tvResCorreo = findViewById(R.id.tvResCorreo);
        TextView tvResTelefono = findViewById(R.id.tvResTelefono);
        TextView tvResGenero = findViewById(R.id.tvResGenero);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String cedula = extras.getString("KEY_CEDULA", "");
            String nombres = extras.getString("KEY_NOMBRES", "");
            String fecha = extras.getString("KEY_FECHA", "");
            String ciudad = extras.getString("KEY_CIUDAD", "");
            String correo = extras.getString("KEY_CORREO", "");
            String telefono = extras.getString("KEY_TELEFONO", "");
            String genero = extras.getString("KEY_GENERO", "");

            tvResCedula.setText("Cédula: " + cedula);
            tvResNombres.setText("Nombres: " + nombres);
            tvResFecha.setText("Fecha de nacimiento: " + fecha);
            tvResCiudad.setText("Ciudad: " + ciudad);
            tvResCorreo.setText("Correo electrónico: " + correo);
            tvResTelefono.setText("Teléfono móvil: " + telefono);
            tvResGenero.setText("Género: " + genero);
        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}