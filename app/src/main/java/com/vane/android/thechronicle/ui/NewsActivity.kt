package com.vane.android.thechronicle.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vane.android.thechronicle.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }
}