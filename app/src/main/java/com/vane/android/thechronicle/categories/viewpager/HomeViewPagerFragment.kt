package com.vane.android.thechronicle.categories.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.vane.android.thechronicle.R
import com.vane.android.thechronicle.databinding.FragmentViewPagerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        viewPager.adapter = NewsCategoriesPagerAdapter(this)

        // Set the text for each tab
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            BREAKING_NEWS_PAGE_INDEX -> getString(R.string.category_breaking_news_label)
            SPORTS_NEWS_PAGE_INDEX -> getString(R.string.category_sports_label)
            BUSINESS_NEWS_PAGE_INDEX -> getString(R.string.category_business_label)
            HEALTH_NEWS_PAGE_INDEX -> getString(R.string.category_health_label)
            SCIENCE_NEWS_PAGE_INDEX -> getString(R.string.category_science_label)
            ENTERTAINMENT_NEWS_PAGE_INDEX -> getString(R.string.category_entertainment_label)
            GENERAL_NEWS_PAGE_INDEX -> getString(R.string.category_general_label)
            else -> null
        }
    }
}