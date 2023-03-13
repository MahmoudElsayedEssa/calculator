package com.example.calculator

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var numberSys = NumberSystem.DECIMAL
    private var isCalculate = false
    private var operator: Operator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var prevResult = 0
        var lastInput = 0
        enableDecimalInput()


        //region number system buttons
        binding.btnHex.setOnClickListener {
            numberSys = NumberSystem.HEXADECIMAL
            binding.tvInput.text = binding.tvHex.text
            binding.tvExp.text = ""
            enableHexadecimalInput()
        }
        binding.btnOct.setOnClickListener {
            numberSys = NumberSystem.OCTAL
            binding.tvInput.text = binding.tvOct.text
            binding.tvExp.text = ""
            enableOctalInput()
        }
        binding.btnDec.setOnClickListener {
            numberSys = NumberSystem.DECIMAL
            binding.tvInput.text = binding.tvDec.text
            binding.tvExp.text = ""
            enableDecimalInput()
        }
        binding.btnBin.setOnClickListener {
            numberSys = NumberSystem.BINARY
            binding.tvInput.text = binding.tvBin.text
            binding.tvExp.text = ""
            enableBinaryInput()
        }
        //endregion

        //region input buttons
        binding.btn0.setOnClickListener {
            val textInput = addSymbolToInputText("0")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn1.setOnClickListener {
            val textInput = addSymbolToInputText("1")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn2.setOnClickListener {
            val textInput = addSymbolToInputText("2")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn3.setOnClickListener {
            val textInput = addSymbolToInputText("3")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn4.setOnClickListener {
            val textInput = addSymbolToInputText("4")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn5.setOnClickListener {
            val textInput = addSymbolToInputText("5")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn6.setOnClickListener {
            val textInput = addSymbolToInputText("6")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn7.setOnClickListener {
            val textInput = addSymbolToInputText("7")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn8.setOnClickListener {
            val textInput = addSymbolToInputText("8")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btn9.setOnClickListener {
            val textInput = addSymbolToInputText("9")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btnA.setOnClickListener {
            val textInput = addSymbolToInputText("A")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btnB.setOnClickListener {
            val textInput = addSymbolToInputText("B")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btnC.setOnClickListener {
            val textInput = addSymbolToInputText("C")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btnD.setOnClickListener {
            val textInput = addSymbolToInputText("D")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btnE.setOnClickListener {
            val textInput = addSymbolToInputText("E")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }

        binding.btnF.setOnClickListener {
            val textInput = addSymbolToInputText("F")
            binding.tvInput.text = textInput
            convertToNumberSystems(textInput)
        }
        //endregion

        binding.btnBack.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            input = if (input.length > 1)
                input.dropLast(1)
            else "0"
            binding.tvInput.text = input
            convertToNumberSystems(input)
        }

        binding.btnPlus.setOnClickListener {
            val textInput = convertNumberSystemToDecimalInteger(binding.tvInput.text.toString())
            val textExpression = binding.tvExp.text.toString()

            operator = Operator.ADD
            prevResult += textInput
            binding.tvExp.text =
                getExpression(prevResult, textExpression)
            binding.tvInput.text = convertDecimalIntegerToNumberSystem(prevResult.toString())

            convertToNumberSystems(binding.tvInput.text.toString())
            isCalculate = true
        }

        binding.btnSub.setOnClickListener {
            val textInput = convertNumberSystemToDecimalInteger(binding.tvInput.text.toString())
            val textExpression = binding.tvExp.text.toString()

            operator = Operator.SUB
            prevResult -= textInput
            binding.tvExp.text =
                getExpression(prevResult, textExpression)
            binding.tvInput.text = convertDecimalIntegerToNumberSystem(prevResult.toString())

            convertToNumberSystems(binding.tvInput.text.toString())
            isCalculate = true
        }


        binding.btnMlti.setOnClickListener {
            val textInput = convertNumberSystemToDecimalInteger(binding.tvInput.text.toString())
            val textExpression = binding.tvExp.text.toString()

            operator = Operator.MLTI
            prevResult *= textInput
            binding.tvExp.text =
                getExpression(prevResult, textExpression)
            binding.tvInput.text = convertDecimalIntegerToNumberSystem(prevResult.toString())

            convertToNumberSystems(binding.tvInput.text.toString())
            isCalculate = true
        }
        binding.btnDiv.setOnClickListener {
            val textInput = convertNumberSystemToDecimalInteger(binding.tvInput.text.toString())
            val textExpression = binding.tvExp.text.toString()

            operator = Operator.DIV
            prevResult /= textInput
            binding.tvExp.text =
                getExpression(prevResult, textExpression)
            binding.tvInput.text = convertDecimalIntegerToNumberSystem(prevResult.toString())

            convertToNumberSystems(binding.tvInput.text.toString())
            isCalculate = true
        }


        binding.btnEql.setOnClickListener {
            val textInput = binding.tvInput.text.toString()
            val inputValue = convertNumberSystemToDecimalInteger(textInput)

            val operationText: String
            if (isCalculate) {
                when (operator) {
                    Operator.ADD -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(lastInput.toString())} + ${
                                convertDecimalIntegerToNumberSystem(prevResult.toString())
                            } ="
                        prevResult += lastInput
                    }
                    Operator.DIV -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(lastInput.toString())} / ${
                                convertDecimalIntegerToNumberSystem(prevResult.toString())
                            } ="
                        prevResult /= lastInput
                    }
                    Operator.SUB -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(lastInput.toString())} - ${
                                convertDecimalIntegerToNumberSystem(prevResult.toString())
                            } ="
                        prevResult -= lastInput
                    }
                    Operator.MLTI -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(lastInput.toString())} * ${
                                convertDecimalIntegerToNumberSystem(prevResult.toString())
                            } ="
                        prevResult *= lastInput
                    }
                    else -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(lastInput.toString())} ="
                    }
                }
            } else {
                lastInput = prevResult
                when (operator) {
                    Operator.ADD -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(prevResult.toString())} + $textInput ="
                        prevResult += inputValue
                    }
                    Operator.DIV -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(prevResult.toString())} / $textInput ="
                        prevResult /= inputValue
                    }
                    Operator.SUB -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(prevResult.toString())} - $textInput ="
                        prevResult -= inputValue
                    }
                    Operator.MLTI -> {
                        operationText =
                            "${convertDecimalIntegerToNumberSystem(prevResult.toString())} * $textInput ="
                        prevResult *= inputValue
                    }
                    else -> {
                        operationText = "$textInput ="
                    }
                }
            }

            isCalculate = true
            binding.tvExp.text = operationText
            binding.tvInput.text = convertDecimalIntegerToNumberSystem(prevResult.toString())
            convertToNumberSystems(binding.tvInput.text.toString())
        }


        binding.btnClr.setOnClickListener {
            binding.tvExp.text = ""
            binding.tvInput.text = "0"
            prevResult = 0
            lastInput = 0
            isCalculate = false
            operator = null
            convertToNumberSystems("0")
        }

    }

    private fun addSymbolToInputText(buttonSymbols: String): String {
        val input = getInputText()
        return input + buttonSymbols
    }

    private fun getInputText(): String {
        var input = binding.tvInput.text.toString()
        if (input == "0") input = ""
        if (isCalculate) {
            input = ""
            isCalculate = false
        }
        return input
    }

    private fun getExpression(
        prevResult: Int,
        textInputPlus: String,
        symbol: String = operator?.symbol!!
    ) = if (isCalculate) {
        when (numberSys) {
            NumberSystem.HEXADECIMAL -> "${prevResult.toUInt().toString(16)} $symbol "
            NumberSystem.DECIMAL -> "$prevResult + "
            NumberSystem.OCTAL -> "${prevResult.toUInt().toString(8)} $symbol "
            NumberSystem.BINARY -> "${prevResult.toUInt().toString(2)} $symbol "
        }
    } else "$textInputPlus${binding.tvInput.text} $symbol "

    private fun convertNumberSystemToDecimalInteger(textInput: String) = when (numberSys) {
        NumberSystem.HEXADECIMAL -> Integer.parseInt(textInput, 16)
        NumberSystem.DECIMAL -> textInput.toInt()
        NumberSystem.OCTAL -> Integer.parseInt(textInput, 8)
        NumberSystem.BINARY -> Integer.parseInt(textInput, 2)
    }


    private fun convertDecimalIntegerToNumberSystem(input: String): String {
        val decimalValue = input.toInt()
        return when (numberSys) {
            NumberSystem.DECIMAL -> decimalValue.toString()
            NumberSystem.HEXADECIMAL -> Integer.toHexString(decimalValue)
            NumberSystem.BINARY -> Integer.toBinaryString(decimalValue)
            NumberSystem.OCTAL -> Integer.toOctalString(decimalValue)
        }
    }

    private fun convertToNumberSystems(textInput: String) {
        when (numberSys) {
            NumberSystem.HEXADECIMAL -> {
                val decimal = textInput.toInt(16)
                convertDecimalToNumberSystems(decimal)

            }

            NumberSystem.DECIMAL -> {
                val decimal = textInput.toInt()
                convertDecimalToNumberSystems(decimal)
            }
            NumberSystem.OCTAL -> {
                val decimal = textInput.toInt(8)
                convertDecimalToNumberSystems(decimal)

            }
            NumberSystem.BINARY -> {
                val decimal = textInput.toInt(2)
                convertDecimalToNumberSystems(decimal)

            }
        }

    }

    private fun convertDecimalToNumberSystems(decimal: Int) {
        binding.tvHex.text = decimal.toUInt().toString(16)
            .uppercase()
        binding.tvDec.text = decimal.toString()
        binding.tvOct.text = decimal.toUInt().toString(8)
        binding.tvBin.text = decimal.toUInt().toString(2)
    }


    private fun enableHexadecimalInput() {
        enableAlphabeticsButtons()
        enable2to9Buttons()

        binding.tvLineHex.visibility = View.VISIBLE
        binding.tvLineDec.visibility = View.GONE
        binding.tvLineOct.visibility = View.GONE
        binding.tvLineBin.visibility = View.GONE
    }

    private fun enableDecimalInput() {
        disableAlphabeticsButtons()
        enable2to9Buttons()
        binding.tvLineHex.visibility = View.GONE
        binding.tvLineDec.visibility = View.VISIBLE
        binding.tvLineOct.visibility = View.GONE
        binding.tvLineBin.visibility = View.GONE
    }

    private fun enableOctalInput() {
        disableAlphabeticsButtons()
        enable2to9Buttons()
        disable89Buttons()
        binding.tvLineHex.visibility = View.GONE
        binding.tvLineDec.visibility = View.GONE
        binding.tvLineOct.visibility = View.VISIBLE
        binding.tvLineBin.visibility = View.GONE
    }

    private fun enableBinaryInput() {
        disableAlphabeticsButtons()
        disable2to9Buttons()
        binding.tvLineHex.visibility = View.GONE
        binding.tvLineDec.visibility = View.GONE
        binding.tvLineOct.visibility = View.GONE
        binding.tvLineBin.visibility = View.VISIBLE
    }


    private fun enableAlphabeticsButtons() {
        binding.btnA.isEnabled = true
        binding.btnB.isEnabled = true
        binding.btnC.isEnabled = true
        binding.btnD.isEnabled = true
        binding.btnE.isEnabled = true
        binding.btnF.isEnabled = true



        binding.btnA.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btnB.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btnC.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btnD.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btnE.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btnF.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))

    }

    private fun disableAlphabeticsButtons() {
        binding.btnA.isEnabled = false
        binding.btnB.isEnabled = false
        binding.btnC.isEnabled = false
        binding.btnD.isEnabled = false
        binding.btnE.isEnabled = false
        binding.btnF.isEnabled = false

        binding.btnA.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btnB.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btnC.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btnD.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btnE.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btnF.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
    }

    private fun disable89Buttons() {
        binding.btn8.isEnabled = false
        binding.btn9.isEnabled = false

        binding.btn8.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btn9.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
    }

    private fun enable2to9Buttons() {
        binding.btn2.isEnabled = true
        binding.btn3.isEnabled = true
        binding.btn4.isEnabled = true
        binding.btn5.isEnabled = true
        binding.btn6.isEnabled = true
        binding.btn7.isEnabled = true
        binding.btn8.isEnabled = true
        binding.btn9.isEnabled = true


        binding.btn2.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btn3.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btn4.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btn5.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btn6.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btn7.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btn8.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
        binding.btn9.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.plum))
    }

    private fun disable2to9Buttons() {
        binding.btn2.isEnabled = false
        binding.btn3.isEnabled = false
        binding.btn4.isEnabled = false
        binding.btn5.isEnabled = false
        binding.btn6.isEnabled = false
        binding.btn7.isEnabled = false
        binding.btn8.isEnabled = false
        binding.btn9.isEnabled = false

        binding.btn2.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btn3.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btn4.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btn5.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btn6.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btn7.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btn8.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
        binding.btn9.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(this, R.color.eerie_black))
    }


}

