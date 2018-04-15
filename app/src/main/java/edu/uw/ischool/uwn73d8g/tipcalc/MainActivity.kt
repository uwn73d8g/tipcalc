package edu.uw.ischool.uwn73d8g.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    private val df2 = DecimalFormat(".##")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1: Button = findViewById(R.id.tip)
        b1.isEnabled = false

        var money: EditText = findViewById(R.id.amount)
        money.setOnClickListener {
//            money.context("$" + money.text.toString())
            b1.isEnabled = true
        }


        b1.setOnClickListener {
            val value = money.text.toString().toDouble() * 0.15
            Toast.makeText(this@MainActivity, "$" + df2.format(value).toString(),
                    Toast.LENGTH_LONG).show()
        }
    }
}


