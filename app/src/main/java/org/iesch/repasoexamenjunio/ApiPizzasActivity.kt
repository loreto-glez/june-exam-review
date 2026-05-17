package org.iesch.repasoexamenjunio

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import org.iesch.repasoexamenjunio.adapter.pizzas.PizzaAdapter
import org.iesch.repasoexamenjunio.databinding.ActivityApiPizzasBinding
import org.iesch.repasoexamenjunio.model.pizzas.PizzasApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiPizzasActivity : AppCompatActivity() {
    private lateinit var binding : ActivityApiPizzasBinding
    private lateinit var adapter: PizzaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiPizzasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        fetchPizzas()
    }

    private fun initRecyclerView() {
        adapter = PizzaAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
    private fun fetchPizzas() {
        binding.progressBar.visibility = View.VISIBLE
        lifecycleScope.launch {
            try {

                val api: PizzasApiService by lazy {
                    Retrofit.Builder()
                        .baseUrl("https://devsapihub.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(PizzasApiService::class.java)
                }
                val pizzas = api.getPizzas("api-fast-food/category/pizza/")
                adapter.updateData(pizzas)
            } catch (e: Exception) {
                Toast.makeText(this@ApiPizzasActivity, "Error: ${e.message}", Toast.LENGTH_LONG)
                    .show()
            } finally {
                binding.progressBar.visibility = View.GONE
            }
        }
    }

}