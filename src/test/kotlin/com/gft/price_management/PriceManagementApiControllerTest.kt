package com.gft.price_management

import com.gft.price_management.application.GetPriceUseCase
import org.junit.jupiter.api.Test
import com.gft.price_management.delivery.PriceManagementApiController
import com.gft.price_management.delivery.model.PriceResponse
import com.gft.price_management.domain.entity.BrandEntity
import com.gft.price_management.domain.entity.Currency
import com.gft.price_management.domain.entity.PriceEntity
import com.gft.price_management.domain.entity.ProductEntity
import io.mockk.every
import io.mockk.mockk
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import java.time.LocalDate
import java.util.*
import kotlin.test.assertEquals

@SpringBootTest
class PriceManagementApiControllerTest {

	private val useCase: GetPriceUseCase = mockk()

	private val api: PriceManagementApiController = PriceManagementApiController(useCase)

	@Test
	fun `when call to controller w correct brand product and date then return a correct response entity`() {
		val testDate = LocalDate.now()
		val date: LocalDate = testDate
		val productId: Long = 1
		val brandId = 1
		val priceEntity = PriceEntity(
			brand = BrandEntity(1, "inditest"),
			product = ProductEntity(1, "TestShirt"),
			price = 35.5.toBigDecimal(),
			priority = 1,
			priceList = 1,
			currency = Currency.EUR,
			startDate = Date(2024, 3, 5, 8, 30, 0),
			endDate = Date(2024, 7, 5, 8, 30, 0)
		)
		val expectedResponse = PriceResponse(
			productId = 1L,
			brandId = 1,
			priceList = 1,
			price = 35.5.toBigDecimal(),
			priority = 1,
			currency = "EUR",
			startDate = Date(2024, 3, 5, 8, 30, 0),
			endDate = Date(2024, 7, 5, 8, 30, 0)
		)
		every { useCase.invoke(any(), any(), any()) } returns priceEntity

		val response: ResponseEntity<PriceResponse> = api.getPrice(date, productId, brandId)

		assertEquals(expectedResponse, response.body)
	}
}
