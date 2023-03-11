package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var numberSys = NumberSystem.DECIMAL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var result: Int
        var prevResult = 0
        var isCalculate = false
        var operator: Operator? = null
        var lastInput = 0
        decInput()


        //region number system buttons
        binding.btnHex.setOnClickListener {
            numberSys = NumberSystem.HEXADECIMAL
            binding.tvInput.text = binding.tvHex.text
            binding.tvExp.text = ""
            hexInput()
        }
        binding.btnOct.setOnClickListener {
            numberSys = NumberSystem.OCTAL
            binding.tvInput.text = binding.tvOct.text
            binding.tvExp.text = ""
            octInput()
        }
        binding.btnDec.setOnClickListener {
            numberSys = NumberSystem.DECIMAL
            binding.tvInput.text = binding.tvDec.text
            binding.tvExp.text = ""
            decInput()
        }
        binding.btnBin.setOnClickListener {
            numberSys = NumberSystem.BINARY
            binding.tvInput.text = binding.tvBin.text
            binding.tvExp.text = ""
            binInput()
        }
        //endregion

        //region input buttons
        binding.btn0.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "0"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }
        binding.btn1.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "1"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btn2.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "2"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btn3.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "3"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btn4.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "4"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btn5.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "5"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btn6.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "6"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btn7.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "7"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btn8.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "8"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btn9.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "9"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btnA.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "a"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btnB.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "b"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btnC.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "c"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btnD.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "d"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btnE.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "e"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }

        binding.btnF.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "f"
            binding.tvInput.text = textInput

            convertToNumberSystems(textInput)
        }
        //endregion

//        binding.btnPlus.setOnClickListener {
//            val textInput = binding.tvInput.text.toString()
//            val textInputPlus = binding.tvExp.text.toString()
//            val input: String
//            if (!isCalculate) {
//                result = textInput.toInt()
//                input = "$textInputPlus$textInput + "
//                prevResult += result
//
//            } else {
//                input = "$prevResult + "
//            }
//            binding.tvExp.text = input
//            binding.tvInput.text = prevResult.toString()
//
//            convertToNumberSystems(prevResult.toString(), numberSys)
//
//
//            operator = Operator.ADD
//            isCalculate = true
//        }

        binding.btnPlus.setOnClickListener {
            val textInput = when (numberSys) {
                NumberSystem.HEXADECIMAL -> Integer.parseInt(binding.tvInput.text.toString(), 16)
                NumberSystem.DECIMAL -> binding.tvInput.text.toString().toInt()
                NumberSystem.OCTAL -> Integer.parseInt(binding.tvInput.text.toString(), 8)
                NumberSystem.BINARY -> Integer.parseInt(binding.tvInput.text.toString(), 2)
            }
            val textInputPlus = binding.tvExp.text.toString()
            val input = if (isCalculate) {
                when (numberSys) {
                    NumberSystem.HEXADECIMAL -> "${prevResult.toUInt().toString(16)} + "
                    NumberSystem.DECIMAL -> "$prevResult + "
                    NumberSystem.OCTAL -> "${prevResult.toUInt().toString(8)} + "
                    NumberSystem.BINARY -> "${prevResult.toUInt().toString(2)} + "
                }
            } else "$textInputPlus${binding.tvInput.text}+ "
            prevResult += textInput


            binding.tvExp.text = input
            binding.tvInput.text = convertToNumberSystems2(prevResult.toString())

            convertToNumberSystems(binding.tvInput.text.toString())
            operator = Operator.ADD
            isCalculate = true
        }

        binding.btnSub.setOnClickListener {
            val textInput = when (numberSys) {
                NumberSystem.HEXADECIMAL -> Integer.parseInt(binding.tvInput.text.toString(), 16)
                NumberSystem.DECIMAL -> binding.tvInput.text.toString().toInt()
                NumberSystem.OCTAL -> Integer.parseInt(binding.tvInput.text.toString(), 8)
                NumberSystem.BINARY -> Integer.parseInt(binding.tvInput.text.toString(), 2)
            }
            val textInputPlus = binding.tvExp.text.toString()
            val input = if (isCalculate) {
                when (numberSys) {
                    NumberSystem.HEXADECIMAL -> "${prevResult.toUInt().toString(16)} - "
                    NumberSystem.DECIMAL -> "$prevResult - "
                    NumberSystem.OCTAL -> "${prevResult.toUInt().toString(8)} - "
                    NumberSystem.BINARY -> "${prevResult.toUInt().toString(2)} - "
                }
            } else "$textInputPlus${binding.tvInput.text}- "
            prevResult -= textInput


            binding.tvExp.text = input
            binding.tvInput.text = convertToNumberSystems2(prevResult.toString())

            convertToNumberSystems(binding.tvInput.text.toString())
            operator = Operator.SUB
            isCalculate = true
        }


        binding.btnMlti.setOnClickListener {
            val textInput = when (numberSys) {
                NumberSystem.HEXADECIMAL -> Integer.parseInt(binding.tvInput.text.toString(), 16)
                NumberSystem.DECIMAL -> binding.tvInput.text.toString().toInt()
                NumberSystem.OCTAL -> Integer.parseInt(binding.tvInput.text.toString(), 8)
                NumberSystem.BINARY -> Integer.parseInt(binding.tvInput.text.toString(), 2)
            }
            val textInputPlus = binding.tvExp.text.toString()
            val input = if (isCalculate) {
                when (numberSys) {
                    NumberSystem.HEXADECIMAL -> "${prevResult.toUInt().toString(16)} × "
                    NumberSystem.DECIMAL -> "$prevResult × "
                    NumberSystem.OCTAL -> "${prevResult.toUInt().toString(8)} × "
                    NumberSystem.BINARY -> "${prevResult.toUInt().toString(2)} × "
                }
            } else "$textInputPlus${binding.tvInput.text}× "
            prevResult *= textInput


            binding.tvExp.text = input
            binding.tvInput.text = convertToNumberSystems2(prevResult.toString())

            convertToNumberSystems(binding.tvInput.text.toString())
            operator = Operator.MLTI
            isCalculate = true
        }
        binding.btnDiv.setOnClickListener {
            val textInput = when (numberSys) {
                NumberSystem.HEXADECIMAL -> Integer.parseInt(binding.tvInput.text.toString(), 16)
                NumberSystem.DECIMAL -> binding.tvInput.text.toString().toInt()
                NumberSystem.OCTAL -> Integer.parseInt(binding.tvInput.text.toString(), 8)
                NumberSystem.BINARY -> Integer.parseInt(binding.tvInput.text.toString(), 2)
            }
            val textInputPlus = binding.tvExp.text.toString()
            val input = if (isCalculate) {
                when (numberSys) {
                    NumberSystem.HEXADECIMAL -> "${prevResult.toUInt().toString(16)} / "
                    NumberSystem.DECIMAL -> "$prevResult × "
                    NumberSystem.OCTAL -> "${prevResult.toUInt().toString(8)} / "
                    NumberSystem.BINARY -> "${prevResult.toUInt().toString(2)} / "
                }
            } else "$textInputPlus${binding.tvInput.text}/ "
            prevResult /= textInput


            binding.tvExp.text = input
            binding.tvInput.text = convertToNumberSystems2(prevResult.toString())

            convertToNumberSystems(binding.tvInput.text.toString())
            operator = Operator.DIV
            isCalculate = true
        }

//        binding.btnEql.setOnClickListener {
//            val textInput = binding.tvInput.text.toString()
//            result = textInput.toInt()
//            val operationText: String
//            if (isCalculate) {
//
//                when (operator) {
//                    Operator.ADD -> {
//                        operationText = "$lastInput + $prevResult ="
//                        prevResult += lastInput
//                    }
//                    Operator.DIV -> {
//                        operationText = "$lastInput / $prevResult ="
//                        prevResult /= lastInput
//                    }
//                    Operator.SUB -> {
//                        operationText = "$lastInput - $prevResult ="
//                        prevResult -= lastInput
//                    }
//                    Operator.MLTI -> {
//                        operationText = "$lastInput * $prevResult ="
//                        prevResult *= lastInput
//                    }
//
//                    else -> {
//                        operationText = "$lastInput ="
//                    }
//                }
//
//            } else {
//
//                lastInput = prevResult
//                when (operator) {
//                    Operator.ADD -> {
//                        operationText = "$prevResult + $result ="
//                        prevResult += result
//                    }
//                    Operator.DIV -> {
//                        operationText = "$prevResult / $result ="
//                        prevResult /= result
//                    }
//                    Operator.SUB -> {
//                        operationText = "$prevResult - $result ="
//                        prevResult -= result
//                    }
//                    Operator.MLTI -> {
//                        operationText = "$prevResult * $result ="
//                        prevResult *= result
//                    }
//
//                    else -> {
//                        operationText = "$result ="
//                    }
//                }
//            }
//            convertToNumberSystems(prevResult.toString())
//            isCalculate = true
//            binding.tvExp.text = operationText
//            binding.tvInput.text = prevResult.toString()
//
//        }

        binding.btnEql.setOnClickListener {
            val textInput = binding.tvInput.text.toString()
            val inputValue = when (numberSys) {
                NumberSystem.HEXADECIMAL -> Integer.parseInt(textInput, 16)
                NumberSystem.DECIMAL -> textInput.toInt()
                NumberSystem.OCTAL -> Integer.parseInt(textInput, 8)
                NumberSystem.BINARY -> Integer.parseInt(textInput, 2)
            }

            val operationText: String
            if (isCalculate) {
                when (operator) {
                    Operator.ADD -> {
                        operationText = "${convertToNumberSystems2(lastInput.toString())} + ${
                            convertToNumberSystems2(prevResult.toString())
                        } ="
                        prevResult += lastInput
                    }
                    Operator.DIV -> {
                        operationText = "${convertToNumberSystems2(lastInput.toString())} / ${
                            convertToNumberSystems2(prevResult.toString())
                        } ="
                        prevResult /= lastInput
                    }
                    Operator.SUB -> {
                        operationText = "${convertToNumberSystems2(lastInput.toString())} - ${
                            convertToNumberSystems2(prevResult.toString())
                        } ="
                        prevResult -= lastInput
                    }
                    Operator.MLTI -> {
                        operationText = "${convertToNumberSystems2(lastInput.toString())} * ${
                            convertToNumberSystems2(prevResult.toString())
                        } ="
                        prevResult *= lastInput
                    }
                    else -> {
                        operationText = "${convertToNumberSystems2(lastInput.toString())} ="
                    }
                }
            } else {
                lastInput = prevResult
                when (operator) {
                    Operator.ADD -> {
                        operationText =
                            "${convertToNumberSystems2(prevResult.toString())} + $textInput ="
                        prevResult += inputValue
                    }
                    Operator.DIV -> {
                        operationText =
                            "${convertToNumberSystems2(prevResult.toString())} / $textInput ="
                        prevResult /= inputValue
                    }
                    Operator.SUB -> {
                        operationText =
                            "${convertToNumberSystems2(prevResult.toString())} - $textInput ="
                        prevResult -= inputValue
                    }
                    Operator.MLTI -> {
                        operationText =
                            "${convertToNumberSystems2(prevResult.toString())} * $textInput ="
                        prevResult *= inputValue
                    }
                    else -> {
                        operationText = "$textInput ="
                    }
                }
            }

            convertToNumberSystems(binding.tvInput.text.toString())
            isCalculate = true
            binding.tvExp.text = operationText
            binding.tvInput.text = convertToNumberSystems2(prevResult.toString())
        }


        binding.btnClr.setOnClickListener {
            binding.tvExp.text = ""
            binding.tvInput.text = "0"
            prevResult = 0
            lastInput = 0
            result = 0
            isCalculate = false
            operator = null
        }

    }


    private fun convertToNumberSystems2(input: String): String {
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
                binding.tvHex.text = decimal.toUInt().toString(16)
                binding.tvDec.text = decimal.toString()
                binding.tvOct.text = decimal.toUInt().toString(8)
                binding.tvBin.text = decimal.toUInt().toString(2)

            }
            NumberSystem.DECIMAL -> {
                val decimal = textInput.toInt()
                binding.tvHex.text = decimal.toUInt().toString(16)
                binding.tvDec.text = decimal.toString()
                binding.tvOct.text = decimal.toUInt().toString(8)
                binding.tvBin.text = decimal.toUInt().toString(2)
            }
            NumberSystem.OCTAL -> {
                val decimal = textInput.toInt(8)
                binding.tvHex.text = decimal.toUInt().toString(16)
                binding.tvDec.text = decimal.toString()
                binding.tvOct.text = decimal.toUInt().toString(8)
                binding.tvBin.text = decimal.toUInt().toString(2)

            }
            NumberSystem.BINARY -> {
                val decimal = textInput.toInt(2)
                binding.tvHex.text = decimal.toUInt().toString(16)
                binding.tvDec.text = decimal.toString()
                binding.tvOct.text = decimal.toUInt().toString(8)
                binding.tvBin.text = decimal.toUInt().toString(2)

            }
        }


    }


    private fun hexInput() {
        enableAlpha()
        enable2to9()
    }

    private fun decInput() {
        disableAlpha()
        enable2to9()
    }

    private fun octInput() {
        disableAlpha()
        enable2to9()
        disable89()
    }

    private fun binInput() {
        disableAlpha()
        disable2to9()
    }


    private fun enableAlpha() {
        binding.btnA.isEnabled = true
        binding.btnB.isEnabled = true
        binding.btnC.isEnabled = true
        binding.btnD.isEnabled = true
        binding.btnE.isEnabled = true
        binding.btnF.isEnabled = true
    }

    private fun disableAlpha() {
        binding.btnA.isEnabled = false
        binding.btnB.isEnabled = false
        binding.btnC.isEnabled = false
        binding.btnD.isEnabled = false
        binding.btnE.isEnabled = false
        binding.btnF.isEnabled = false
    }

    private fun disable89() {
        binding.btn8.isEnabled = false
        binding.btn9.isEnabled = false
    }

    private fun enable2to9() {
        binding.btn2.isEnabled = true
        binding.btn3.isEnabled = true
        binding.btn4.isEnabled = true
        binding.btn5.isEnabled = true
        binding.btn6.isEnabled = true
        binding.btn7.isEnabled = true
        binding.btn8.isEnabled = true
        binding.btn9.isEnabled = true
    }

    private fun disable2to9() {
        binding.btn2.isEnabled = false
        binding.btn3.isEnabled = false
        binding.btn4.isEnabled = false
        binding.btn5.isEnabled = false
        binding.btn6.isEnabled = false
        binding.btn7.isEnabled = false
        binding.btn8.isEnabled = false
        binding.btn9.isEnabled = false
    }


}

