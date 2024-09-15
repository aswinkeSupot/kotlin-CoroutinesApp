package com.remitap.coroutinesapp.coroutineApp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.R
import com.remitap.coroutinesapp.databinding.ActivityCoroutineApp2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoroutineApp2 : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineApp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_app2)

        SayHelloFromMainThread()
        SayHelloFromBackThread()
    }

    private fun SayHelloFromBackThread() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.text1.text = "Hello From ${Thread.currentThread().name}"
        }
    }

    private fun SayHelloFromMainThread() {
        CoroutineScope(Dispatchers.IO).launch {
            binding.text2.text = "Hello From ${Thread.currentThread().name}"
        }
    }

}