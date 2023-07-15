package com.example.core.mvi

import io.reactivex.Observable

interface MviView <I : MviIntent, in S : MviState>{

    fun bind()

    fun unBind()

    fun intents() : Observable<I>

    fun render(state : S)
}