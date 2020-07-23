package com.sykent.uidemo.dagger.manual

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/23 18:34
 */
interface Factory<T> {
    fun create(): T
}