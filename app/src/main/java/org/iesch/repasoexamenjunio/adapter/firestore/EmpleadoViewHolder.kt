package org.iesch.repasoexamenjunio.adapter.firestore

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.iesch.repasoexamenjunio.databinding.ItemEmpleadoBinding
import org.iesch.repasoexamenjunio.model.firestore.Empleado

class EmpleadoViewHolder(val binding: ItemEmpleadoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun render(empleado: Empleado) {
        binding.tvNombre.text = empleado.nombre
        binding.tvSalario.text = empleado.salario.toString()
        binding.tvEdad.text = empleado.edad.toString()
        binding.tvActivo.text = if(empleado.activo) "Activo" else "Inactivo"
        binding.tvActivo.setTextColor(if(empleado.activo) Color.GREEN else Color.RED)
    }
}