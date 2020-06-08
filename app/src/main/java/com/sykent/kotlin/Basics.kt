package com.sykent.kotlin

import android.util.Log

/**
 * @author  Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since   2020/05/27
 */
class Basics {
    fun main() {
        Log.println(Log.DEBUG, "kotlin", "HelloWorld!");
    }

    fun sum(a: Int, b: Int): Int {
        return a + b;
    }

    fun sum1(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int): Unit {
        print(a + b)
    }

    fun printSum1(a: Int, b: Int) {
        print(a + b)
    }

    fun test(): Unit {
        val a: Int = 1
        val b = 2
        val c: Int = 3

        var x = 5
        x += 1

        var a1 = 1;
        val s1 = "a is $a1"
        a1 = 2
        val s2 = "${s1.replace("is", "was")},but not is $a"
    }

    fun max(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun max1(a: Int, b: Int): Int = if (a > b) a else b

    fun parseInt(str: String): Int? {
        return 1
    }

    fun printProduce(str1: String, str2: String) {
        val a = parseInt(str1)
        val b = parseInt(str2)
        if (a != null && b != null) {
            print(a * b)
        } else {
            print("$str1 or $str2 is not a number")
        }
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }

        return null;
    }

    fun testFor(): Unit {
        val items = listOf("aaa", "bbb", "ccc")
        for (item in items) {
            print(item)
        }
    }

    fun testWhile(): Unit {
        val items = listOf("aaa", "bbb", "ccc")
        var index = 0
        while (index < items.size) {
            println("items at $index is ${items[index]}")
            index++
        }
    }

    fun testWhile2(obj: Any): String =
            when (obj) {
                1 -> "One"
                "Hello" -> "Greeting"
                is Long -> "Long"
                !is String -> "Not a String"
                else -> "Unknown"
            }

    fun testRange(): Unit {
        val x = 10
        val y = 9
        if (1 in x..y) {
            print("fits in range")
        }
    }

    fun testShuRange(): Unit {
        for (x in 1..10 step 2) {
            println(x)
        }
    }


    fun testLambda() {

    }


}