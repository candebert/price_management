package com.gft.price_management.domain.entity

import java.util.Date

data class PriceEntity(
    val brand: BrandEntity,
    val product: ProductEntity,
    val priceList: Short,
    val price: Number,
    val currency: Currency,
    val priority: Short,
    val startDate: Date,
    val endDate: Date
)