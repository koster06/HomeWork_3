package com.example.homework3

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // 4 поля ввода
    var etName: EditText? = null
    var etSurname: EditText? = null
    var etPhone: EditText? = null
    var etAge: EditText? = null

    // one login button
    var bBTN1: Button? = null

    // implement-ирую TextWatcher
    private val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            // получаею текст со всех полей
            val nameFilled = etName!!.text.toString()
            val surnameFilled = etSurname!!.text.toString()
            val phoneFilled = etPhone!!.text.toString()
            val ageFilled = etAge!!.text.toString()

            // проверяю пусты поля или нет
            bBTN1?.setEnabled(!nameFilled.isEmpty() && !surnameFilled.isEmpty() && !phoneFilled.isEmpty() && !ageFilled.isEmpty())
        }

        override fun afterTextChanged(s: Editable) {}
    }

    //@SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // связываю переменные с полями ввода и кнопкой

        etName = findViewById(R.id.editTextTextPersonName)
        etSurname = findViewById(R.id.editTextTextPersonSurname)
        etPhone = findViewById(R.id.editTextPhone)
        etAge = findViewById(R.id.editTextAge)
        bBTN1 = findViewById(R.id.button)
        var textView: TextView = findViewById(R.id.textView)

        // поставил TextChangeListener для всех полей

        this.etName?.addTextChangedListener(textWatcher)
        this.etSurname?.addTextChangedListener(textWatcher)
        this.etPhone?.addTextChangedListener(textWatcher)
        this.etAge?.addTextChangedListener(textWatcher)

        bBTN1?.setOnClickListener {
            textView.text = "Name: ${etName?.text}| Surname: ${etSurname?.text}| Phone: ${etPhone?.text}| Age: ${etAge?.text}"
        }

    }
}

