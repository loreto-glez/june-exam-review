package org.iesch.repasoexamenjunio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import org.iesch.repasoexamenjunio.adapter.AndroidVersionAdapter
import org.iesch.repasoexamenjunio.databinding.ActivityMainBinding
import org.iesch.repasoexamenjunio.provider.AndroidVersionProvider
import org.iesch.repasoexamenjunio.ui.theme.RepasoExamenJunioTheme

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: AndroidVersionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initRecyclerView()

    }

    private fun initRecyclerView() {
        // Obtenemos la lista de versiones android
        val versionesAndroid = AndroidVersionProvider.androidVersionsList

        // configuro el adaptador
        adapter = AndroidVersionAdapter(versionesAndroid)

        // Configurar RecyclerView usando binding
        binding.rvVersionesAndroid.layoutManager = LinearLayoutManager(this)
        binding.rvVersionesAndroid.adapter = adapter
    }
}