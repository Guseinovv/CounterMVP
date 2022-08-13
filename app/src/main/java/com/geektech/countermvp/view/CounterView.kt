package com.geektech.countermvp.view

interface CounterView {

    fun updateText(count: Int)
    fun showToast()
    fun changeColor()
}