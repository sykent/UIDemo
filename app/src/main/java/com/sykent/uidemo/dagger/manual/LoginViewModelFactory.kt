package com.sykent.uidemo.dagger.manual

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/23 18:35
 */
class LoginViewModelFactory<T>(private val repository: UserRepository) : Factory<LoginViewModel> {
    override fun create(): LoginViewModel {
        return LoginViewModel(repository)
    }
}