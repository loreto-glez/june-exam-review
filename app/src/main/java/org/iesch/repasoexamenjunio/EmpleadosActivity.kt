package org.iesch.repasoexamenjunio

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import org.iesch.repasoexamenjunio.adapter.firestore.EmpleadoAdapter
import org.iesch.repasoexamenjunio.databinding.ActivityEmpleadosBinding
import org.iesch.repasoexamenjunio.model.firestore.Empleado

class EmpleadosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmpleadosBinding
    private lateinit var adapter: EmpleadoAdapter
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmpleadosBinding.inflate(layoutInflater)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        initRecyclerView()
        fetchEmpleados()
    }

    private fun initRecyclerView() {
        adapter = EmpleadoAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
    private fun fetchEmpleados() {
        binding.progressBar.visibility = View.VISIBLE
        db.collection("empleados")
            .get()
            .addOnSuccessListener { result ->
                val empleados = result.toObjects(Empleado::class.java)
                adapter.updateData(empleados)
                binding.progressBar.visibility = View.GONE
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                binding.progressBar.visibility = View.GONE
            }
    }
}
