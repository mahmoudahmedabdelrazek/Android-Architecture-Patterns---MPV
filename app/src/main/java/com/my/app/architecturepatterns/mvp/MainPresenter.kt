package com.my.app.architecturepatterns.mvp

import com.my.app.architecturepatterns.mvc.MainView

class MainPresenter(private val view: MainView) {
    fun onButtonClick(userTextname: String, userTextage: String) {
        val age = userTextage.toIntOrNull() ?: 0
        val name = if (userTextname.isEmpty()) "Unknown" else userTextname

        val userModel = Model(name = name, age = age)

        view.showUserDetails(userModel.name, userModel.age)
    }
}