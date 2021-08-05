package ru.ds.supercalckot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import ru.ds.supercalckot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var action: String

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

//испольщую with для чтобы не повторять bind
//перечисляю действия с аргументами калькулятора
//использую функцию верхнего порядка operation для упрошения кода

        with(bind) {
            BtSum.setOnClickListener {
                operation(argOne,argTwo) { a1, a2 -> a1 + a2}
            }
            BtSub.setOnClickListener {
                operation(argOne,argTwo) { a1, a2 -> a1 - a2}
            }
            BtDiv.setOnClickListener {
                operation(argOne,argTwo) { a1, a2 -> a1 / a2}
            }
            BtMult.setOnClickListener {
                operation(argOne,argTwo) { a1, a2  -> a1 * a2}
                }
            }

        }

    private fun operation (argOne : EditText, argTwo : EditText, operator: (Double, Double) -> Double){
        val a1 = bind.argOne.text.toString().toDouble()
        val a2 = bind.argTwo.text.toString().toDouble()
        val res =operator(a1,a2)
        bind.txView.text = res.toString()
    }
    }








