package com.like.news.ui.fragment

import android.os.Bundle
import android.view.View
import com.like.news.R
import com.like.news.base.BaseFragment

/**

 * 作者：like on 2018/8/1 14:39

 * 邮箱：like@tydic.com

 * 描述：我的界面

 */
class MineFragment : BaseFragment(){

    companion object {
        fun getInstance(title : String) : MineFragment{
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun init(view: View, savedInstanceState: Bundle?) {

    }

}