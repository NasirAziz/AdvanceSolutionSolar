package com.example.advancesolutions

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.advancesolutions.databinding.ActivitySolarBinding


class SolarActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySolarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSolarSubmit.setOnClickListener {
            var fan: Int = 0
            var lights: Int = 0
            var ac: Int = 0
            var machine: Int = 0
            var led: Int = 0
            var motor: Int = 0
            var freezer: Int = 0

            val layout = binding.root
            fillBlankEditViews(layout)

            fan = binding.etFans.text.toString().replace("\n","").replace(" ","").toInt()
            lights = binding.etLights.text.toString().replace("\n","").replace(" ","").toInt()
            ac = binding.etAC.text.toString().replace("\n","").replace(" ","").toInt()
            machine = binding.etWMachine.text.toString().replace("\n","").replace(" ","").toInt()
            led = binding.etLEDs.text.toString().replace("\n","").replace(" ","").toInt()
            freezer = binding.etFreezer.text.toString().replace("\n","").replace(" ","").toInt()
            motor = binding.etMotor.text.toString().replace("\n","").replace(" ","").toInt()


            var totalWatts: Double = ((fan * 120)
                    + (lights*30)
                    + (ac*3500)
                    + (machine*1000)
                    + (led*100)
                    + (freezer*100)
                    + (motor*1000)).toDouble()

            totalWatts /= 1000
            binding.tvTotalWatts.visibility = View.VISIBLE
            binding.tvTotalWatts.text = "$totalWatts kW"
        }

    }


    private fun fillBlankEditViews(layout: LinearLayout) {
        for (i in 0 until layout.childCount) {
            Log.i("solarActivity", "${layout.childCount}")
            val v = layout.getChildAt(i)
            if(v is LinearLayout) {
                val etv = v.getChildAt(1)
                if (etv is EditText) {
                    Log.i("solarActivity", "v is EditText")
                    if (etv.text.isNullOrEmpty()) {
                        Log.i("solarActivity", "EditText is null")
                        etv.setText("0")

                    }
                }
            }
        }
    }
}