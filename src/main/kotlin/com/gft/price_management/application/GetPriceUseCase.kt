package com.gft.price_management.application

import com.gft.price_management.domain.entity.PriceEntity
import com.gft.price_management.domain.repository.PriceRepository
import org.springframework.stereotype.Service
import org.webjars.NotFoundException
import java.util.*

@Service
class GetPriceUseCase (private val priceRepository: PriceRepository) {

    operator fun invoke(date: Date, brandId: Int, productId: Long): PriceEntity {
        return priceRepository.get(date, brandId, productId)
            ?: throw NotFoundException("Brand ID + Product ID + Date not found")
    }
}