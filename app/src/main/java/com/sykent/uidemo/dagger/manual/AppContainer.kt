package com.sykent.uidemo.dagger.manual

import retrofit2.Retrofit

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/20 18:17
 */
class AppContainer {
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://example.com")
            .build()
            .create(LoginService::class.java)

    private val remoteDataSource = UserRemoteDataSource(retrofit)
    private val localDataSource = UserLocalDataSource()

    val userRepository = UserRepository(localDataSource, remoteDataSource)


    var logContainer: LoginContainer? = null
}