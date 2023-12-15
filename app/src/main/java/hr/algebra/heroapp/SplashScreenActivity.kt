package hr.algebra.heroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import hr.algebra.heroapp.api.HeroWorker
import hr.algebra.heroapp.databinding.ActivitySplashScreenBinding
import hr.algebra.heroapp.framework.applyAnimation
import hr.algebra.heroapp.framework.callDelayed
import hr.algebra.heroapp.framework.getBooleanPreference
import hr.algebra.heroapp.framework.isOnline
import hr.algebra.heroapp.framework.startActivity

private const val DELAY = 3000L
const val DATA_IMPORTED = "hr.algebra.heroapp.data_imported"

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        startAnimations()
        redirect()
    }

    private fun startAnimations() {
        binding.ivSplash.applyAnimation(R.anim.rotate)
        binding.tvSplash.applyAnimation(R.anim.blink)
    }

    private fun redirect() {

        //if data is imported then cross over to the HostActivity
        if(getBooleanPreference(DATA_IMPORTED)) {
            callDelayed(DELAY) {
                startActivity<HostActivity>()
            }
        } else {
            // if I am online
            if(isOnline()) {

                WorkManager.getInstance(this).apply {
                    enqueueUniqueWork(
                        DATA_IMPORTED,
                        ExistingWorkPolicy.KEEP,
                        OneTimeWorkRequest.from(HeroWorker::class.java)
                    )
                }
            } else {
                binding.tvSplash.text = getString(R.string.no_internet)
                callDelayed(DELAY) {
                    finish()
                }
            }
        }
    }
}