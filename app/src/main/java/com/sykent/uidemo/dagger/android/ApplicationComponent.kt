package com.sykent.uidemo.dagger.android

import dagger.Component

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/31 16:42
 */
@Component(modules = [NetworkModule::class, SubcomponentsModule::class])
interface ApplicationComponent {
    fun loginComponent(): LoginComponent.Factory
}