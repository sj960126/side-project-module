package com.module.base.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding

/**
 * base activity
 * @author Hyunsoo
 * @since 12/14/22
 **/
open abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {

    open val TAG: String = this.javaClass.name

    private var _binding : VDB? = null
    val binding : VDB get() = _binding!!

    /**
     * Layoutinflater
     * @author Hyunsoo
     * @since 12/14/22
     * ex :override fun initBinding(layoutInflater: LayoutInflater): MainActivityBinding = MainActivityBinding.inflate(layoutInflater)
     **/
    abstract fun initBinding(layoutInflater: LayoutInflater) : VDB

    /**
     * 추가적인 Binding
     * @author Hyunsoo
     * @since 12/14/22
     * ex :override fun onInitBinding() {}
     **/
    open fun onInitBinding() {}

    open fun setObserver() {}

    open fun setListener() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = initBinding(layoutInflater = layoutInflater)
        _binding?.lifecycleOwner = this
        setContentView(binding.root)
        onInitBinding()
        setObserver()
        setListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}