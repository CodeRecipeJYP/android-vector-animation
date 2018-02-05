package com.example.jaeyoungpark.animationplayground

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {
    companion object {
        val TAG = "ScrollingActivity"
    }

    private var tick: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        btn.setOnClickListener { animate() }
    }

    private fun animate() {
        Log.d(TAG, "animate: ")
        (if (!tick) R.drawable.avd_cross_to_tick else R.drawable.avd_tick_to_cross)
                .also { tick = !tick }
                .let {
                    Log.d(TAG, "animate: getDrawable($it)")
                    getDrawable(it)
                }
                .also {
                    Log.d(TAG, "animate: ibtn_playpause.setImageDrawable($it)")
                    ibtn_playpause.setImageDrawable(it)
                }
                .also {
                    Log.d(TAG, "animate: ($it as Animatable).start()")
                    (it as Animatable).start()
                }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings ->
                return true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
