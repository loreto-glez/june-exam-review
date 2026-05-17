package org.iesch.repasoexamenjunio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.repasoexamenjunio.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAndroidVersions.setOnClickListener {
            goToAndroidVersions()
        }
        binding.btnApiPizzas.setOnClickListener {
            goToApiPizzas()
        }
        binding.btnEmpleados.setOnClickListener {
            goToEmpleados()
        }
    }
    private fun goToAndroidVersions() {
        startActivity(Intent(this, AndroidVersionActivity::class.java))
    }
    private fun goToApiPizzas() {
        startActivity(Intent(this, ApiPizzasActivity::class.java))
    }
    private fun goToEmpleados() {
        startActivity(Intent(this, EmpleadosActivity::class.java))
    }
}




