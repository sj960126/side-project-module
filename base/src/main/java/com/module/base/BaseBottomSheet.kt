package com.module.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open abstract class BaseBottomSheet<VDB : ViewDataBinding> : BottomSheetDialogFragment() {

    private var _binding : VDB? = null
    val binding : VDB = _binding!!

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): VDB

    abstract fun onInitBinding()

    /**
     * 바텀시트 스타일 적용
     * @author Hyunsoo
     * @since 12/15/22
     * ex   setStyle(STYLE_NORMAL, R.style.TransparentBottomSheetDialogFragment)
     **/
    abstract fun setViewStyle()

    open fun close(){
        this.dismiss()
    }

    open fun showBottomSheet(fragmentManager: FragmentManager, tag: String? = getTag()) {
        show(fragmentManager, tag)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = initBinding(inflater, container, savedInstanceState)
        _binding?.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        return dialog
    }

}