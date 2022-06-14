package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setUpObservers()
        setUpListeners()
    }

    private fun setUpObservers() {
        viewModel.apply {
            resultCalculateGasoline.observe(this@MainActivity, Observer {
                binding.textViewResultGasoline.text = it.toString()
            })
            resultCalculateAlcohol.observe(this@MainActivity, Observer {
                binding.textViewResultAlcool.text = it.toString()
            })
        }
    }

    private fun setUpListeners() {
        binding.apply {
            buttonCalculate.setOnClickListener {
                viewModel.calculateGasoline(
                    distance = editTextDistance.text.toString().toDouble(),
                    consumption = editTextKm.text.toString().toDouble(),
                    gasolinePrice = editTextGasolinePrice.text.toString().toDouble()
                )
                viewModel.calculateAlcohol(
                    distance = editTextDistance.text.toString().toDouble(),
                    consumption = editTextKm.text.toString().toDouble(),
                    alcoholPrice = editTextAlcoholPrice.text.toString().toDouble()
                )
            }
        }
    }
}