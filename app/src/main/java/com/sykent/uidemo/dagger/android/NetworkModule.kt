package com.sykent.uidemo.dagger.android

import com.sykent.uidemo.dagger.android.data.LoginViewModel
import dagger.Module
import dagger.Provides

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/31 15:18
 */
@Module
class NetworkModule {
    @Provides
    fun provideLoginRetrofitService(): LoginRetrofitService {
        return LoginRetrofitService()
    }
}