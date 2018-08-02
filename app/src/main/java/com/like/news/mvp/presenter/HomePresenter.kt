package com.like.news.mvp.presenter

import android.util.Log
import com.like.news.base.BasePresenter
import com.like.news.mvp.contract.HomeContract
import com.like.news.mvp.model.HomeModel

/**

 * 作者：like on 2018/8/2 14:49

 * 邮箱：like@tydic.com

 * 描述：首页Presenter

 */

class HomePresenter :BasePresenter<HomeContract.View>(),HomeContract.Presenter{

    private val homeModel: HomeModel by lazy {
        HomeModel()
    }

    /**
     * 获取公共微博
     */
    override fun requestPublicTimeLine(count: Int, page: Int, baseApp: Int) {
        //先检测是否绑定View
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = homeModel.requestPublicTimeLine(count,page,baseApp)
                .subscribe { it ->
                    mRootView?.apply {
                        dismissLoading()
                        setPublicNews(it.statuses)
                    }
                }
        addSubscription(disposable)
    }

}