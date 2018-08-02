package com.like.news.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.like.news.R
import com.like.news.base.BaseFragment
import com.like.news.mvp.contract.HomeContract
import com.like.news.mvp.model.bean.PublicNews
import com.like.news.mvp.presenter.HomePresenter

/**

 * 作者：like on 2018/8/1 14:39

 * 邮箱：like@tydic.com

 * 描述：主页

 */
class HomeFragment : BaseFragment() , HomeContract.View{

    private val mPresenter by lazy { HomePresenter() }

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
        mPresenter.attachView(this)
        mPresenter.requestPublicTimeLine(50,1,0)
    }


    override fun setPublicNews(list: ArrayList<PublicNews>) {

    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.datachView()
    }

}