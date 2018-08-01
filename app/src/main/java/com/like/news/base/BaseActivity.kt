package com.like.news.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**

 * 作者：like on 2018/7/30 17:10

 * 邮箱：like@tydic.com

 * 描述：基类Activity，处理一些公共参数

 */

abstract class BaseActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        init(savedInstanceState)
    }

    abstract fun layoutId():Int

    abstract fun init(savedInstanceState: Bundle?)

}