package com.like.news.base

import java.io.Serializable

/**

 * 作者：like on 2018/8/2 15:17

 * 邮箱：like@tydic.com

 * 描述：数据基类

 */

data class BaseBean<T>(
        val statuses : ArrayList<T>,
        val hasvisible : Boolean,
        val previous_cursor : Int,
        val next_cursor : Int,
        val total_number : Int,
        val interval : Int
) : Serializable