package org.iesch.repasoexamenjunio.model.pizzas

data class Pizza (
    val id: Long,
    val name: String,
    val price: Double,
    val image: String,
    val category: String
)
