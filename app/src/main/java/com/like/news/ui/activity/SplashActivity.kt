package com.like.news.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.ShareSDK
import cn.sharesdk.sina.weibo.SinaWeibo
import com.like.news.R
import com.like.news.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : BaseActivity() {

    private var alphaAnimation: AlphaAnimation? = null

    override fun layoutId(): Int {
        return R.layout.activity_splash
    }

    override fun init(savedInstanceState: Bundle?) {
        animation()
    }

    /**
     * 延迟跳转主页
     */
    fun animation() {
        alphaAnimation = AlphaAnimation(0.3f, 1.0f)
        alphaAnimation?.duration = 2000
        alphaAnimation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) {
                redirectTo()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        splash_activity.startAnimation(alphaAnimation)
    }


    fun redirectTo() {
        val weibo: Platform = ShareSDK.getPlatform(SinaWeibo.NAME)
        var intent: Intent
        if (weibo.isAuthValid) {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        finish()
    }


}
