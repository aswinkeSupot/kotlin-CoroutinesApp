package com.remitap.coroutinesapp.coroutineApp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityCoroutinesBaseBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CoroutinesBase : AppCompatActivity() {

    lateinit var binding: ActivityCoroutinesBaseBinding

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutines_base)

        binding.countBtn.setOnClickListener{
            binding.counterText.text = counter++.toString()
        }

        binding.downloadBtn.setOnClickListener{
            //Coroutines Scope
//            CoroutineScope(Dispatchers.IO).launch {
//                downloadBigFileFromNet()
//            }

            /**There are three types of scope**/
            //1. Global Scope (Maximum lifetime of the coroutine is equal to the lifetime of the application)
            GlobalScope.launch {
                downloadBigFileFromNet()
            }

            //2. Lifecycle Scope (The coroutine lifetime will follow the lifecycle owner lifetime

            //3. ViewModel Scope (The only difference is that the coroutine in this scoop will live as long as the ViewModel is alive.)

        }
    }

    private fun downloadBigFileFromNet() {
        for(i in 1..100000){
            Log.i("TAGGY", "Downloading $i in ${Thread.currentThread().name}")
        }
    }

}