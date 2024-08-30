package com.gft.price_management.application

import com.gft.price_management.domain.entity.BrandEntity
import com.gft.price_management.domain.entity.Currency
import com.gft.price_management.domain.entity.PriceEntity
import com.gft.price_management.domain.entity.ProductEntity
import com.gft.price_management.domain.repository.PriceRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.webjars.NotFoundException
import java.util.*
import kotlin.test.assertEquals

class GetPriceUseCaseTest {

    private val priceRepository: PriceRepository = mockk()

    private val getPriceUseCase: GetPriceUseCase = GetPriceUseCase(priceRepository)

    @Test
    fun getPriceTest() {
        val productId = 1L
        val brandId = 1
        val date = Date(2024, 6, 5, 8, 30)
        val priceMock = PriceEntity(
            brand = BrandEntity(1, "Zara"),
            currency = Currency.EUR,
            price = 20.5,
            product = ProductEntity(1L, "T-shirt w print N5"),
            priceList = 1,
            priority = 1,
            startDate = Date(2024, 3, 5, 8, 30),
            endDate = Date(2024, 7, 5, 8, 30)
        )
        every { priceRepository.get(any(), any(), any()) } returns priceMock

        val response = getPriceUseCase.invoke(date, brandId, productId)

        assertEquals(response, priceMock)
    }
    }

}