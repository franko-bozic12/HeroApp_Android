package hr.algebra.heroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import hr.algebra.heroapp.databinding.ActivitySplashScreenBinding
import hr.algebra.heroapp.framework.applyAnimation
import hr.algebra.heroapp.framework.startActivity

private const val DELAY = 3000L

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
        Handler(Looper.getMainLooper()).postDelayed(
            {  startActivity<HostActivity>() },
            DELAY
        )
    }
}