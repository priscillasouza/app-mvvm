package com.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _resultCalculateGasoline: MutableLiveData<Double> = MutableLiveData()
    val resultCalculateGasoline: LiveData<Double> get() = _resultCalculateGasoline

    private var _resultCalculateAlcohol: MutableLiveData<Double> = MutableLiveData()
    val resultCalculateAlcohol: LiveData<Double> get() = _resultCalculateAlcohol

    fun calculateGasoline(distance: Double, consumption: Double, gasolinePrice: Double) {
        val spendGasoline = calculateConsumption(distance, consumption, gasolinePrice)
        _resultCalculateGasoline.postValue(spendGasoline)
    }

    fun calculateAlcohol(distance: Double, consumption: Double, alcoholPrice: Double) {
        val spendAlcohol = calculateConsumption(distance, consumption, alcoholPrice)
        _resultCalculateAlcohol.postValue(spendAlcohol)
    }

    private fun calculateConsumption(
        distance: Double,
        consumption: Double,
        combustiblePrice: Double
    ): Double {
        return (distance * combustiblePrice ) / consumption
    }
}