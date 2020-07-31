package com.sykent.uidemo.dagger.android.ui

import android.app.Activity
import android.os.Bundle
import com.sykent.DemoApplication
import com.sykent.uidemo.dagger.android.LoginComponent
import com.sykent.uidemo.dagger.android.LoginRetrofitService
import com.sykent.uidemo.dagger.android.data.LoginViewModel
import com.sykent.uidemo.dagger.android.data.LoginViewModel2
import javax.inject.Inject

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/31 15:00
 */
class LoginActivity : Activity() {
//    @Inject
//    lateinit var loginViewModel: LoginViewModel

    @Inject
    lateinit var loginRetrofitService: LoginRetrofitService

    lateinit var loginComponent: LoginComponent

    @Inject
    lateinit var loginViewModel2: LoginViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
//        (application as DemoApplication).applicationGraph.inject(this)
        loginComponent = (application as DemoApplication)
                .applicationComponent.loginComponent().create()
        loginComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}