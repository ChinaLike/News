package com.like.news.ui.fragment

import android.os.Bundle
import android.view.View
import com.like.news.R
import com.like.news.base.BaseFragment

/**

 * 作者：like on 2018/8/1 14:39

 * 邮箱：like@tydic.com

 * 描述：主页

 */
class HomeFragment : BaseFragment(){

    companion object {
        fun getInstance(title : String) : HomeFragment{
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_home
    }

    override fun init(view: View, savedInstanceState: Bundle?) {

    }

}