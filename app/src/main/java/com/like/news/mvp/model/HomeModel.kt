package com.like.news.mvp.model

import com.hazz.kotlinmvp.rx.scheduler.SchedulerUtils
import com.like.news.base.BaseBean
import com.like.news.helper.RetrofitHelper
import com.like.news.mvp.model.bean.PublicNews
import io.reactivex.Observable

/**

 * 作者：like on 2018/8/2 10:47

 * 邮箱：like@tydic.com

 * 描述：首页Model

 */
class HomeModel {

    /**
     * 获取公共微博
     */
    fun requestPublicTimeLine(count : Int, page : Int, baseApp : Int) : Observable<BaseBean<PublicNews>> {
        return RetrofitHelper.service.getPublicTimeLine(count,page,baseApp).compose(SchedulerUtils.ioToMain())
    }

}