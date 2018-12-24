package com.wrbug.developerhelper.model.entity

import com.wrbug.developerhelper.util.*

class SharedPreferenceItemInfo {
    var key: String = ""
    var value = ""
    var type = "string"
    var newValue = ""


    fun isValueValid(): Boolean {
        when (type.toLowerCase()) {
            "string" -> {
                return JsonHelper.fromJson(value) == null || JsonHelper.fromJson(newValue) != null
            }
            "int" -> {
                return newValue.isInt()
            }
            "long" -> {
                return newValue.isNumber()

            }

            "boolean" -> {
                return newValue.isBoolean()

            }
            "float" -> {
                return newValue.isDecimal()
            }
            else -> return true
        }

    }
}