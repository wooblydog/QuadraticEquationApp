package com.example.lab2_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.lab2_app.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var a: EditText
    private lateinit var b: EditText
    private lateinit var c: EditText
    private lateinit var calcBtn: Button
    private lateinit var resultText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        a = binding.aVal
        b = binding.bVal
        c = binding.cVal
        calcBtn = binding.btn
        resultText = binding.resultText
    }

    fun discriminant(a: Double, b: Double, c: Double) = b * b - 4 * a * c

    fun rootPositive(a: Double, b: Double, c: Double) =
        (-b + sqrt(discriminant(a, b, c))) / (2 * a)

    fun rootNegative(a: Double, b: Double, c: Double) =
        (-b - sqrt(discriminant(a, b, c))) / (2 * a)

    fun rootZero(a: Double, b: Double) = (-b / (2 * a))

    fun onClick(view: View) {
        val A = a.text.toString().toDoubleOrNull()
        val B = b.text.toString().toDoubleOrNull()
        val C = c.text.toString().toDoubleOrNull()
        if (A != null && B != null && C != null) {
            if (A == 0.0) {
                resultText.text = "А не должно равняться 0"
                return
            }
            val D = discriminant(A, B, C)
            if (discriminant(A, B, C) < 0) {
                resultText.text = "Дискриминант меньше 0 :("
                return
            }
            if (D == 0.0) {
                resultText.text = "x = " + rootZero(A, B)
            } else {
                resultText.text =
                    "x1 = " + rootPositive(A, B, C) + "\nx2 = " + rootNegative(A, B, C)
            }
        } else {
            resultText.text = "Заполните поля"
        }
    }
}
