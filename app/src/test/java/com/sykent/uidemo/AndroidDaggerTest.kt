package com.sykent.uidemo

import android.util.Log
import com.sykent.uidemo.dagger.android.ApplicationGraph
import com.sykent.uidemo.dagger.android.DaggerApplicationGraph
import org.junit.Test

/**
 * @author  laoshuiqiang
 * @version 1.0
 * @date  2020/7/23 16:22
 */
class AndroidDaggerTest {
    @Test
    fun test(): Unit {
        val graph: ApplicationGraph = DaggerApplicationGraph.create()
        val userRepository = graph.repository()
        println("kkkkkk  ${userRepository.toString()}")
    }
}