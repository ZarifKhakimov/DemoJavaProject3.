package com.example.myapplicationp0o

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationp0o.model.Got

class DetailActivity : AppCompatActivity() {
    val MAG = MainActivity::class.java.toString()
    lateinit var tv_uri: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    var detailLauncher = registerForActivityResult(
        StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val m = result.data
            val mirror = Got(1,"Much")
            Log.d(MAG, "member")
            tv_uri.setText(mirror.toString())
        }
    }

    fun initViews() {
        tv_uri = findViewById<TextView>(R.id.tv_uri)
        val b_exit = findViewById<Button>(R.id.b_back)
        b_exit.setOnClickListener {
            val mirror = Got(1,"Much")
            backToFinish(mirror)
        }
        val get = intent.getSerializableExtra("get")
        Log.d(MAG, get.toString())

        tv_uri.setText(get.toString())
    }

    fun backToFinish(mirror: Got) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("mirror", mirror)
        setResult(RESULT_OK, intent)
        detailLauncher.launch(intent)
        finish()
    }
}