package com.like.news.mvp.contract

import com.like.news.base.IBaseView
import com.like.news.base.IPresenter
import com.like.news.mvp.model.bean.PublicNews

/**

 * 作者：like on 2018/8/2 14:59

 * 邮箱：like@tydic.com

 * 描述：

 */
interface HomeContract {

    interface View : IBaseView{
        //设置公共微博
        fun setPublicNews(list : ArrayList<PublicNews>)
    }

    interface Presenter : IPresenter<View>{
        //获取公共微博
        fun requestPublicTimeLine(count : Int, page : Int, baseApp : Int)
    }

}