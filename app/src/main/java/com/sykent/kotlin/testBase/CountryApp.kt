package com.sykent.kotlin.testBase

/**
 * @author  Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since   2020/06/07
 */
class CountryApp {
    fun filterCountries(countries: List<Country>,
                        test: (Country) -> Boolean): List<Country> {
        val res = mutableListOf<Country>()
        for (c in countries) {
            if (test(c)) {
                res.add(c)
            }
        }
        return res
    }
}