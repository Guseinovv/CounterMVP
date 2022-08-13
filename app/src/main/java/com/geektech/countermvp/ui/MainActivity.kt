package com.geektech.countermvp.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geektech.countermvp.databinding.ActivityMainBinding
import com.geektech.countermvp.helper.Injector
import com.geektech.countermvp.view.CounterView

class MainActivity : AppCompatActivity(),CounterView{
    lateinit var binding: ActivityMainBinding
    private val presenter= Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClicker()

    }

    private fun initClicker() {
        with(binding) {
            incrementBtn.setOnClickListener {
              presenter.increment()
            }
            decrementBtn.setOnClickListener {
              presenter.decrement()
            }
        }
    }

    override fun updateText(count: Int) {
        binding.counterTv.text = count.toString()
    }

    override fun showToast() {
        Toast.makeText(this, "ха лох!", Toast.LENGTH_SHORT).show()
    }
        override fun changeColor() {
            binding.counterTv.setTextColor(Color.BLUE)

        }
    }
