package com.example.core.mvi

import com.module.base.viewmodel.BaseViewModel
import io.reactivex.Observable

abstract class MviViewModel<I : MviIntent, S : MviState> : BaseViewModel(){

    /**
     * ViewModel에 Intent를 inject
     */
    abstract fun processIntents(intents: Observable<I>)

    /**
     * State에대한 UI 처리
     */
    abstract fun states(): Observable<S>

}