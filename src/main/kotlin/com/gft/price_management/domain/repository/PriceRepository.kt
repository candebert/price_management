package com.gft.price_management.domain.repository

import com.gft.price_management.domain.entity.PriceEntity
import java.util.*

interface PriceRepository {

    fun get(date: Date, brandId: Int, productId: Long): PriceEntity?

}