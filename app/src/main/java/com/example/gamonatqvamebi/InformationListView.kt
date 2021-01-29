package com.example.gamonatqvamebi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.core.view.size

class InformationListView : AppCompatActivity() {
    private lateinit var chamonatvali: ListView
    val user = listOf<String>(
            "გამონათქვამები"

            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_list_view)


    chamonatvali = findViewById(R.id.mainListView)
        chamonatvali.size
        val BackColor = Color.LTGRAY
        chamonatvali.setBackgroundColor(BackColor)

    chamonatvali.adapter = MyAdapter(this,user)

        chamonatvali.setOnClickListener {
            val intent = Intent(this,Gamonatqvamebi::class.java)
            startActivity(intent)
        }
    }
}