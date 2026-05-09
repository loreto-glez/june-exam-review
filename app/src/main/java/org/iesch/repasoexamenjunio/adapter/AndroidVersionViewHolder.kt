package org.iesch.repasoexamenjunio.adapter

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.iesch.repasoexamenjunio.databinding.ItemAndroidVersionBinding
import org.iesch.repasoexamenjunio.model.AndroidVersion

class AndroidVersionViewHolder( val binding: ItemAndroidVersionBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render( androidVersion: AndroidVersion) {
        // Asignar los datos a las vistas usando binding
        binding.tvNombreVersion.text = androidVersion.nombre
        binding.tvCodigoNombre.text = androidVersion.codigo
        binding.tvDetalles.text = "API ${androidVersion.apiLevel} - ${androidVersion.anioLanzamiento}"

        // Añadimos el click
        itemView.setOnClickListener {
            Toast.makeText(itemView.context, androidVersion.nombre, Toast.LENGTH_LONG).show()
        }
    }

}