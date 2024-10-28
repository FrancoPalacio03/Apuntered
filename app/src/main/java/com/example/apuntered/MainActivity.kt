package com.example.apuntered

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apuntered.databinding.ActivityMainBinding
import com.example.apuntered.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.logoutButton.setOnClickListener { // Usa el binding para acceder al botón
            // Aquí puedes limpiar la sesión del usuario si tienes algún token o datos guardados.
            // Por ejemplo: SharedPreferences o cualquier otro mecanismo que uses para la autenticación.
            // val sharedPreferences = getSharedPreferences("your_prefs", MODE_PRIVATE)
            // sharedPreferences.edit().clear().apply()

            // Iniciar la LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Cierra MainActivity para que el usuario no vuelva a ella al presionar atrás
        }
    }
}
