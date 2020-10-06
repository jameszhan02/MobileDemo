package com.example.shengzhaninfo5126quiz1_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val POKEMON_NAME = "FAV_NAME"
    }
    private lateinit var textViewAns: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init the widgets
        textViewAns = findViewById(R.id.textViewAns)
    }

    override fun onPause() {

        super.onPause()
    }
    override fun onResume() {
        super.onResume()
        val returnVal = intent.getStringExtra(SelectionActivity.RETURN_NAME)
        textViewAns.text = returnVal

    }

    fun onSelectBtnClick(view: View) {
        val intent = Intent(this, SelectionActivity::class.java).apply{
            if( textViewAns.text.toString() == ""){
                textViewAns.text = "PiKachu"
            }
            putExtra(POKEMON_NAME, textViewAns.text.toString())
        }
        startActivity(intent)// start the page
    }
}