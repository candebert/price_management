package com.gft.price_management.infrastructure.entity

import com.gft.price_management.domain.entity.ProductEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "product")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String
) {
    fun toProductEntity() = ProductEntity(id, name)
}
