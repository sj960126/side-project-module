package com.module.base.viewmodel

import android.media.effect.Effect
import androidx.lifecycle.viewModelScope
import com.module.base.common.sideeffect.OrbitSideEffect
import com.module.base.common.state.OrbitState
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container

/**
 * OrbitMviViewModel
 * @author HyunSoo
 * @since 2023/10/14
 **/
open class OrbitMviViewModel<STATE : OrbitState, EFFECT : OrbitSideEffect>(
    private val state: STATE
): BaseViewModel(), ContainerHost<STATE,EFFECT>{

    override val container: Container<STATE, EFFECT> = container(state)

    fun postAction(sideEffect: EFFECT) = intent {
        viewModelScope.launch {
            postSideEffect(sideEffect = sideEffect)
        }
    }
}