package com.remitap.coroutinesapp.coroutineParallelApp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityCoroutineParallelAppBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineParallelApp : AppCompatActivity() {
    lateinit var binding: ActivityCoroutineParallelAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_parallel_app)

        CoroutineScope(Dispatchers.IO).launch {
            Log.v("TAGGY", "The App Started")

            val one = async {
                doSomeThingUseFull1()
            }
            val two = async {
                doSomeThingUseFull2()
            }

            val result = one.await() + two.await()
            Log.v("TAGGY", "The Result is: $result")
        }

    }

    suspend fun doSomeThingUseFull1() : Int {
        delay(5000)
        Log.v("TAGGY", "Fun1 is Done")
        return 11
    }
    suspend fun doSomeThingUseFull2() : Int {
        delay(7000)
        Log.v("TAGGY", "Fun2 is Done")
        return 8
    }
}