package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var result = 0
        var prevResult = 0
        var numberSys = NumberSystem.DEC
        var isCalculate = false
        var operator: Operator? = null
        var lastInput = 0
        decInput()


        //region number system buttons
        binding.btnHex.setOnClickListener {
            hexInput()
        }
        binding.btnOct.setOnClickListener {
            octInput()
        }
        binding.btnDec.setOnClickListener {
            decInput()
        }
        binding.btnBin.setOnClickListener {
            binInput()
        }
        //endregion

        //region input buttons
        binding.btn1.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "1"
            binding.tvInput.text = textInput
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
        }

        binding.btnA.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "A"
            binding.tvInput.text = textInput
        }

        binding.btnB.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "B"
            binding.tvInput.text = textInput
        }

        binding.btnC.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "C"
            binding.tvInput.text = textInput
        }

        binding.btnD.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "D"
            binding.tvInput.text = textInput
        }

        binding.btnE.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "E"
            binding.tvInput.text = textInput
        }

        binding.btnF.setOnClickListener {
            var input = binding.tvInput.text.toString()
            if (input == "0") input = ""
            if (isCalculate) {
                input = ""
                isCalculate = false
            }
            val textInput = input + "F"
            binding.tvInput.text = textInput
        }
        //endregion

        binding.btnPlus.setOnClickListener {
            val textInput = binding.tvInput.text.toString()
            val textInputPlus = binding.tvExp.text.toString()
            var input = ""
            if (!isCalculate) {
                result = textInput.toInt()
                input = "$textInputPlus$textInput + "
                prevResult += result

            } else {
                input = "$prevResult + "
            }
            binding.tvExp.text = input
            binding.tvInput.text = prevResult.toString()

            operator = Operator.ADD
            isCalculate = true
        }
        binding.btnSub.setOnClickListener {
            val textInput = binding.tvInput.text.toString()
            val textInputPlus = binding.tvExp.text.toString()
            var input = ""
            if (!isCalculate) {
                result = textInput.toInt()
                input = "$textInputPlus$textInput - "
                prevResult -= result

            } else {
                input = "$prevResult - "
            }
            binding.tvExp.text = input
            binding.tvInput.text = prevResult.toString()

            operator = Operator.SUB
            isCalculate = true
        }
        binding.btnMlti.setOnClickListener {
            val textInput = binding.tvInput.text.toString()
            val textInputPlus = binding.tvExp.text.toString()
            var input = ""
            if (!isCalculate) {
                result = textInput.toInt()
                input = "$textInputPlus$textInput * "
                prevResult *= result

            } else {
                input = "$prevResult * "
            }
            binding.tvExp.text = input
            binding.tvInput.text = prevResult.toString()

            operator = Operator.MLTI
            isCalculate = true
        }
        binding.btnDiv.setOnClickListener {
            val textInput = binding.tvInput.text.toString()
            val textInputPlus = binding.tvExp.text.toString()
            var input = ""
            if (!isCalculate) {
                result = textInput.toInt()
                input = "$textInputPlus$textInput / "
                prevResult /= result

            } else {
                input = "$prevResult / "
            }
            binding.tvExp.text = input
            binding.tvInput.text = prevResult.toString()

            operator = Operator.DIV
            isCalculate = true
        }

        binding.btnEql.setOnClickListener {
            val textInput = binding.tvInput.text.toString()
            result = textInput.toInt()
            var operationText = ""
            if (isCalculate) {

                when (operator) {
                    Operator.ADD -> {
                        operationText = "$lastInput + $prevResult ="
                        prevResult += lastInput
                    }
                    Operator.DIV -> {
                        operationText = "$lastInput / $prevResult ="
                        prevResult /= lastInput
                    }
                    Operator.SUB -> {
                        operationText = "$lastInput - $prevResult ="
                        prevResult -= lastInput
                    }
                    Operator.MLTI -> {
                        operationText = "$lastInput * $prevResult ="
                        prevResult *= lastInput
                    }

                    else -> {
                        operationText = "$lastInput ="
                    }
                }

            } else {

                lastInput = prevResult
                when (operator) {
                    Operator.ADD -> {
                        operationText = "$prevResult + $result ="
                        prevResult += result
                    }
                    Operator.DIV -> {
                        operationText = "$prevResult / $result ="
                        prevResult /= result
                    }
                    Operator.SUB -> {
                        operationText = "$prevResult - $result ="
                        prevResult -= result
                    }
                    Operator.MLTI -> {
                        operationText = "$prevResult * $result ="
                        prevResult *= result
                    }

                    else -> {
                        operationText = "$result ="
                    }
                }
            }
            isCalculate = true
            binding.tvExp.text = operationText
            binding.tvInput.text = prevResult.toString()

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

