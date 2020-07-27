package com.sahil.articles.util

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StyleRes
import com.sahil.articles.R
import java.text.DecimalFormat
import java.text.NumberFormat

/**
 * Created by sm28092 on 27/07/2020
 */
object NumberFormatUtil {

    @SuppressLint("ResourceType")
    fun format(value: Double, @StyleRes prefix: Int, context:Context): String {
        var value = value
        val power: Int
        val suffix = " KMBT"
        var formattedNumber = ""
        val formatter: NumberFormat = DecimalFormat("#,###.#")
        power = StrictMath.log10(value).toInt()
        value /= Math.pow(10.0, power / 3 * 3.toDouble())
        formattedNumber = formatter.format(value)
        formattedNumber += suffix[power / 3]
        var returnValue =  if (formattedNumber.length > 4){
            formattedNumber.replace("\\.[0-9]+".toRegex(),"")
        } else {
            formattedNumber
        }

        return returnValue + " " + context.resources.getString(prefix)

    }
}