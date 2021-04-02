package org.chingari.downloadofflinehls

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.MediaMetadata
import com.google.android.exoplayer2.offline.DownloadService
import com.google.android.exoplayer2.util.MimeTypes
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.chingari.downloadofflinehls.common.MediaItemTag
import org.chingari.downloadofflinehls.common.MyDownloadService
import org.chingari.downloadofflinehls.offlineVideo.OfflineVideoActivity

class MainActivity : AppCompatActivity() {

    private val listMediaItem: List<MediaItem> = listOf(
        MediaItem.Builder()
            .setUri("https://bitmovin-a.akamaihd.net/content/MI201109210084_1/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8")
            .setMimeType(MimeTypes.APPLICATION_M3U8)
            .setMediaMetadata(MediaMetadata.Builder().setTitle("General Statistics").build())
            .build(),
        MediaItem.Builder()
            .setUri("https://devstreaming-cdn.apple.com/videos/wwdc/2020/10225/1/071CF9A2-F9B9-48A1-8D81-012721D0A52C/avc_540p_2000/prog_index.m3u8")
            .setMimeType(MimeTypes.APPLICATION_M3U8)
            .setMediaMetadata(MediaMetadata.Builder().setTitle("Tears of Steel").build())
            .build(),
        MediaItem.Builder()
            .setUri("https://devstreaming-cdn.apple.com/videos/wwdc/2016/504m956dgg4hlw2uez9/504/0480/0480.m3u8")
            .setMimeType(MimeTypes.APPLICATION_M3U8)
            .setMediaMetadata(MediaMetadata.Builder().setTitle("Tears of Steel").build())
            .build(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Can be moved to Application class
       /* try {
            DownloadService.start(this, MyDownloadService::class.java)
        } catch (e: IllegalStateException) {
            DownloadService.startForeground(this, MyDownloadService::class.java)
        }*/

        val onlineAdapter = OnlineAdapter()
        findViewById<RecyclerView>(R.id.rv_online_video).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = onlineAdapter
        }

        onlineAdapter.submitList(listMediaItem)

        findViewById<FloatingActionButton>(R.id.fab_my_downloads).setOnClickListener {
            startActivity(Intent(this, OfflineVideoActivity::class.java))
        }
    }

}
