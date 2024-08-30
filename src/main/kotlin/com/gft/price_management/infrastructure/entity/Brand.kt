package com.gft.price_management.infrastructure.entity

import jakarta.persistence.*

@Entity
@Table(name = "brand")
data class Brand(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String
)
