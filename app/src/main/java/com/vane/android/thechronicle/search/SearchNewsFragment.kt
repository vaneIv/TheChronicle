package com.vane.android.thechronicle.search

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.vane.android.thechronicle.R
import com.vane.android.thechronicle.databinding.FragmentSearchNewsBinding
import com.vane.android.thechronicle.utils.hideKeyboard


class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {

    private var fragmentSearchBinding: FragmentSearchNewsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchNewsBinding.bind(view)
        fragmentSearchBinding = binding

        // Setup the toolbar.
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        binding.imageIconFilter.setOnClickListener(
            NavigationIconClickListener(
                activity!!,
                binding.scrollViewArticles,
                AccelerateDecelerateInterpolator(),
                ContextCompat.getDrawable(
                    context!!,
                    R.drawable.ic_baseline_filter_alt_24
                ), // Menu open icon
                ContextCompat.getDrawable(
                    context!!,
                    R.drawable.ic_baseline_close_24
                ) // Menu Close icon
            )
        )


//        binding.toolbar.setNavigationOnClickListener(
//            NavigationIconClickListener(
//                activity!!,
//                binding.scrollViewArticles,
//                AccelerateDecelerateInterpolator(),
//                ContextCompat.getDrawable(context!!, R.drawable.ic_baseline_filter_alt_24), // Menu open icon
//                ContextCompat.getDrawable(context!!, R.drawable.ic_baseline_close_24) // Menu Close icon
//            )
//        )

        val languages = resources.getStringArray(R.array.languages)
        val sortArticles = resources.getStringArray(R.array.sortArticles)
        val arrayAdapterLanguages = ArrayAdapter(requireContext(), R.layout.spinner_item, languages)
        val arrayAdapterSort = ArrayAdapter(requireContext(), R.layout.spinner_item, sortArticles)

        binding.autoCompleteTextViewLanguage.apply {
            setOnClickListener { hideKeyboard() }
            setAdapter(arrayAdapterLanguages)
        }

        binding.autoCompleteTextViewSortBy.apply {
            setOnClickListener { hideKeyboard() }
            setAdapter(arrayAdapterSort)
        }
    }

    override fun onDestroyView() {
        fragmentSearchBinding = null
        super.onDestroyView()
    }
}
