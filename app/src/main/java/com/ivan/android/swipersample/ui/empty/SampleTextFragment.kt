package com.ivan.android.swipersample.ui.empty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ivan.android.swipersample.R
import com.ivan.android.swipersample.tools.getBundleValue
import kotlinx.android.synthetic.main.fragment_sample_text.*

class SampleTextFragment: Fragment() {

    private val pageNumberText by getBundleValue(ATTR_TEXT, 1)

    companion object {
        const val ATTR_TEXT: String = "ATTR_text"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample_text, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_center_title.text = getString(R.string.page_title, pageNumberText)

    }
}