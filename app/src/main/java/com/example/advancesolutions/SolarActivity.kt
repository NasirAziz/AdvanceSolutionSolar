package com.example.advancesolutions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

            var totalWatts: Double

            fan = binding.etFans.text.toString().toInt()
            lights = binding.etLights.text.toString().toInt()
            ac = binding.etAC.text.toString().toInt()
            machine = binding.etWMachine.text.toString().toInt()
            led = binding.etLEDs.text.toString().toInt()
            freezer = binding.etFreezer.text.toString().toInt()
            motor = binding.etMotor.text.toString().toInt()

            totalWatts =
                ((fan * 120)
                    + (lights*30)
                    + (ac*3500)
                    + (machine*1000)
                    + (led*100)
                    + (freezer*100)
                    + (motor*1000)).toDouble()

            totalWatts /= 1000
            binding.tvTotalWatts.visibility = View.VISIBLE
            binding.tvTotalWatts.text = totalWatts.toString() + " kW"
        }

    }
}