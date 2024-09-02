package com.gft.price_management.infrastructure.entity

import com.gft.price_management.domain.entity.Currency
import com.gft.price_management.domain.entity.PriceEntity
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.Date

@Entity
@Table(name = "price")
data class Price (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    val brand: Brand,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    val product: Product,

    @Column(name = "price_list")
    val priceList: Int,

    val priority: Int,

    val currency: String,

    @Column(name = "price", precision = 10, scale = 2)
    val price: BigDecimal,

    @Column(name = "start_date")
    val startDate: Date,

    @Column(name = "end_date")
    val endDate: Date
) {
        fun toPriceEntity() = PriceEntity(
            brand = brand.toBrandEntity(),
            product = product.toProductEntity(),
            priceList = priceList,
            priority = priority,
            price = price,
            currency = Currency.getCurrency(currency),
            startDate = startDate,
            endDate = endDate
        )
}