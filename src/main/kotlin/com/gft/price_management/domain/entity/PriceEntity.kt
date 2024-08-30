package com.gft.price_management.domain.entity

import java.math.BigDecimal
import java.util.Date

data class PriceEntity(
    val brand: BrandEntity,
    val product: ProductEntity,
    val priceList: Int,
    val price: BigDecimal,
    val currency: Currency,
    val priority: Int,
    val startDate: Date,
    val endDate: Date
)