package com.like.news

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**

 * 作者：like on 2018/7/31 17:29

 * 邮箱：like@tydic.com

 * 描述：

 */
class MyApplication : Application() {

    companion object {
        var context: Context by Delegates.notNull()
            private set
    }



    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}