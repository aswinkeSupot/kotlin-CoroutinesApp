package com.remitap.coroutinesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.SwitchingCoroutineApp.SwitchingCoroutine
import com.remitap.coroutinesapp.coroutineApp.CoroutinesBase
import com.remitap.coroutinesapp.coroutineApp2.CoroutineApp2
import com.remitap.coroutinesapp.coroutineParallelApp.CoroutineParallelApp
import com.remitap.coroutinesapp.coroutineSeqApp.CoroutineSeqential
import com.remitap.coroutinesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.BtnCoroutineAppBase.setOnClickListener {
            var intent: Intent = Intent(this, CoroutinesBase::class.java)
            startActivity(intent)
        }

        binding.BtnCoroutineApp2.setOnClickListener {
            var intent: Intent = Intent(this, CoroutineApp2::class.java)
            startActivity(intent)
        }

        binding.BtnSwitchCoroutine.setOnClickListener {
            var intent: Intent = Intent(this, SwitchingCoroutine::class.java)
            startActivity(intent)
        }

        binding.BtnSequentialCoroutine.setOnClickListener {
            var intent: Intent = Intent(this, CoroutineSeqential::class.java)
            startActivity(intent)
        }

        binding.BtnParallelCoroutine.setOnClickListener {
            var intent: Intent = Intent(this, CoroutineParallelApp::class.java)
            startActivity(intent)
        }
    }

}

/**
 * 1. Add Coroutines dependency in app level build.gradle.kts
 * Reference URL - https://developer.android.com/kotlin/coroutines
 * dependencies {
 *     implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
 * }
 *
 * **/