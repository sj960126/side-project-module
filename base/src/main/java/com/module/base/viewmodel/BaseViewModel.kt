package com.module.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * BaseViewModel
 * @author HyunSoo
 * @since 2022/012/14
 **/
open class BaseViewModel : ViewModel(){

    open val compositeDisposable = CompositeDisposable()

    private val _failToastLiveData = MutableLiveData<String?>()
    val failToastLiveData: LiveData<String?> get() = _failToastLiveData

    private val _loadingLiveData: MutableLiveData<Boolean> = MutableLiveData(false)
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData

    open fun showFailToast(toastString: String?) {
        _failToastLiveData.postValue(toastString)
    }

    open fun showLoading(isLoading : Boolean){
        _loadingLiveData.postValue(isLoading)
    }

    /**
     * compositeDisposable Clear
     * @author HyunSoo
     * @since 2022/012/14
     **/
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}