package com.gft.price_management.delivery.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param productId 
 * @param brandId 
 * @param priceList 
 * @param price 
 * @param currency 
 * @param startDate 
 * @param endDate 
 */
data class PriceResponse(

    @Schema(example = "null", description = "")
    @get:JsonProperty("product_id") val productId: kotlin.Long? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("brand_id") val brandId: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("price_list") val priceList: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("price") val price: java.math.BigDecimal? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("currency") val currency: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("start_date") val startDate: java.time.OffsetDateTime? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("end_date") val endDate: java.time.OffsetDateTime? = null
    ) {

}

