package com.example.tictactoe

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        //var layout = findViewById(R.id.constraintlayout)
        super.onCreate(savedInstanceState)
        var turnCounter = 0
        var winCheck = arrayListOf(
            arrayListOf(0,0,0),
            arrayListOf(0,0,0),
            arrayListOf(0,0,0)
        )

        setContentView(R.layout.activity_main)
        topLeft.setOnClickListener{
            changeColor(turnCounter,topLeft)

            if(turnCounter%2 == 0) winCheck[0][0] = -1
            else winCheck[0][0] = 1
            endGame(winCheck)
            turnCounter++
        }
        topMid.setOnClickListener{
            changeColor(turnCounter,topMid)
            if(turnCounter%2 == 0) winCheck[0][1] = -1
            else winCheck[0][1] = 1
            endGame(winCheck)
            turnCounter++
        }
        topRight.setOnClickListener{
            changeColor(turnCounter,topRight)
            if(turnCounter%2 == 0) winCheck[0][2] = -1
            else winCheck[0][2] = 1
            endGame(winCheck)
            turnCounter++
        }
        midLeft.setOnClickListener{
            changeColor(turnCounter,midLeft)
            if(turnCounter%2 == 0) winCheck[1][0] = -1
            else winCheck[1][0] = 1
            endGame(winCheck)
            turnCounter++
        }
        midMid.setOnClickListener{
            changeColor(turnCounter,midMid)
            if(turnCounter%2 == 0) winCheck[1][1] = -1
            else winCheck[1][1] = 1
            endGame(winCheck)
            turnCounter++
        }
        midRight.setOnClickListener{
            changeColor(turnCounter,midRight)
            if(turnCounter%2 == 0) winCheck[1][2] = -1
            else winCheck[1][2] = 1
            endGame(winCheck)
            turnCounter++
        }
        botLeft.setOnClickListener{
            changeColor(turnCounter,botLeft)
            if(turnCounter%2 == 0) winCheck[2][0] = -1
            else winCheck[2][0] = 1
            endGame(winCheck)
            turnCounter++
        }
        botMid.setOnClickListener{
            changeColor(turnCounter,botMid)
            if(turnCounter%2 == 0) winCheck[2][1] = -1
            else winCheck[2][1] = 1
            endGame(winCheck)
            turnCounter++
        }
        botRight.setOnClickListener{
           changeColor(turnCounter,botRight)
            if(turnCounter%2 == 0) winCheck[2][2] = -1
            else winCheck[2][2] = 1
            endGame(winCheck)
            turnCounter++
        }

    }
        private fun endGame(winCheck:ArrayList<ArrayList<Int>>){
            if(checkWin(winCheck) == -1){
                println("Player 1 wins")


                val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                // Inflate a custom view using layout inflater
                val view = inflater.inflate(R.layout.winner_pop_up,null)

                // Initialize a new instance of popup window
                val popupWindow = PopupWindow(
                    view, // Custom view to show in popup window
                    LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                    LinearLayout.LayoutParams.WRAP_CONTENT // Window height
                )
                val buttonPopup = view.findViewById<Button>(R.id.button_popup)
                buttonPopup.setOnClickListener{
                    // Dismiss the popup window
                    popupWindow.dismiss()
                }
                var text:TextView = view.findViewById(R.id.text_view)
                text.setText("Player 1 wins!")
                //text.text = resources.getString(R.string.app_name)

                TransitionManager.beginDelayedTransition(constraintlayout)
                popupWindow.showAtLocation(
                    constraintlayout, // Location to dis play popup window
                    Gravity.CENTER, // Exact position of layout to display popup
                    0, // X offset
                    0 // Y offset
                )

            }
            if(checkWin(winCheck) == 1){

                val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                // Inflate a custom view using layout inflater
                val view = inflater.inflate(R.layout.winner_pop_up,null)

                // Initialize a new instance of popup window
                val popupWindow = PopupWindow(
                    view, // Custom view to show in popup window
                    LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                    LinearLayout.LayoutParams.WRAP_CONTENT // Window height
                )
                val buttonPopup = view.findViewById<Button>(R.id.button_popup)
                buttonPopup.setOnClickListener{
                    // Dismiss the popup window
                    popupWindow.dismiss()
                }
                val replay = view.findViewById<Button>(R.id.button_replay)
                replay.setOnClickListener{

                    popupWindow.dismiss()
                }
                var text:TextView = view.findViewById(R.id.text_view)
                text.setText("Player 2 wins!")
                TransitionManager.beginDelayedTransition(constraintlayout)
                popupWindow.showAtLocation(
                    constraintlayout, // Location to dis play popup window
                    Gravity.CENTER, // Exact position of layout to display popup
                    0, // X offset
                    0 // Y offset
                )
            }
        }
        private fun checkWin(winCheck: ArrayList<ArrayList<Int>>): Int {
            for (i in 0..2) { //check the rows and columns
                if (winCheck[i].sum() == -3) return -1


                if (winCheck[i].sum() == 3) return 1

                var sum = 0
                for (j in 0..2) {
                    sum += winCheck[j][i]
                }
                if(sum == -3) return -1
                if(sum == 3) return 1
            }
            var Diag1 = winCheck[0][0]+winCheck[1][1]+winCheck[2][2]
            var Diag2 = winCheck[0][2]+winCheck[1][1]+winCheck[2][0]
            if(Diag1 == 3 || Diag2 == 3) return 1
            if(Diag1 == -3 || Diag2 == -3) return -1

            return 0
        }

        private fun changeColor(turn: Int , button: Button){
            if(turn%2 == 0) button.setBackgroundColor(Color.RED)
            else button.setBackgroundColor(Color.GREEN)
    }
}
