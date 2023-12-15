package hr.algebra.heroapp.api

import android.content.Context
import hr.algebra.heroapp.HeroReceiver
import hr.algebra.heroapp.framework.sendBroadcast

class HeroFetcher(private val context: Context) {
    fun fetchItems(count: Int) {
        Thread.sleep(6000)
        context.sendBroadcast<HeroReceiver>()
    }
}