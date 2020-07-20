package com.sykent.uidemo.dagger.manual

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.sykent.DemoApplication

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/20 17:12
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(
            savedInstanceState: Bundle?,
            persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val appContainer = (application as DemoApplication).mAppContainer
        loginViewModel = LoginViewModel(appContainer.userRepository)
    }

}