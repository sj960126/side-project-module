package com.example.core.orbit.viewmodel

import androidx.lifecycle.viewModelScope
import com.module.base.viewmodel.BaseViewModel
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
open class OrbitMviViewModel<STATE : com.example.core.orbit.common.state.OrbitState, EFFECT : com.example.core.orbit.common.sideeffect.OrbitSideEffect>(
    private val state: STATE
): BaseViewModel(), ContainerHost<STATE,EFFECT>{

    override val container: Container<STATE, EFFECT> = container(state)

    fun postAction(sideEffect: EFFECT) = intent {
        viewModelScope.launch {
            postSideEffect(sideEffect = sideEffect)
        }
    }
}