package org.iesch.repasoexamenjunio.model.pizzas

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface PizzasApiService {
    @GET
    suspend fun getPizzas(@Url url: String) : List<Pizza>
}
