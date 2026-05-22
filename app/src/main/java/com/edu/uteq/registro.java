package com.edu.uteq;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Calendar;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputEditText etCedula = findViewById(R.id.etCedula);
        TextInputEditText etNombres = findViewById(R.id.etNombres);
        TextInputEditText etFecha = findViewById(R.id.etFecha);
        TextInputEditText etCiudad = findViewById(R.id.etCiudad);
        TextInputEditText etCorreo = findViewById(R.id.etCorreo);
        TextInputEditText etTelefono = findViewById(R.id.etTelefono);
        RadioGroup rgGenero = findViewById(R.id.rgGenero);
        Button btnLimpiar = findViewById(R.id.btnLimpiar);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendario = Calendar.getInstance();
                int anio = calendario.get(Calendar.YEAR);
                int mes = calendario.get(Calendar.MONTH);
                int dia = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(registro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        etFecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, anio, mes, dia);

                datePicker.show();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCedula.getText() != null) etCedula.getText().clear();
                if (etNombres.getText() != null) etNombres.getText().clear();
                if (etFecha.getText() != null) etFecha.getText().clear();
                if (etCiudad.getText() != null) etCiudad.getText().clear();
                if (etCorreo.getText() != null) etCorreo.getText().clear();
                if (etTelefono.getText() != null) etTelefono.getText().clear();
                rgGenero.clearCheck();
                Toast.makeText(registro.this, "Formulario limpio", Toast.LENGTH_SHORT).show();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cedula = etCedula.getText().toString().trim();
                String nombres = etNombres.getText().toString().trim().toUpperCase();

                String fecha = etFecha.getText().toString().trim();

                String ciudad = etCiudad.getText().toString().trim().toUpperCase();
                String correo = etCorreo.getText().toString().trim();
                String telefono = etTelefono.getText().toString().trim();

                int idSeleccionado = rgGenero.getCheckedRadioButtonId();
                String genero = "";
                if (idSeleccionado != -1) {
                    RadioButton rbSeleccionado = findViewById(idSeleccionado);
                    genero = rbSeleccionado.getText().toString();
                }

                if (cedula.isEmpty() || nombres.isEmpty() || fecha.isEmpty() ||
                        ciudad.isEmpty() || correo.isEmpty() || telefono.isEmpty() || genero.isEmpty()) {
                    Toast.makeText(registro.this, "Por favor, llene todos los campos", Toast.LENGTH_LONG).show();
                    return;
                }

                if (cedula.length() != 10) {
                    etCedula.setError("La cédula debe tener exactamente 10 dígitos");
                    etCedula.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                    etCorreo.setError("Correo electrónico inválido");
                    etCorreo.requestFocus();
                    return;
                }

                Intent intent = new Intent(registro.this, mostrarDatos.class);
                intent.putExtra("KEY_CEDULA", cedula);
                intent.putExtra("KEY_NOMBRES", nombres);
                intent.putExtra("KEY_FECHA", fecha);
                intent.putExtra("KEY_CIUDAD", ciudad);
                intent.putExtra("KEY_CORREO", correo);
                intent.putExtra("KEY_TELEFONO", telefono);
                intent.putExtra("KEY_GENERO", genero);
                startActivity(intent);
            }
        });
    }
}