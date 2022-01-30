package com.mertkalecik.earthquake.ui.home

import com.mertkalecik.earthquake.base.BaseViewModel
import com.mertkalecik.earthquake.data.Event
import com.mertkalecik.earthquake.data.login.LoginModel
import com.mertkalecik.earthquake.data.login.LoginState

class HomeViewModel : BaseViewModel<LoginState, HomeViewModel.LoginEvents>(LoginState()) {

    fun init(name: String) {
        setState {
            copy(LoginModel("Merhaba $name"))
        }
    }

    sealed class LoginEvents : Event {
        object NavigateToHome : LoginEvents()
    }
}
