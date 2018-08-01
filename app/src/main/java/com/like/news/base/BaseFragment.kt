package com.like.news.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**

 * 作者：like on 2018/8/1 14:41

 * 邮箱：like@tydic.com

 * 描述：Fragment基类

 */
abstract class BaseFragment : Fragment(){

    protected var mTitle:String? =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(layoutId(),null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view,savedInstanceState)
    }

    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun layoutId() : Int

    /**
     * 初始化数据
     */
    abstract fun init(view: View, savedInstanceState: Bundle?)

}