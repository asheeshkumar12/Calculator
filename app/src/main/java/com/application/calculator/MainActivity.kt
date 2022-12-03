package com.application.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener {
            button_input.text=""
            button_output.text=""
        }
        button_modulo.setOnClickListener {
            button_input.text= addToInputText("(")
        }
        button_delete.setOnClickListener {
            button_input.text=addToInputText(")")
        }
        button_point.setOnClickListener {
            button_input.text=addToInputText(".")
        }
        button_multi.setOnClickListener {
            button_input.text=addToInputText("*")
        }
        button_divide.setOnClickListener {
            button_input.text=addToInputText("/")
        }
        button_add.setOnClickListener {
            button_input.text=addToInputText("+")
        }
        button_minus.setOnClickListener {
            button_input.text=addToInputText("-")
        }
        button_0.setOnClickListener {
            button_input.text=addToInputText("0")
        }
        button_00.setOnClickListener {
            button_input.text=addToInputText("00")
        }
        button_one.setOnClickListener {
            button_input.text=addToInputText("1")
        }
        button_two.setOnClickListener {
            button_input.text=addToInputText("2")
        }
        button_three.setOnClickListener {
            button_input.text=addToInputText("3")
        }
        button_four.setOnClickListener {
            button_input.text=addToInputText("4")
        }
        button_five.setOnClickListener {
            button_input.text=addToInputText("5")
        }
        button_six.setOnClickListener {
            button_input.text=addToInputText("6")
        }
        button_seven.setOnClickListener {
            button_input.text=addToInputText("7")
        }
        button_eight.setOnClickListener {
            button_input.text=addToInputText("8")
        }
        button_nine.setOnClickListener {
            button_input.text=addToInputText("9")
        }

        button_equals.setOnClickListener {
            showresults()
        }




    }
    private fun getInputExpression(): String {
        var expression=button_input.text.replace(Regex("×"),"*")
        expression=button_input.text.replace(Regex("÷"),"/")
        return expression
    }
    private fun showresults() {
        try {
            val exp=getInputExpression()
            val result=Expression(exp).calculate()
            if(result.isNaN()){
                button_output.text="Error"
                button_output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }else{
                button_output.text=DecimalFormat("0.#####").format(result).toString()
                button_output.setTextColor(ContextCompat.getColor(this,R.color.green))
            }

        } catch (e:java.lang.Exception){
            button_output.text="Error"
            button_output.setTextColor(ContextCompat.getColor(this,R.color.red))

        }
    }

    private fun addToInputText(buttonValue : String ): String{
           return "${button_input.text}$buttonValue"
    }
}