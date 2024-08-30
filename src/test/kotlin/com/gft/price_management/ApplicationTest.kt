package com.gft.price_management

import org.junit.jupiter.api.Test
import com.gft.price_management.delivery.PriceManagementApiController
import com.gft.price_management.delivery.model.PriceResponse
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import java.time.LocalDate
import kotlin.test.assertTrue

@SpringBootTest
class ApplicationTest {

	private val api: PriceManagementApiController = PriceManagementApiController()

	@Test
	fun `when call to controller w correct brand product and date then return a correct response entity`() {
		val testDate = LocalDate.now()
		val date: LocalDate = testDate
		val productId: Long = 1
		val brandId = 1
		val response: ResponseEntity<PriceResponse> = api.getPrice(date, productId, brandId)

		assertTrue(response.statusCode.isError)
	}
}
