package jp.example.hoge.testtab

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

// タブ３つ、選択時にページ番号表示
class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener, PageFragment.OnFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 割り込み
        pager.addOnPageChangeListener(this)

        setTabLayout()

    }
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {}
    override fun onPageScrollStateChanged(state: Int) {}
    // Fragmentからのコールバックメソッド
    override fun onFragmentInteraction(uri: Uri) {
        // 今はなにもしてません
    }

    // タブの設定
    private fun setTabLayout() {
        val adapter = TagAdapter(supportFragmentManager, this)
        pager.adapter = adapter

        tabs.setupWithViewPager(pager)

        for (i in 0 until adapter.count) {
            val tab: TabLayout.Tab = tabs.getTabAt(i)!!
            tab.customView = adapter.getTabView(tabs, i)
        }
    }

}