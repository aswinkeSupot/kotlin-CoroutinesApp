package com.remitap.coroutinesapp.coroutineSeqApp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityCoroutineSeqentialBinding
import com.remitap.coroutinesapp.databinding.ActivitySwitchingCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineSeqential : AppCompatActivity() {
    lateinit var binding: ActivityCoroutineSeqentialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_seqential)

        CoroutineScope(Dispatchers.IO).launch {
            val one = doSomeThingUseFull1()
            val two = doSomeThingUseFull2()

            val result = one + two
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