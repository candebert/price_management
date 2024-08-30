package com.gft.price_management.application

import com.gft.price_management.domain.entity.PriceEntity
import java.time.LocalDate
import java.util.*

class GetPriceUseCase {

    operator fun invoke(date: LocalDate, brandId: Int, productId: Long): PriceEntity? {
        return null
        //TODO: Not implemented yet
    }
}