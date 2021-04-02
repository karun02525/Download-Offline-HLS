package org.chingari.downloadofflinehls

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.exoplayer2.offline.DownloadService
import org.chingari.downloadofflinehls.common.MyDownloadService

class DownloadVideoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        try {
            DownloadService.start(this, MyDownloadService::class.java)
        } catch (e: IllegalStateException) {
            DownloadService.startForeground(this, MyDownloadService::class.java)
        }
    }
}
