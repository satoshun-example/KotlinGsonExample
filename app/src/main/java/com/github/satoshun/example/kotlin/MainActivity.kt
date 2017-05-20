package com.github.satoshun.example.kotlin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  private var textMessage: TextView? = null

  private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_home -> {
        textMessage!!.setText(R.string.title_home)
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_dashboard -> {
        textMessage!!.setText(R.string.title_dashboard)
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_notifications -> {
        textMessage!!.setText(R.string.title_notifications)
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    textMessage = findViewById(R.id.message) as TextView
    val navigation = findViewById(R.id.navigation) as BottomNavigationView
    navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
  }
}
