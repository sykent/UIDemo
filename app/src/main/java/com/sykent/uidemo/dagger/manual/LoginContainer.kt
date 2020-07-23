package com.sykent.uidemo.dagger.manual

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/23 18:40
 */
class LoginContainer(private val repository: UserRepository) {
    val loginData = LoginData()
    val loginViewModelFactory = LoginViewModelFactory<LoginViewModel>(repository)
}