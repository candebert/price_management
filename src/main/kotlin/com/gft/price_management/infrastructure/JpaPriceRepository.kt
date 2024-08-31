package com.gft.price_management.infrastructure

import com.gft.price_management.infrastructure.entity.Price
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface JpaPriceRepository : JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p " +
            "WHERE :currentDate BETWEEN p.startDate " +
            "AND p.endDate AND p.product.id = :productId " +
            "AND p.brand.id = :brandId " +
            "ORDER BY p.priority DESC")
    fun findBy(
        @Param("currentDate") currentDate: Date,
        @Param("brandId") brandId: Int,
        @Param("productId") productId: Long
    ): List<Price>
}