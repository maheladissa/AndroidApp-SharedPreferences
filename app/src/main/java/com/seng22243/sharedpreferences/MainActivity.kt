package com.seng22243.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("SP_INFO", MODE_PRIVATE)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val viewButton = findViewById<Button>(R.id.viewButton)
        val editTextTextPersonName = findViewById<EditText>(R.id.editTextTextPersonName)
        val infoView = findViewById<TextView>(R.id.infoView)

        submitButton.setOnClickListener {

            val name = editTextTextPersonName.text.toString()

            val editor = sharedPreferences.edit();

            editor.putString("Name", name)


            editor.apply();

        }

        viewButton.setOnClickListener{
            val name = sharedPreferences.getString("Name","")

            infoView.text = "Name: $name"

        }
    }
}