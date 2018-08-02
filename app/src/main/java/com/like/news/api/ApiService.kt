package com.like.news.api

import com.like.news.base.BaseBean
import com.like.news.mvp.model.bean.PublicNews
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**

 * 作者：like on 2018/8/2 10:28

 * 邮箱：like@tydic.com

 * 描述：接口

 */

interface ApiService{

    @GET("2/statuses/public_timeline.json")
    fun getPublicTimeLine(@Query("count") count : Int , @Query("page") page : Int , @Query("base_app") baseApp : Int) : Observable<BaseBean<PublicNews>>

}