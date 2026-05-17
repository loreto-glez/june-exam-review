package org.iesch.repasoexamenjunio.adapter.firestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.iesch.repasoexamenjunio.databinding.ItemEmpleadoBinding
import org.iesch.repasoexamenjunio.model.firestore.Empleado

class EmpleadoAdapter(private var items: List<Empleado>) : RecyclerView.Adapter<EmpleadoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmpleadoViewHolder {
        val binding = ItemEmpleadoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmpleadoViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: EmpleadoViewHolder,
        position: Int
    ) {
        holder.render(items[position])

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateData(  nuevaLista: MutableList<Empleado> ){
        items = nuevaLista
        notifyDataSetChanged()
    }
}