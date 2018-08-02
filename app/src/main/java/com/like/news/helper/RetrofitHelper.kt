package com.like.news.helper

import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.ShareSDK
import cn.sharesdk.sina.weibo.SinaWeibo
import com.like.news.MyApplication
import com.like.news.api.ApiService
import com.like.news.api.Config
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**

 * 作者：like on 2018/8/2 10:50

 * 邮箱：like@tydic.com

 * 描述：Retroffit 管理类

 */
object RetrofitHelper {


    private var retrofit: Retrofit? = null
    private var client: OkHttpClient? = null

    val service : ApiService by lazy { getRetrofit()!!.create(ApiService::class.java) }

    /**
     * 获取token,特殊应用这里获取方式不一样
     */
    private fun getToken() : String{
        val weibo : Platform = ShareSDK.getPlatform(SinaWeibo.NAME)
        return weibo!!.db.token
    }

    /**
     * 设置公共参数,拦截参数
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
//                    .addQueryParameter("phoneSystem", "")
                    .addQueryParameter("access_token", getToken())
                    .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }

    /**
     * 添加header信息处
     */
    private fun addHeaderInterceptor() : Interceptor{
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request = originalRequest.newBuilder()
                    .addHeader("token",getToken())
                    .method(originalRequest.method(),originalRequest.body())
                    .build()
            chain.proceed(request)
        }
    }

    /**
     * 获取Retrofit实例
     */
    private fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            synchronized(RetrofitHelper::class.java) {
                if (retrofit == null) {
                    //添加一个Log拦截器，打印所有的Log
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    //设置请求过滤的水平，body，basic，headers
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                    //设置缓存
                    val cacheFile = File(MyApplication.context.cacheDir, "cache")
                    val cache = Cache(cacheFile, 1024 * 1024 * 50) //缓存大小50M

                    client = OkHttpClient.Builder()
                            .addInterceptor(addQueryParameterInterceptor())
                            .addInterceptor(addHeaderInterceptor())
                            .addInterceptor(httpLoggingInterceptor)
                            .cache(cache)
                            .connectTimeout(60L,TimeUnit.SECONDS)
                            .readTimeout(60L,TimeUnit.SECONDS)
                            .writeTimeout(60L,TimeUnit.SECONDS)
                            .build()

                    retrofit = Retrofit.Builder()
                            .baseUrl(Config.BASE_URL)
                            .client(client!!)
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

                }
            }
        }
        return retrofit
    }

}