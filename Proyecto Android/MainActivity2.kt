package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn2: Button = findViewById(R.id.button2)

        btn2.setOnClickListener {

            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val btn3: Button = findViewById(R.id.button3)

        btn3.setOnClickListener {

            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        val btn4: Button = findViewById(R.id.favoritos)

        btn4.setOnClickListener{

            val intent = Intent(this,Favoritos::class.java)
            startActivity(intent)
        }
    }
}