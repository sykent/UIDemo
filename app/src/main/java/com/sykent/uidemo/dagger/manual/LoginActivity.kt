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
    private lateinit var loginData: LoginData
    private lateinit var appContainer: AppContainer

    override fun onCreate(
            savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appContainer = (application as DemoApplication).mAppContainer
        appContainer.logContainer = LoginContainer(appContainer.userRepository)
        loginData = appContainer.logContainer!!.loginData
        loginViewModel = appContainer.logContainer!!.loginViewModelFactory.create()
    }

    override fun onDestroy() {
        appContainer.logContainer = null
        super.onDestroy()
    }
}