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
    fun `when call to repository w a correct request then this return a correct price object`() {
        val productId = 1L
        val brandId = 1
        val date = Date(2024, 6, 5, 8, 30)
        val priceMock = PriceEntity(
            brand = BrandEntity(1, "Zara"),
            currency = Currency.EUR,
            price = 20.5.toBigDecimal(),
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

    @Test
    fun `when call to a repository for a no exist price then return exception`() {
        val productId = 1L
        val brandId = 1
        val date = Date(2024, 6, 5, 8, 30)
        every { priceRepository.get(any(), any(), any()) } returns null

        assertThrows<NotFoundException> {
            getPriceUseCase.invoke(date, brandId, productId)
        }
    }

    /*-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    * */

}