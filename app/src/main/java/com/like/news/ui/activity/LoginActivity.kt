package com.like.news.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.PlatformActionListener
import cn.sharesdk.framework.ShareSDK
import cn.sharesdk.sina.weibo.SinaWeibo
import com.like.news.R
import com.like.news.base.BaseActivity
import com.like.news.mvp.model.bean.UserInfo
import com.like.news.utils.Preference
import com.like.news.utils.TypeConversion
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

/**
 * 登录界面
 */
class LoginActivity : BaseActivity(),View.OnClickListener{

//    private var authInfo by Preference("authInfo",UserInfo.AuthInfo::class.java)


    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun init(savedInstanceState: Bundle?) {
        auth.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        anthorize()
    }

    /**
     * 微博授权
     */
    fun anthorize(){
        val weibo : Platform = ShareSDK.getPlatform(SinaWeibo.NAME)
        weibo.platformActionListener = object : PlatformActionListener{
            override fun onError(p0: Platform?, p1: Int, p2: Throwable?) {

            }

            override fun onComplete(p0: Platform?, p1: Int, p2: HashMap<String, Any>?) {
                redirectTo()
//                authInfo = TypeConversion.str2Obj(p0!!.db.exportData().toString(),UserInfo.AuthInfo::class.java)
        }

            override fun onCancel(p0: Platform?, p1: Int) {

            }
        }
        weibo.authorize()
    }

    fun redirectTo(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}
