package com.shifthackz.tutorial.l1_android_app_components

import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.Toast
import com.shifthackz.tutorial.l1_android_app_components.R

class MainActivity : AppCompatActivity() {

    private val demoServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            demoService = (binder as? DemoService.DemoServiceBinder)?.service
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            demoService = null
        }
    }

    private var demoService: DemoService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_call)?.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL))
        }

        val serviceReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.extras
                    ?.getString(DemoService.KEY_MESSAGE)
                    ?.let(::showMessageFromReceiver)
            }
        }
        registerReceiver(serviceReceiver, IntentFilter(DemoService.RECEIVER_ACTION))
    }

    override fun onStart() {
        super.onStart()
        bindService(Intent(this, DemoService::class.java), demoServiceConnection, BIND_AUTO_CREATE)
    }

    override fun onStop() {
        unbindService(demoServiceConnection)
        demoService = null
        super.onStop()
    }

    private fun showMessageFromReceiver(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}