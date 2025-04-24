package com.tiaguito.apimiinfo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
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
    private TextView txtNombre, txtApellido, txtDocumetno, txtEdad, txtFechaN;

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
        txtApellido = findViewById(R.id.txtApellido);
        txtDocumetno = findViewById(R.id.txtDocumento);
        txtEdad = findViewById(R.id.txtEdad);
        txtFechaN = findViewById(R.id.txtFechaN);

        imageView = findViewById(R.id.imageView);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://6867-181-58-39-209.ngrok-free.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MiApiService apiService = retrofit.create(MiApiService.class);

        Call<MiApiResponse> call = apiService.getUsuario();
        call.enqueue(new Callback<MiApiResponse>() {
            @Override
            public void onResponse(Call<MiApiResponse> call, Response<MiApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    MiApiResponse u = response.body();
                    txtNombre.setText(u.getNombres());
                    txtApellido.setText(u.getApellidos());
                    txtDocumetno.setText(u.getDocumento());
                    txtEdad.setText(u.getEdad());
                    txtFechaN.setText(u.getFechaN());
                    Picasso.get().load(u.getImagen()).into(imageView);

                }
            }

            @Override
            public void onFailure(Call<MiApiResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}