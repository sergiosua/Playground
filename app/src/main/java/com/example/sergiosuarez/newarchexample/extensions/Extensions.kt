package com.example.sergiosuarez.newarchexample.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


//CONTEXT
fun Context.inflate(viewType: Int, parent: ViewGroup) = LayoutInflater.from(this).inflate(viewType, parent, false)!!

fun Context?.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) =
    this?.let { Toast.makeText(this, text, duration).show() }

//VIEW GROUP
fun ViewGroup.inflate(viewType: Int): View = LayoutInflater.from(context).inflate(viewType, this, false)
