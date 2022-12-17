package com.bagher.the_bigger_number

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButtons()

        btnLeft.setOnClickListener(){


            checkAsnwer(isRightButtonSelected = false)
            assignNumbersToButtons()

        }

        btnRight.setOnClickListener(){
            checkAsnwer(isRightButtonSelected = true)
            assignNumbersToButtons()
        }




    }

    private fun assignNumbersToButtons(){

        val leftNum:Int= Random.nextInt(10)
        var rightNum:Int=Random.nextInt(10)

        while (leftNum==rightNum){
            rightNum=Random.nextInt(10)
        }

        btnRight.text="$rightNum"
        btnLeft.text="$leftNum"

    }

    private fun checkAsnwer(isRightButtonSelected:Boolean){

        // Here is comment for the fourth commit just to see the difference

        val rightNum:Int=btnRight.text.toString().toInt()
        val leftNum:Int=btnLeft.text.toString().toInt()


        val isAnswerCorrect:Boolean=  if (isRightButtonSelected) rightNum>leftNum else leftNum>rightNum

        if (isAnswerCorrect){

            constraintMain.setBackgroundColor(Color.CYAN)
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()

        }else{

            constraintMain.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()


        }



    }
}