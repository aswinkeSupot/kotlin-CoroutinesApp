package com.remitap.coroutinesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.remitap.coroutinesapp.coroutineSwitchingApp.SwitchingCoroutine
import com.remitap.coroutinesapp.coroutineApp.CoroutinesBase
import com.remitap.coroutinesapp.coroutineApp2.CoroutineApp2
import com.remitap.coroutinesapp.coroutineParallelApp.CoroutineParallelApp
import com.remitap.coroutinesapp.coroutineSeqApp.CoroutineSeqential
import com.remitap.coroutinesapp.databinding.ActivityMainBinding
import com.remitap.coroutinesapp.deepDiveCoroutinesApp2.DDCoroutineApp2
import com.remitap.coroutinesapp.deepDiveCoroutinesApp3.DDCoroutineApp3
import com.remitap.coroutinesapp.deepDiveCoroutinesFirst.DDCoroutineFirstAppActivity

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

        binding.BtnDDFirstCoroutineApp.setOnClickListener {
            var intent: Intent = Intent(this, DDCoroutineFirstAppActivity::class.java)
            startActivity(intent)
        }

        binding.BtnDDCoroutineApp2.setOnClickListener {
            var intent: Intent = Intent(this, DDCoroutineApp2::class.java)
            startActivity(intent)
        }

        binding.BtnDDCorutineApp3.setOnClickListener {
            var intent: Intent = Intent(this, DDCoroutineApp3::class.java)
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