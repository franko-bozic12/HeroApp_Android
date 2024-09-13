package hr.algebra.heroapp.framework

import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.content.getSystemService
import androidx.preference.PreferenceManager
import hr.algebra.heroapp.NASA_PROVIDER_CONTENT_URI
import hr.algebra.heroapp.model.Item

fun View.applyAnimation(animationId: Int) =
    startAnimation(AnimationUtils.loadAnimation(context, animationId))


inline fun <reified T : Activity> Context.startActivity() =
    startActivity(Intent(this, T::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    })

inline fun <reified T : BroadcastReceiver> Context.sendBroadcast() =
    sendBroadcast(Intent(this, T::class.java))

fun Context.setBooleanPreference(key: String, value: Boolean = true) {
    PreferenceManager.getDefaultSharedPreferences(this)
        .edit()
        .putBoolean(key, value)
        .apply()
}

fun Context.getBooleanPreference(key: String) =
    PreferenceManager.getDefaultSharedPreferences(this)
        .getBoolean(key, false)

fun Context.isOnline() : Boolean {
    val connectivityManager = getSystemService<ConnectivityManager>()
    connectivityManager?.activeNetwork?.let { network ->
        connectivityManager.getNetworkCapabilities(network)?.let { capabilities ->
            return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        }
    }

    return false
}

fun callDelayed(delay: Long, work: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(
        work,
        delay
    )
}

@SuppressLint("Range")
fun Context.fetchItems() : MutableList<Item> {
    val items = mutableListOf<Item>()

    val cursor = contentResolver.query(
        NASA_PROVIDER_CONTENT_URI, null, null, null, null
    )
    while (cursor != null && cursor.moveToNext()){
        items.add(Item(
            cursor.getLong(cursor.getColumnIndexOrThrow(Item::_id.name)),
            cursor.getString(cursor.getColumnIndexOrThrow(Item::name.name)),
            cursor.getLong(cursor.getColumnIndexOrThrow(Item::intelligence.name)),
            cursor.getLong(cursor.getColumnIndexOrThrow(Item::strength.name)),
            cursor.getLong(cursor.getColumnIndexOrThrow(Item::speed.name)),
            cursor.getLong(cursor.getColumnIndexOrThrow(Item::durability.name)),
            cursor.getLong(cursor.getColumnIndexOrThrow(Item::power.name)),
            cursor.getLong(cursor.getColumnIndexOrThrow(Item::combat.name)),
            cursor.getString(cursor.getColumnIndexOrThrow(Item::gender.name)),
            cursor.getString(cursor.getColumnIndexOrThrow(Item::race.name)),
            cursor.getString(cursor.getColumnIndexOrThrow(Item::picturePath.name)),
            cursor.getInt(cursor.getColumnIndexOrThrow(Item::read.name))==1
        ))
    }

    return items
}