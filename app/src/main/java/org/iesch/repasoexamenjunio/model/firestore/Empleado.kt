package org.iesch.repasoexamenjunio.model.firestore

data class Empleado (
    val nombre: String = "",
    val edad: Int = 0,
    val activo: Boolean = false,
    val salario: Double = 0.0
)