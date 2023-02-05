package com.module.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open abstract class BaseFragment<VDB : ViewDataBinding> : Fragment(){

    open val TAG: String = this.javaClass.name

    private var _binding :VDB? = null
    val binding : VDB get() = _binding!!

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): VDB

    abstract fun onInitBinding()

    abstract fun setObserver()

    open fun getBaseActivity(): BaseActivity<*>? {
        val baseActivity = activity as? BaseActivity<*>
        if (baseActivity == null) {
            Log.d(TAG,",Activity is Null")
        }
        return baseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = initBinding(inflater, container, savedInstanceState)
        _binding?.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObserver()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitBinding()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}