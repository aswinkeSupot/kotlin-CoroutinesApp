package com.remitap.coroutinesapp.deepDiveCoroutinesApp3

import android.os.Bundle
import android.util.Log
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
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DDCoroutineApp3 : AppCompatActivity() {
    lateinit var binding: ActivityDdcoroutineApp3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ddcoroutine_app3)

        // Example for Concurent/Sequential Coroutine
        binding.btnSequential.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.v("TAGGY","CoroutineSequential Starting")
                val one = doSomeThingUsefulOne()
                Log.v("TAGGY","Coroutine 1 Finished")
                val two = doSomeThingUsefulTwo()
                Log.v("TAGGY","Coroutine 2 Finished")

                val result =one + two
                Log.v("TAGGY", "The Result is $result")
            }
        }

        // Example for Parallel Coroutine
        binding.btnParallel.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                Log.v("TAGGY","CoroutineParallel Starting")
                val one = async { doSomeThingUsefulOne() }
                Log.v("TAGGY","CoroutineParallel 1 Finished")
                val two = async { doSomeThingUsefulTwo() }
                Log.v("TAGGY","CoroutineParallel 2 Finished")

                val result =one.await() + two.await()
                Log.v("TAGGY", "The Result is $result")
            }
        }

    }

    suspend fun doSomeThingUsefulOne(): Int {
        delay(1000L)
        Log.v("TAGGY", "Starting Coroutine 1")
        return 5
    }

    suspend fun doSomeThingUsefulTwo(): Int {
        delay(3000L)
        Log.v("TAGGY", "Starting Coroutine 2")
        return 10
    }

}