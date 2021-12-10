package com.example.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat
import java.text.Format

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val amount: EditText = findViewById(R.id.editTextNumber)
        //val radGroup: RadioGroup = findViewById(R.id.rGroup)
        val toRuble: RadioButton = findViewById(R.id.radioButton)
        val toUSD: RadioButton = findViewById(R.id.radioButton2)
        val calculate: Button = findViewById(R.id.button)
        val output: TextView = findViewById(R.id.textResult)

        var total = 0.0

        calculate.setOnClickListener {

            var tag: String = "currency"
            if (toRuble.isChecked) {
                // Based off of 1 : 73.66 conversion
                total = amount.text.toString().toDouble() * 73.66
                tag = "Rubles"
            }

            if (toUSD.isChecked) {
                // Based off of 1 : .01 conversion
                total = amount.text.toString().toDouble() * .01
                tag = "USD"
            }

            if ((amount.text.toString().toDouble() > 10000 && toRuble.isChecked) || (total > 10000 && tag == "USD"))
                Toast.makeText(this, "Cheers!",Toast.LENGTH_LONG).show()

            val convCurOutput = DecimalFormat("###,###.00")
            val displayOutput = convCurOutput.format(total)

            output.text = "Converts to $displayOutput $tag"
        }
    }
}