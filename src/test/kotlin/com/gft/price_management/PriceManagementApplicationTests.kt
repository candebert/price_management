package com.gft.price_management

import org.junit.jupiter.api.Test
import com.gft.price_management.delivery.PriceManagementApiController
import com.gft.price_management.delivery.model.PriceResponse
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import java.time.OffsetDateTime
import kotlin.test.assertTrue

@SpringBootTest
class PriceManagementApplicationTests {

	private val api: PriceManagementApiController = PriceManagementApiController()

	@Test
	fun priceManagementGetPriceGetTest() {
		val testDate = OffsetDateTime.now()
		val date: OffsetDateTime = testDate
		val productId: Long = 1
		val brandId = 1
		val response: ResponseEntity<PriceResponse> = api.priceManagementGetPriceGet(date, productId, brandId)

		assertTrue(response.statusCode.isError)
	}
}
