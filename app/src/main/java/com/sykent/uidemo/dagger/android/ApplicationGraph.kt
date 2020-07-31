package com.sykent.uidemo.dagger.android

import android.app.Activity
import com.sykent.uidemo.dagger.android.data.UserRepository
import com.sykent.uidemo.dagger.android.ui.LoginActivity
import dagger.Component

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/23 16:01
 */
@Component(modules = [NetworkModule::class])
interface ApplicationGraph {
    fun repository(): UserRepository
//    fun inject(activity: LoginActivity)

}