package org.iesch.repasoexamenjunio.adapter.pizzas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.iesch.repasoexamenjunio.R
import org.iesch.repasoexamenjunio.model.pizzas.Pizza

class PizzaAdapter(private var items: List<Pizza>) :
    RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    inner class PizzaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPizza: ImageView = view.findViewById(R.id.ivPizza)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val tvCategory: TextView = view.findViewById(R.id.tvCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pizza, parent, false)
        return PizzaViewHolder(view)
    }


    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = items[position]
        holder.tvName.text = pizza.name
        holder.tvPrice.text = "${pizza.price}€"
        holder.tvCategory.text = pizza.category

        Glide.with(holder.itemView.context)
            .load(pizza.image)
            .into(holder.ivPizza)
    }

    override fun getItemCount() = items.size

    fun updateData(newItems: List<Pizza>) {
        items = newItems
        notifyDataSetChanged()
    }
}
