package com.example.myapplicationp0o

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationp0o.model.Scope

class MainActivity : AppCompatActivity() {
    val AG = MainActivity::class.java.toString()
    lateinit var tv_file: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    var detailLauncher = registerForActivityResult(
        StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val get = Scope(14, "Zarifjon")
            Log.d(AG, "user")
            tv_file.setText(get.toString())
        }
    }
    fun initViews() {
        tv_file = findViewById<TextView>(R.id.tv_file)
        val b_detail = findViewById<Button>(R.id.b_element)
        b_detail.setOnClickListener {
            val get = Scope(14, "Zarifjon")
            openDetailActivity(get)
        }
        if (intent.hasExtra("mirror")) {
            val mirror = intent.getSerializableExtra("mirror")
            Log.d(AG, mirror.toString())
            tv_file.setText(mirror.toString())
        }
    }

    fun openDetailActivity(get: Scope) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("get", get)
        setResult(RESULT_OK, intent)
        detailLauncher.launch(intent)
    }
}