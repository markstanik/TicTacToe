package com.example.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        //var layout = findViewById(R.id.constraintlayout)
        super.onCreate(savedInstanceState)
        var turnCounter = 0

        setContentView(R.layout.activity_main)
        topLeft.setOnClickListener{
            changeColor(turnCounter,topLeft)
            println(topLeft.solidColor)
            if(topLeft.solidColor == Color.GREEN){
                topLeft.setBackgroundColor(Color.BLUE)
            }
            turnCounter++
        }
        topMid.setOnClickListener{
            changeColor(turnCounter,topMid)

            turnCounter++
        }
        topRight.setOnClickListener{
            changeColor(turnCounter,topRight)

            turnCounter++
        }
        midLeft.setOnClickListener{
            changeColor(turnCounter,midLeft)

            turnCounter++
        }
        midMid.setOnClickListener{
            changeColor(turnCounter,midMid)

            turnCounter++
        }
        midRight.setOnClickListener{
            changeColor(turnCounter,midRight)

            turnCounter++
        }
        botLeft.setOnClickListener{
            changeColor(turnCounter,botLeft)

            turnCounter++
        }
        botMid.setOnClickListener{
            changeColor(turnCounter,botMid)

            turnCounter++
        }
        botRight.setOnClickListener{
           changeColor(turnCounter,botRight)

            turnCounter++
        }

    }

        private fun changeColor(turn: Int , button: Button){
            if(turn%2 == 0) button.setBackgroundColor(Color.RED)
            else button.setBackgroundColor(Color.GREEN)
    }
}
