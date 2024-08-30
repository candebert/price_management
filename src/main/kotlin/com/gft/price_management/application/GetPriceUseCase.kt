package com.gft.price_management.application

import com.gft.price_management.domain.entity.PriceEntity
import com.gft.price_management.domain.repository.PriceRepository
import java.time.LocalDate
import java.util.*

class GetPriceUseCase (private val priceRepository: PriceRepository) {

    operator fun invoke(date: Date, brandId: Int, productId: Long): PriceEntity? {
        return priceRepository.get(date, brandId, productId)
    }
}