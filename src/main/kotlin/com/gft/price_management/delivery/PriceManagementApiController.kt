package com.gft.price_management.delivery

import com.gft.price_management.application.GetPriceUseCase
import com.gft.price_management.delivery.mapper.PriceMapper.toPriceResponse
import com.gft.price_management.delivery.model.PriceResponse
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import java.time.LocalDateTime
import java.util.*

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class PriceManagementApiController(private val getPriceUseCase: GetPriceUseCase) {

    @Operation(
        summary = "Get price by date, Product ID and Brand ID",
        operationId = "priceManagementGetPriceGet",
        description = "",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Price",
                content = [Content(schema = Schema(implementation = PriceResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description =
                "Brand ID not found | Product ID not found | Date not found | Brand ID + Product ID + Date not found"
            ),
            ApiResponse(
                responseCode = "200",
                description = "Price",
                content = [Content(schema = Schema(implementation = PriceResponse::class))]
            ) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/price_management/get_price"],
        produces = ["application/json"]
    )
    fun getPrice(
        @Parameter(description = "Current date", required = true)
        @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) date: LocalDateTime,
        @Parameter(description = "Product ID", required = true) @RequestParam("product_id") productId: Long,
        @Parameter(description = "Brand ID", required = true) @RequestParam("brand_id") brandId: Int):
            ResponseEntity<PriceResponse> {
        val javaDate = Date.from(date.atZone(java.time.ZoneId.systemDefault()).toInstant())
        val response = getPriceUseCase(javaDate, brandId, productId)
        return ResponseEntity(response.toPriceResponse(), HttpStatus.OK)
    }
}
