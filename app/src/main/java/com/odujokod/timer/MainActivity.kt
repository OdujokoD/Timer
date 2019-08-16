package com.odujokod.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    private lateinit var chronometer: Chronometer

    private var running: Boolean = false
    private var offset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chronometer = findViewById(R.id.chronometer)
        startButton = findViewById(R.id.btn_start)
        stopButton = findViewById(R.id.btn_stop)
    }

    fun startTimer(view: View) {
        if (!running) {
            chronometer.base = SystemClock.elapsedRealtime() - offset
            chronometer.start()
            running = true
        }
    }

    fun stopTimer(view: View) {
        if (running) {
            chronometer.stop()
            offset = SystemClock.elapsedRealtime() - chronometer.base
            running = false
        }
    }
}
