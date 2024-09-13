package hr.algebra.heroapp.api

import android.content.ContentValues
import android.content.Context
import android.util.Log
import hr.algebra.heroapp.NASA_PROVIDER_CONTENT_URI
import hr.algebra.heroapp.HeroReceiver
import hr.algebra.heroapp.api.apimodel.HeroItem
import hr.algebra.heroapp.framework.sendBroadcast
import hr.algebra.heroapp.handler.downloadAndStore
import hr.algebra.heroapp.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroFetcher(private val context: Context) {

    private val heroApi: HeroApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        heroApi = retrofit.create(HeroApi::class.java)
    }

    fun fetchItems(count: Int) {

        val request = heroApi.fetchItems()

        request.enqueue(object: Callback<List<HeroItem>> {
            override fun onResponse(
                call: Call<List<HeroItem>>,
                response: Response<List<HeroItem>>
            ) {
                response.body()?.let { populateItems(it, count) }
            }

            override fun onFailure(call: Call<List<HeroItem>>, t: Throwable) {
                Log.e(javaClass.name, t.toString(), t)
            }

        })
    }

    private fun populateItems(heroItems: List<HeroItem>, count: Int) {
        //val items = mutableListOf<Item>()
        // FOREGROUND - do not go to internet!!!
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            //BACKGROUND
            heroItems.take(count).forEach {
                val picturePath = downloadAndStore(context, it.images.lg)
                val race = it.appearance.race ?: "Unknown"

                val values = ContentValues().apply {
                    put(Item::name.name, it.name)
                    put(Item::intelligence.name, it.powerstats.intelligence)
                    put(Item::strength.name, it.powerstats.strength)
                    put(Item::speed.name, it.powerstats.speed)
                    put(Item::durability.name, it.powerstats.durability)
                    put(Item::power.name, it.powerstats.power)
                    put(Item::combat.name, it.powerstats.combat)
                    put(Item::gender.name, it.appearance.gender)
                    put(Item::race.name, race)
                    put(Item::picturePath.name, picturePath?:"")
                    put(Item::read.name, false)
                }

                context.contentResolver.insert(NASA_PROVIDER_CONTENT_URI, values)

                /*
                items.add(
                    Item(
                        null,
                        it.name ?: "Unknown",  // Default name if it's null
                        it.powerstats.intelligence ?: 0,  // Default 0 for stats if null
                        it.powerstats.strength ?: 0,
                        it.powerstats.speed ?: 0,
                        it.powerstats.durability ?: 0,
                        it.powerstats.power ?: 0,
                        it.powerstats.combat ?: 0,
                        it.appearance.gender ?: "Unknown",  // Default gender if null
                        race = race,    // Default race if null
                        picturePath ?: "",                  // Default empty path if download fails
                        false
                    )
                )*/
            }
            //println(items)
            context.sendBroadcast<HeroReceiver>()
        }
    }
}