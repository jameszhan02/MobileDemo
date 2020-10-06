package com.example.shengzhaninfo5126quiz1_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.appcompat.app.AppCompatActivity


class SelectionActivity : AppCompatActivity() {
    companion object{
        const val RETURN_NAME = "FAV_NAME"
    }

    private lateinit var spinnerNames: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
        //init the widgets
        spinnerNames = findViewById(R.id.spinnerNames)
        val apsAdapter: SpinnerAdapter = spinnerNames.getAdapter()
        val k = apsAdapter.count
        val passVal = intent.getStringExtra(MainActivity.POKEMON_NAME)
        for (i in 0 until k) {
            if (passVal == apsAdapter.getItem(i).toString()) {
                spinnerNames.setSelection(i, true)
                break
            }
        }
    }



    fun onClickGoBack(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply{
                putExtra(RETURN_NAME, spinnerNames.selectedItem.toString())
        }
        startActivity(intent)// start the page
    }
}