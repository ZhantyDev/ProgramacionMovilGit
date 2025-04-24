package com.tiaguito.miapi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView txtNombre, txtEstado, txtEspecie, txtTipo, txtGenero;
    private Button btnActu;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNombre = findViewById(R.id.txtNombre);
        txtEstado = findViewById(R.id.txtEstado);
        txtEspecie = findViewById(R.id.txtEspecie);
        txtTipo = findViewById(R.id.txtTipo);
        txtGenero = findViewById(R.id.txtGenero);

        btnActu = findViewById(R.id.btnActualizar);
        imageView = findViewById(R.id.imageView);

        btnActu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idAleatorio = generarIdAleatorio();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://rickandmortyapi.com/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RmApiService apiService = retrofit.create(RmApiService.class);

                Call<RmResponse> call = apiService.getResponse(idAleatorio);

                call.enqueue(new Callback<RmResponse>() {
                    @Override
                    public void onResponse(Call<RmResponse> call, Response<RmResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            RmResponse p = response.body();
                            txtNombre.setText(p.getName());
                            txtEstado.setText(p.getStatus());
                            txtEspecie.setText(p.getSpecies());
                            txtTipo.setText(p.getType());
                            txtGenero.setText(p.getGender());

                            Picasso.get().load(p.getImage()).into(imageView);
                        }
                    }

                    @Override
                    public void onFailure(Call<RmResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error al conectar con la API", Toast.LENGTH_SHORT).show();
                    }
                });

            }
            private int generarIdAleatorio() {
                return (int) (Math.random() * 826) + 1; // 1 a 826
            }
        });
    }
};