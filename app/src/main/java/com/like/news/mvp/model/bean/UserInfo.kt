package com.like.news.mvp.model.bean

import java.io.Serializable

/**

 * 作者：like on 2018/8/1 11:41

 * 邮箱：like@tydic.com

 * 描述：新浪微博授权信息

 */

data class UserInfo(val authInfo: AuthInfo) : Serializable {

    /**
     * 用户授权信息
     */
    data class AuthInfo(
            val resume: String,
            val favouriteCount: String,
            val gender: String,
            val icon: String,
            val snsregat: String,
            val secret: String,
            val snsUserUrl: String,
            val userID: String,
            val expiresTime: Long,
            val token: String,
            val expiresIn: Long,
            val refresh_token: String,
            val shareCount: String,
            val secretType: String,
            val nickname: String,
            val followerCount: String,
            val remind_in: String

    ) : Serializable
}