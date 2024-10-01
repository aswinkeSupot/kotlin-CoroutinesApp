package com.remitap.coroutinesapp.deepDiveCoroutinesApp2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityDdcoroutineApp2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DDCoroutineApp2 : AppCompatActivity() {
    lateinit var binding: ActivityDdcoroutineApp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_ddcoroutine_app2)

        var counter = 0

        binding.btnCount.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                counter++
                binding.tvCounter.text = counter.toString()
            }
        }

        binding.btnDownload.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadBigFileFromNet()
            }

        }

    }

    private suspend fun downloadBigFileFromNet() {
        for (i in 1..1000000) {
            withContext(Dispatchers.Main){
                binding.tvDownloadBigFile.text = "$i"
            }

        }
    }
}