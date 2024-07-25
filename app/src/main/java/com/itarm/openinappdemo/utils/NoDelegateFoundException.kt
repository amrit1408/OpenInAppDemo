package com.itarm.openinappdemo.utils

import com.itarm.openinappdemo.R
import com.itarm.openinappdemo.app.AppControllerContract

class NoDelegateFoundException(private val item: Int, private val errorClass: String) :
    Exception() {
    val context = AppControllerContract.instance.properContext
    override val message: String
        get() = context.getString(R.string.no_delegate_found_for_the_view_type_in, item, errorClass)
}