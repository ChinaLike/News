package com.like.news.utils

import com.google.gson.Gson

/**

 * 作者：like on 2018/8/1 11:16

 * 邮箱：like@tydic.com

 * 描述：类型转换

 */

class TypeConversion(){

    companion object {
        inline fun <reified T> str2Obj(value : String, type : T) : T{
            return Gson().fromJson(value,T::class.java)
        }
    }

}