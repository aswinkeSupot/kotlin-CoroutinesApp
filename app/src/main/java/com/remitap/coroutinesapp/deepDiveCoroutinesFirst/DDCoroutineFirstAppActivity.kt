package com.remitap.coroutinesapp.deepDiveCoroutinesFirst

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityCoroutineFirstAppBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DDCoroutineFirstAppActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoroutineFirstAppBinding
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_first_app)

        binding.btnDownloadBigfile.setOnClickListener {
            counter++
            binding.tvHint.text = counter.toString()
        }

        // Creating our First Coroutine
        CoroutineScope(Dispatchers.IO).launch {
            downloadBigFileFromNet()
        }



    }

    private fun downloadBigFileFromNet() {
        for (i in 1..1000000) {
            Log.i("TAGGY", "Downloading $i")
        }
    }
}