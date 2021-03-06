package com.example.administrator.nothing_kotlin.mvp.ui

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.example.administrator.nothing_kotlin.R
import com.example.administrator.nothing_kotlin.adapter.MainAdapter
import com.example.administrator.nothing_kotlin.base.BaseActivity
import com.example.administrator.nothing_kotlin.mvp.ui.fragment.MineFragment
import com.example.administrator.nothing_kotlin.mvp.ui.fragment.GoodsFragment
import com.example.administrator.nothing_kotlin.mvp.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

@RequiresApi(Build.VERSION_CODES.M)
class MainActivity : BaseActivity(), View.OnClickListener, ViewPager.OnPageChangeListener {

    var mainAdapter : MainAdapter? = null
    var fragmentList : ArrayList<Fragment> = ArrayList()

    override fun getLayoutResourse(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    override fun initData() {
        val homeFragment = HomeFragment()
        val discoveryFragment = MineFragment()
        val goodsFragment = GoodsFragment()
        fragmentList.add(homeFragment)
        fragmentList.add(goodsFragment)
        fragmentList.add(discoveryFragment)
        mainAdapter = MainAdapter(supportFragmentManager , fragmentList)
        viewpager?.adapter = mainAdapter
        viewpager?.currentItem = 0
        viewpager?.addOnPageChangeListener(this)
    }

    override fun setListener() {
        mine_linear.setOnClickListener(this)
        home_linear?.setOnClickListener(this)
        goods_linear?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.mine_linear ->{
                reset()
                setMineSelect()
                viewpager?.currentItem = 2
            }
            R.id.home_linear ->{
                reset()
                setHomeSelect()
                viewpager?.currentItem = 0
            }
            R.id.goods_linear ->{
                reset()
                setGoodsSelect()
                viewpager?.currentItem = 1
            }
        }
    }

    private fun reset(){
        home_img?.setImageResource(R.mipmap.main_home_unselect_tab)
        home_tv?.setTextColor(resources.getColor(R.color.gray_99))
        mine_img?.setImageResource(R.mipmap.main_mine_unselect_tab)
        mine_tv?.setTextColor(resources.getColor(R.color.gray_99))
        goods_img?.setImageResource(R.mipmap.main_shoping_unselect_tab)
        goods_tv?.setTextColor(resources.getColor(R.color.gray_99))
    }

    private fun setHomeSelect(){
        home_img?.setImageResource(R.mipmap.main_home_select_tab)
        home_tv?.setTextColor(resources.getColor(R.color.text_color_black))
    }

    private fun setMineSelect(){
        mine_img?.setImageResource(R.mipmap.main_mine_select_tab)
        mine_tv?.setTextColor(resources.getColor(R.color.text_color_black))
    }

    private fun setGoodsSelect(){
        goods_img?.setImageResource(R.mipmap.main_shoping_select_tab)
        goods_tv?.setTextColor(resources.getColor(R.color.text_color_black))
    }

    override fun onPageScrollStateChanged(p0: Int) {
    }

    override fun onPageSelected(p0: Int) {
        reset()
        when (p0) {
            0 -> setHomeSelect()
            1 -> setGoodsSelect()
            2 -> setMineSelect()
        }
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }

}
