package jp.example.hoge.testtab

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.widget.TextView
import android.view.View
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.widget.ImageView

// タグのアダブター
class TagAdapter(fm: FragmentManager, private val context: Context) : FragmentStatePagerAdapter(fm) {
    private val pageTitle = arrayOf("PAGE1", "PAGE2", "PAGE3")
    //
    override fun getItem(position: Int): Fragment {
        // 要求時 新しい Fragment を生成して返す
        return PageFragment.newInstance(position + 1)

    }
    // タグのたまえ
    override fun getPageTitle(position: Int): CharSequence? {
        return pageTitle[position]
    }
    // タグの個数
    override fun getCount(): Int {
        return pageTitle.size
    }
    // タブデザインの変更
    fun getTabView(tabLayout: TabLayout, position: Int): View {
        // tab_item.xml を複数
        val view = LayoutInflater.from(this.context).inflate(R.layout.tab_item, tabLayout, false)

        // タグタイトル
        val tab = view.findViewById<TextView>(R.id.teb_item_text)
        tab.text = pageTitle[position]

        // アイコン
        val image = view.findViewById<ImageView>(R.id.teb_item_image)
        image.setImageResource(R.mipmap.ic_launcher)

        return view
    }
}