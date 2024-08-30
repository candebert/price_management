package com.gft.price_management.infrastructure

import com.gft.price_management.domain.entity.PriceEntity
import com.gft.price_management.domain.repository.PriceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PriceRepositoryImpl @Autowired constructor(
    private val jpaPriceRepository: JpaPriceRepository
) : PriceRepository {
    override fun get(date: Date, brandId: Int, productId: Long): PriceEntity? {
        TODO("Not yet implemented")
    }

}