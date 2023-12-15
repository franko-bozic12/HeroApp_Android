package hr.algebra.heroapp.api

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class HeroWorker(private val context: Context, workerParameters: WorkerParameters)
    : Worker(context, workerParameters) {
    override fun doWork(): Result {
        HeroFetcher(context).fetchItems(10)
        return Result.success()
    }
}