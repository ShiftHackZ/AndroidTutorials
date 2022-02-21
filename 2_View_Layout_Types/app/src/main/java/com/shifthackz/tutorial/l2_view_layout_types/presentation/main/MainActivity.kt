package com.shifthackz.tutorial.l2_view_layout_types.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.shifthackz.tutorial.l2_view_layout_types.R
import com.shifthackz.tutorial.l2_view_layout_types.presentation.constraint.ConstraintLayoutActivity
import com.shifthackz.tutorial.l2_view_layout_types.presentation.constraint.ConstraintSimpleLayoutActivity
import com.shifthackz.tutorial.l2_view_layout_types.presentation.frame.FrameLayoutActivity
import com.shifthackz.tutorial.l2_view_layout_types.presentation.linear.LinearLayoutActivity
import com.shifthackz.tutorial.l2_view_layout_types.presentation.relative.RelativeLayoutActivity
import com.shifthackz.tutorial.l2_view_layout_types.presentation.views.ViewComponentsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnViews)?.setOnClickListener {
            startActivity(Intent(this, ViewComponentsActivity::class.java))
        }
        findViewById<Button>(R.id.btnLinear)?.setOnClickListener {
            startActivity(Intent(this, LinearLayoutActivity::class.java))
        }
        findViewById<Button>(R.id.btnFrame)?.setOnClickListener {
            startActivity(Intent(this, FrameLayoutActivity::class.java))
        }
        findViewById<Button>(R.id.btnRelative)?.setOnClickListener {
            startActivity(Intent(this, RelativeLayoutActivity::class.java))
        }
        findViewById<Button>(R.id.btnConstraint1)?.setOnClickListener {
            startActivity(Intent(this, ConstraintSimpleLayoutActivity::class.java))
        }
        findViewById<Button>(R.id.btnConstraint2)?.setOnClickListener {
            startActivity(Intent(this, ConstraintLayoutActivity::class.java))
        }
    }
}