package com.gft.price_management.delivery.mapper

import com.gft.price_management.delivery.model.PriceResponse
import com.gft.price_management.domain.entity.PriceEntity

object PriceMapper {
    fun PriceEntity.toPriceResponse(): PriceResponse {
        return PriceResponse(
            brandId = brand.id,
            productId = product.id,
            priceList = priceList,
            priority = priority,
            currency = currency.name,
            price = price,
            startDate = startDate,
            endDate = endDate
        )
    }
}