package com.shifthackz.tutorial.l1_android_app_components

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.os.Looper

class DemoService : Service() {

    class DemoServiceBinder(val service: DemoService) : Binder()

    private val binder = DemoServiceBinder(this)

    override fun onBind(p0: Intent?): IBinder = binder

    override fun onCreate() {
        super.onCreate()
        Handler(Looper.getMainLooper()).postDelayed(::sendBroadcastHelloMessage, MESSAGE_DELAY)
    }

    private fun sendBroadcastHelloMessage() {
        val intent = Intent(RECEIVER_ACTION)
        intent.putExtra(KEY_MESSAGE, "Hello, from Demo Service ;)")
        sendBroadcast(intent)
    }

    companion object {
        const val RECEIVER_ACTION = "demo_receiver_action"
        const val KEY_MESSAGE = "demo_message"

        private const val MESSAGE_DELAY = 5_000L
    }
}