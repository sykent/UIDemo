package com.sykent.kotlin.testBase

/**
 * @author  Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since   2020/06/07
 */
class CountryTest {
    fun isBigEuropeanCountry(country: Country): Boolean {
        return country.continient == "EU" && country.population > 10000
    }
}