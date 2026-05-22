package com.edu.uteq;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.textfield.TextInputEditText;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputEditText etCorreoLogin = findViewById(R.id.etCorreoLogin);
        TextInputEditText etPasswordLogin = findViewById(R.id.etPasswordLogin);
        Button btnEntrar = findViewById(R.id.button);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = etCorreoLogin.getText().toString().trim();
                String password = etPasswordLogin.getText().toString().trim();

                if (correo.isEmpty()) {
                    etCorreoLogin.setError("El correo no puede estar vacío");
                    etCorreoLogin.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    etPasswordLogin.setError("La contraseña no puede estar vacía");
                    etPasswordLogin.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                    etCorreoLogin.setError("Escriba un correo electrónico válido (ejemplo@dominio.com)");
                    etCorreoLogin.requestFocus();
                    return;
                }

                Toast.makeText(login.this, "Acceso concedido", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login.this, registro.class);
                startActivity(intent);
            }
        });
    }
}