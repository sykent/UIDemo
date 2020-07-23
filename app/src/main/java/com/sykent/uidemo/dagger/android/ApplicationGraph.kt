package com.sykent.uidemo.dagger.android

import dagger.Component

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/23 16:01
 */
@Component
interface ApplicationGraph {
    fun repository(): UserRepository
}