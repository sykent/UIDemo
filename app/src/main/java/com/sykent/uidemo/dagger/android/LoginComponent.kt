package com.sykent.uidemo.dagger.android

import com.sykent.uidemo.dagger.android.ui.LoginActivity
import com.sykent.uidemo.dagger.android.ui.LoginPasswordFragment
import com.sykent.uidemo.dagger.android.ui.LoginUsernameFragment
import dagger.Subcomponent

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/31 16:29
 */
@ActivityScope
@Subcomponent
interface LoginComponent {
    @Subcomponent.Builder
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(loginActivity: LoginActivity)
    fun inject(loginUsernameFragment: LoginUsernameFragment)
    fun inject(loginPasswordFragment: LoginPasswordFragment)
}