package hr.algebra.heroapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import hr.algebra.heroapp.framework.setBooleanPreference
import hr.algebra.heroapp.framework.startActivity

class HeroReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        context.setBooleanPreference(DATA_IMPORTED)
        context.startActivity<HostActivity>()
    }
}