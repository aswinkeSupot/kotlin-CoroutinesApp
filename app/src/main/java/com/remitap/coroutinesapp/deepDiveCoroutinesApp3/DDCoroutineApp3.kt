package com.remitap.coroutinesapp.deepDiveCoroutinesApp3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityDdcoroutineApp2Binding
import com.remitap.coroutinesapp.databinding.ActivityDdcoroutineApp3Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DDCoroutineApp3 : AppCompatActivity() {
    lateinit var binding: ActivityDdcoroutineApp3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ddcoroutine_app3)

        binding.btnCount.setOnClickListener {

        }

        binding.btnDownload.setOnClickListener {


        }

    }

    suspend fun doSomeThingUsefulOne(): Int {
        delay(1000L)
        return 5
    }

    suspend fun doSomeThingUsefulTwo(): Int {
        delay(3000L)
        return 10
    }

    private suspend fun downloadBigFileFromNet() {
        for (i in 1..1000000) {
            withContext(Dispatchers.Main){
                binding.tvDownloadBigFile.text = "$i"
            }

        }
    }
}