package com.gft.price_management.infrastructure

import com.gft.price_management.infrastructure.entity.Price
import org.springframework.data.jpa.repository.JpaRepository

interface JpaPriceRepository : JpaRepository<Price, Long>