package com.vane.android.thechronicle.ui.search

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
    private val binding get() = fragmentSearchBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSearchBinding = FragmentSearchNewsBinding.bind(view)

        // Setup the toolbar.
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        val languages = resources.getStringArray(R.array.languages)
        val sortArticles = resources.getStringArray(R.array.sortArticles)
        val arrayAdapterLanguages = ArrayAdapter(requireContext(), R.layout.spinner_item, languages)
        val arrayAdapterSort = ArrayAdapter(requireContext(), R.layout.spinner_item, sortArticles)

        binding.apply {
            imageIconFilter.setOnClickListener(
                NavigationIconClickListener(
                    activity!!,
                    scrollViewArticles,
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

//            // textInputLayoutLanguage.setEndIconOnClickListener { hideKeyboard() }
//
//            textInputLayoutLanguage.apply {
//                setEndIconOnClickListener { hideKeyboard() }
//            }

            autoCompleteTextViewLanguage.apply {
                setOnClickListener { hideKeyboard() }
                setAdapter(arrayAdapterLanguages)
            }

            autoCompleteTextViewSortBy.apply {
                setOnClickListener { hideKeyboard() }
                setAdapter(arrayAdapterSort)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentSearchBinding = null
    }
}
