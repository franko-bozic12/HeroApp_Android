package hr.algebra.heroapp.api

import hr.algebra.heroapp.api.apimodel.HeroItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_URL = "https://akabab.github.io/superhero-api/api/"

interface HeroApi {

    @GET("all.json")
    fun fetchItems() : Call<List<HeroItem>>
}