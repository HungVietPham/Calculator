package com.pvh98.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.act_main.*
import kotlinx.android.synthetic.main.frg_calculator.*

class CalculatorFrg : Fragment(), View.OnClickListener {
    var onOpeDecimal = false
    var mValueOne = 0.0f
    var mValueTwo = 0.0f
    var mOpeAdd = false
    var mOpeSub = false
    var mOpeMul = false
    var mOpeDiv = false
    var mOpeEucDiv = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frg_calculator, frg_calculator, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        bt_zero.setOnClickListener(this)
        bt_one.setOnClickListener(this)
        bt_two.setOnClickListener(this)
        bt_three.setOnClickListener(this)
        bt_four.setOnClickListener(this)
        bt_five.setOnClickListener(this)
        bt_six.setOnClickListener(this)
        bt_seven.setOnClickListener(this)
        bt_eight.setOnClickListener(this)
        bt_nine.setOnClickListener(this)
        bt_dot.setOnClickListener(this)
        bt_delete.setOnClickListener(this)
        bt_deleteAll.setOnClickListener(this)
        bt_add.setOnClickListener(this)
        bt_minus.setOnClickListener(this)
        bt_mutiple.setOnClickListener(this)
        bt_divide.setOnClickListener(this)
        bt_euclidDivide.setOnClickListener(this)
        bt_equal.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_one -> {
                onDigit("1")

            }

            R.id.bt_two -> {
                onDigit("2")
            }

            R.id.bt_three -> {
                onDigit("3")
            }

            R.id.bt_four -> {
                onDigit("4")
            }

            R.id.bt_five -> {
                onDigit("5")
            }

            R.id.bt_six -> {
                onDigit("6")
            }

            R.id.bt_seven -> {
                onDigit("7")
            }

            R.id.bt_eight -> {
                onDigit("8")
            }

            R.id.bt_nine -> {
                onDigit("9")
            }

            R.id.bt_zero -> {
                onDigit("0")
            }

            R.id.bt_dot -> {
                onDecimal()
            }

            R.id.bt_deleteAll -> {
                onClear()
            }

            R.id.bt_delete -> {
                onDelete()
            }

            R.id.bt_add -> {
                if (tv_result.text.toString().length != 0) {
                    mOpeAdd = true
                    onOpeDecimal = false
                    onValueOne()
                }
            }

            R.id.bt_minus -> {
                if (tv_result.text.toString().length != 0) {
                    mOpeSub = true
                    onOpeDecimal = false
                    onValueOne()
                }
            }

            R.id.bt_mutiple -> {
                if (tv_result.text.toString().length != 0) {


                    mOpeMul = true
                    onOpeDecimal = false
                    onValueOne()
                }
            }

            R.id.bt_divide -> {
                if (tv_result.text.toString().length != 0) {
                    mOpeDiv = true
                    onOpeDecimal = false
                    onValueOne()
                }
            }

            R.id.bt_euclidDivide -> {
                if (tv_result.text.toString().length != 0) {
                    mOpeEucDiv = true
                    onOpeDecimal = false
                    onValueOne()
                }
            }

            R.id.bt_equal -> {

                if (mOpeAdd) {
                    mValueTwo = tv_result.text.toString().toFloat()
                    tv_result.text = (mValueOne + mValueTwo).toString()
                    mOpeAdd = false
                }
                if (mOpeSub) {
                    mValueTwo = tv_result.text.toString().toFloat()
                    tv_result.text = (mValueOne - mValueTwo).toString()
                    mOpeSub = false
                }
                if (mOpeMul) {
                    mValueTwo = tv_result.text.toString().toFloat()
                    tv_result.text = (mValueOne * mValueTwo).toString()
                    mOpeMul = false
                }
                if (mOpeDiv) {
                    mValueTwo = tv_result.text.toString().toFloat()
                    tv_result.text = (mValueOne / mValueTwo).toString()
                    mOpeDiv = false
                }
                if (mOpeEucDiv) {
                    tv_result.text = (mValueOne % mValueTwo).toString()
                    mOpeEucDiv = false
                }
            }
        }
    }

    private fun onDecimal() {
        if (onOpeDecimal) {
        } else {
            tv_result.text = tv_result.text.toString() + "."
            onOpeDecimal = true
        }

    }

    private fun onDelete() {
        var num = tv_result.text.toString().length
        var del = tv_result.text.toString().substring(0, num - 1)
        tv_result.text = del
    }

    private fun onClear() {
        tv_result.text = ""
        mValueOne = 0F
        mValueTwo = 0F
    }


    private fun onValueOne() {
        mValueOne = tv_result.text.toString().toFloat()
        tv_result.text = null
    }

    private fun onDigit(s: String) {
        tv_result.text = tv_result.text.toString() + s
    }


}