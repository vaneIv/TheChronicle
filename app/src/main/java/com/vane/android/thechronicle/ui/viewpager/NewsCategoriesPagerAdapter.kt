package com.vane.android.thechronicle.ui.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vane.android.thechronicle.ui.*

const val BREAKING_NEWS_PAGE_INDEX = 0
const val SPORTS_NEWS_PAGE_INDEX = 1
const val BUSINESS_NEWS_PAGE_INDEX = 2
const val HEALTH_NEWS_PAGE_INDEX = 3
const val SCIENCE_NEWS_PAGE_INDEX = 4
const val ENTERTAINMENT_NEWS_PAGE_INDEX = 5
const val GENERAL_NEWS_PAGE_INDEX = 6

class NewsCategoriesPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    /**
     * Mapping of the ViewPager page index to their respective fragments
     */
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        BREAKING_NEWS_PAGE_INDEX to { BreakingNewsFragment() },
        SPORTS_NEWS_PAGE_INDEX to { SportsNewsFragment() },
        BUSINESS_NEWS_PAGE_INDEX to { BusinessNewsFragment() },
        HEALTH_NEWS_PAGE_INDEX to { HealthNewsFragment() },
        SCIENCE_NEWS_PAGE_INDEX to { ScienceNewsFragment() },
        ENTERTAINMENT_NEWS_PAGE_INDEX to { EntertainmentNewsFragment() },
        GENERAL_NEWS_PAGE_INDEX to { GeneralNewsFragment() }
    )
}