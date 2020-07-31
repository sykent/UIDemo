package com.sykent.uidemo.dagger.android.ui

import android.content.Context
import androidx.fragment.app.Fragment
import com.sykent.uidemo.dagger.android.data.LoginViewModel2
import javax.inject.Inject

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/31 16:35
 */
class LoginUsernameFragment : Fragment() {
    @Inject
    lateinit var loginViewModel2: LoginViewModel2

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as LoginActivity).loginComponent.inject(this)
    }
}