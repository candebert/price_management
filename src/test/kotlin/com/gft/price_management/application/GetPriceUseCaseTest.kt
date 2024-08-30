package com.gft.price_management.application

import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.LocalDate
import java.util.Date
import kotlin.test.assertTrue

class GetPriceUseCaseTest {

    private val getPriceUseCase: GetPriceUseCase = GetPriceUseCase()

    @Test
    fun getPriceTest() {
        val productId = 1L
        val brandId = 1
        val date = LocalDate.now()

        val response = getPriceUseCase.invoke(date, brandId, productId)

        assertTrue(response == null)
    }

}