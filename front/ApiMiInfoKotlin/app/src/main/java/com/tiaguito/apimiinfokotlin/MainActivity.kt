package com.tiaguito.apimiinfokotlin


import android.os.Bundle

import androidx.activity.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var txtNombre: TextView
    private lateinit var txtApellido: TextView
    private lateinit var txtDocumetno: TextView
    private lateinit var txtEdad: TextView
    private lateinit var txtFechaN: TextView

    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtNombre = findViewById(R.id.txtNombre)
        txtApellido = findViewById(R.id.txtApellido)
        txtDocumetno = findViewById(R.id.txtDocumento)
        txtEdad = findViewById(R.id.txtEdad)
        txtFechaN = findViewById(R.id.txtFechaN)

        imageView = findViewById(R.id.imageView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://6867-181-58-39-209.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(MiApiService::class.java)
        val call = apiService.getUsuario()

        call.enqueue(object : Callback<MiApiResponse> {
            override fun onResponse(call: Call<MiApiResponse>, response: Response<MiApiResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val u = response.body()!!
                    txtNombre.text = u.nombres
                    txtApellido.text = u.apellidos
                    txtDocumetno.text = u.documento
                    txtEdad.text = u.edad
                    txtFechaN.text = u.fechaN
                    Picasso.get().load(u.imagen).into(imageView)
                }
            }

            override fun onFailure(call: Call<MiApiResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}