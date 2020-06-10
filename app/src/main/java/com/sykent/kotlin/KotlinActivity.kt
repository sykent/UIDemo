package com.sykent.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.sykent.framework.activity.BaseActivity
import com.sykent.kotlin.testBase.Country
import com.sykent.kotlin.testBase.CountryApp
import com.sykent.kotlin.testBase.CountryTest
import com.sykent.uidemo.R

/**
 * @author  Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since   2020/06/07
 */
class KotlinActivity : BaseActivity() {
    override fun initView() {
        super.initView()
        // 设置标题
        (findViewById<View>(R.id.normal_title_caption) as TextView).text = "Kotlin Test"
    }

    override fun initData(savedInstanceState: Bundle?, intent: Intent?) {
        super.initData(savedInstanceState, intent)
        testBase()
    }

    override fun provideContentViewLayoutResID(): Int {
        return R.layout.activity_kotlin_test
    }

    override fun provideTitleViewLayoutResID(): Int {
        return R.layout.normal_title
    }

    fun testBase() {
        val countryApp = CountryApp()
        val countryTest = CountryTest()
        val testCountries = mutableListOf<Country>()
        // 1.
        val countries = countryApp.filterCountries(testCountries, countryTest::isBigEuropeanCountry)
        // 2.
        val countries2 = countryApp.filterCountries(testCountries,fun(country:Country):Boolean{
            return country.continient == "EU" && country.population > 10000
        })
    }

}