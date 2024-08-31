package com.gft.price_management.delivery.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

data class PriceResponse(

    @Schema(example = "null", description = "")
    @get:JsonProperty("product_id") val productId: Long? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("brand_id") val brandId: Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("price_list") val priceList: Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("price") val price: java.math.BigDecimal? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("priority") val priority: Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("currency") val currency: String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("start_date") val startDate: Date? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("end_date") val endDate: Date? = null
)

