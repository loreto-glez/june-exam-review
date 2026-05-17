package org.iesch.repasoexamenjunio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.iesch.repasoexamenjunio.adapter.AndroidVersionAdapter
import org.iesch.repasoexamenjunio.databinding.ActivityAndroidVersionBinding
import org.iesch.repasoexamenjunio.provider.AndroidVersionProvider

class AndroidVersionActivity : ComponentActivity() {
    private lateinit var binding: ActivityAndroidVersionBinding

    private lateinit var adapter: AndroidVersionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidVersionBinding.inflate(layoutInflater)
        setContentView(binding.root)
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