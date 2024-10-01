package com.remitap.coroutinesapp.deepDiveCoroutinesFirst

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityCoroutineFirstAppBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

        // Creating our first Coroutine
        /** Dispatchers  1.Main, 2.Default, 3.IO **/

        val main_scope = CoroutineScope(Dispatchers.Main)
        val background_scope = CoroutineScope(Dispatchers.IO)

        //Running Main Scope Coroutine
        val job1 = main_scope.launch {
            Log.v("TAGGY","using the $coroutineContext")

            // Switching to IO Dispatcher Temporarily:
            withContext(Dispatchers.IO){
                Log.v("TAGGY","using the $coroutineContext")
                Log.v("TAGGY","The IO Thread")
                delay(3000)
            }

            // Switchng to Main Dispatcher
            Log.v("TAGGY","using the $coroutineContext")
        }

        // Canceling the coroutine
//        job1.cancel()


//        background_scope.launch {
//            downloadBigFileFromNet()
//        }

    }

    private fun downloadBigFileFromNet() {
        for (i in 1..1000000) {
            Log.i("TAGGY", "Downloading $i")
        }
    }
}