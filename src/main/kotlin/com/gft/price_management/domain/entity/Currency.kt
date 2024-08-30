package com.gft.price_management.domain.entity

import javax.management.BadAttributeValueExpException

//About countries where Zara is
enum class Currency {
    EUR, ARS, MAD, INR, PKR, BDT, VND, CNY, BRL;

    companion object {
        fun getCurrency(currency: String): Currency {
            entries.map {
                if(it.toString() == currency) return it
            }
            throw BadAttributeValueExpException(currency)
            /*return when (currency.uppercase()) {
                "EUR" -> EUR
                "ARS" -> ARS
                "MAD" -> MAD
                "INR" -> INR
                "PKR" -> PKR
                "BDT" -> BDT
                "VND" -> VND
                "CNY" -> CNY
                "BRL" -> BRL
            }*/
        }
    }


}