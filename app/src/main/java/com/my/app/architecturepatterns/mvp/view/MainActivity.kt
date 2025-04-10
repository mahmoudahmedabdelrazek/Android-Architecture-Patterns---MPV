package com.my.app.architecturepatterns.mvp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.my.app.architecturepatterns.mvp.MainView
import com.my.app.architecturepatterns.mvp.presenter.MainPresenter
import com.my.app.architecturepatterns.mvp.R

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var editTextname = findViewById<EditText>(R.id.edtname)
        var editTextage = findViewById<EditText>(R.id.edtage)
        var textView = findViewById<TextView>(R.id.tv)
        var button = findViewById<Button>(R.id.btn)

        presenter = MainPresenter(this)



        button.setOnClickListener {
            var userTextname = editTextname.text.toString()
            var userTextage = editTextage.text.toString()

            presenter.onButtonClick(userTextname, userTextage)

        }


    }

    override fun showUserDetails(name: String, age: Int) {
        val textView = findViewById<TextView>(R.id.tv)
        textView.text = "Your name is: $name, and your age is: $age Years old"
    }

}