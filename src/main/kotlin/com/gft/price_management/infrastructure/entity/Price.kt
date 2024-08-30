package com.gft.price_management.infrastructure.entity

import jakarta.persistence.*
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

    val price: Number,

    @Column(name = "start_date")
    val startDate: Date,

    @Column(name = "end_date")
    val endDate: Date
)