package com.ivan.android.swipersample.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ivan.android.swipersample.R
import com.ivan.android.swipersample.data.DataRepository
import com.ivan.android.swipersample.tools.getBundleValue
import kotlinx.android.synthetic.main.fragment_wallet_page.*

class WalletPageFragment : Fragment() {

    private val pageIndex: Int by getBundleValue(ATTR_PAGE_INDEX, 0)
    private val viewModel by viewModels<WalletPageViewModel> {
        WalletPageViewModelFactory(pageIndex, DataRepository())
    }

    private val adapter by lazy { WalletListAdapter() }


    companion object {
        val ATTR_PAGE_INDEX: String = "ATTR_page_index"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_wallet_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_list.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@WalletPageFragment.adapter
        }

        viewModel.isLoad.observe(viewLifecycleOwner){ isLoad ->
            progressBar.visibility = when(isLoad) {
                true -> View.VISIBLE
                false -> View.INVISIBLE
            }
        }

        viewModel.data.observe(viewLifecycleOwner){
            adapter.setCoinListData(it)
        }
    }
}