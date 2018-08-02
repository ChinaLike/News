package com.like.news.ui.activity

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.util.Log
import cn.sharesdk.framework.Platform
import cn.sharesdk.framework.ShareSDK
import cn.sharesdk.sina.weibo.SinaWeibo
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.like.news.R
import com.like.news.base.BaseActivity
import com.like.news.mvp.model.bean.TabEntity
import com.like.news.ui.fragment.HomeFragment
import com.like.news.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : BaseActivity() {


    //Tab栏标题
    private val mTitles = arrayOf("首页","我的")
    //Tab栏未选中时图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.tab_home_unselect,R.mipmap.tab_mine_unselect)
    //Tab栏选中时图标
    private val mIconSelectIds = intArrayOf(R.mipmap.tab_home_select,R.mipmap.tab_mine_select)

    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment : HomeFragment? = null
    private var mMineFragment : MineFragment? = null

    //默认选中第一个
    private var mIndex = 0

    override fun layoutId(): Int {
       return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)
    }

    override fun init(savedInstanceState: Bundle?) {
        val weibo : Platform = ShareSDK.getPlatform(SinaWeibo.NAME)
        Log.d("微博授权",weibo!!.db.exportData().toString())
    }

    /**
     * 初始化底部菜单
     */
    private fun initTab(){
        (0 until mTitles.size).mapTo(mTabEntities){
            TabEntity(mTitles[it],mIconSelectIds[it],mIconUnSelectIds[it])
        }
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {

            }
        })
    }

    private fun switchFragment(position : Int){
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when(position){
            0//首页
            ->mHomeFragment?.let {
                transaction.show(it)
            } ?: HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.container,it,"home")
            }
            1//我的
            ->mMineFragment?.let {
                transaction.show(it)
            } ?: MineFragment.getInstance(mTitles[position]).let {
                mMineFragment = it
                transaction.add(R.id.container,it,"mine")
            }
            else ->{

            }
        }
        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }

    /**
     * 隐藏所有的Fragment
     * @param transaction transaction
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }

    /**
     * 记录fragment的位置,防止崩溃 activity被系统回收时，fragment错乱
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (tab_layout != null){
            outState.putInt("currTabIndex",mIndex)
        }
    }
}
