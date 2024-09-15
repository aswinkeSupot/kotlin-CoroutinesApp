package com.remitap.coroutinesapp.SwitchingCoroutineApp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityCoroutinesBaseBinding
import com.remitap.coroutinesapp.databinding.ActivitySwitchingCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SwitchingCoroutine : AppCompatActivity() {
    lateinit var binding: ActivitySwitchingCoroutineBinding

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_switching_coroutine)

        binding.countBtn.setOnClickListener{
            binding.counterText.text = counter++.toString()
        }

        binding.downloadBtn.setOnClickListener{
            //Coroutines Scope
            CoroutineScope(Dispatchers.IO).launch {
                downloadBigFileFromNet()
            }

            /**There are three types of scope**/
            //1. Global Scope (Maximum lifetime of the coroutine is equal to the lifetime of the application)
//            GlobalScope.launch {
//                downloadBigFileFromNet()
//            }

            //2. Lifecycle Scope (The coroutine lifetime will follow the lifecycle owner lifetime

            //3. ViewModel Scope (The only difference is that the coroutine in this scoop will live as long as the ViewModel is alive.)

        }
    }

    private suspend fun downloadBigFileFromNet() {
        for(i in 1..100000){
            //Getting Error : Only the original thread that created a view hierarchy can touch its views. Expected: main Calling: DefaultDispatcher-worker-1

            withContext(Dispatchers.Main){
                binding.downloadTextProgress.text = "$i in ${Thread.currentThread().name}"
            }



        }
    }
}