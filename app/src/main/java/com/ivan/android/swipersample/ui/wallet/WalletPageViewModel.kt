package com.ivan.android.swipersample.ui.wallet

import androidx.lifecycle.*
import com.ivan.android.swipersample.data.CoinListData
import com.ivan.android.swipersample.data.DataRepository
import kotlinx.coroutines.launch

class WalletPageViewModel(private val page:Int, private val repository: DataRepository): ViewModel() {

    private val _data = MutableLiveData<CoinListData>()
    private val _loading = MutableLiveData<Boolean>(false)

    val data:LiveData<CoinListData>
        get() = _data

    val isLoad:LiveData<Boolean>
        get() = _loading

    init {
        viewModelScope.launch {

            _loading.value = true

            when(page) {
                1 -> _data.value = repository.getPageOneData()
                2 -> _data.value = repository.getPageTwoData()
            }

            _loading.value = false

        }

    }
}


@Suppress("UNCHECKED_CAST")
class WalletPageViewModelFactory (
        private val page: Int,
        private val repository: DataRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
            (WalletPageViewModel(page, repository) as T)
}