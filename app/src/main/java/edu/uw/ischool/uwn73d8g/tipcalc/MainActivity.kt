package edu.uw.ischool.uwn73d8g.tipcalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        money.addTextChangedListener(object: TextWatcher {

            override fun afterTextChanged(p0: Editable) {
            }

            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var amount = s.toString()
                if (!amount.startsWith("$")) {
                    money.setText("$$s")
                } else if (amount.isEmpty()) {
                    money.setText("$0.00")
                } else if (amount.contains(".")) {
                    var num = amount.split(".")
                    if (num[1].length > 2) {
                        var splitNum= num[1].slice(0..1)
                        money.setText(num[0] + "." + splitNum)
                    }
                }
                b1.isEnabled = true
                money.setSelection(money.text.length)
            }
        })


        b1.setOnClickListener {
                val value = money.text.toString().substring(1).toDouble() * 0.15
                Toast.makeText(this@MainActivity, "$" + df2.format(value).toString(),
                        Toast.LENGTH_LONG).show()
            }
    }
}


