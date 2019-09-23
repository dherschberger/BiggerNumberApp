package com.tutorial.biggernumberapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var mPoints: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickRandomNumbers()
        title = "Bigger Number"
    }

    fun buttonClicked(view: View) {
        compareNums(view == left_button)
        points_lbl.text = "Points: $mPoints"
        pickRandomNumbers()
    }

    private fun pickRandomNumbers() {
        val leftNum = Random.nextInt(0, 100)
        var rightNum = leftNum
        while (leftNum == rightNum) {
            rightNum = Random.nextInt(0, 100)
        }
        left_button.text = "$leftNum"
        right_button.text = "$rightNum"
    }

    private fun compareNums(isLeftBigger: Boolean) {
        val leftNum = left_button.text.toString().toInt()
        val rightNum = right_button.text.toString().toInt()
        if (leftNum > rightNum) {
            if (isLeftBigger) mPoints++ else mPoints--
        } else {
            if (isLeftBigger) mPoints-- else mPoints++
        }
    }
}
