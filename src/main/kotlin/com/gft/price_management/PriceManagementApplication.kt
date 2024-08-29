package com.gft.price_management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
@SpringBootApplication
@ComponentScan(basePackages = ["org.openapitools", "org.openapitools.api", "org.openapitools.model"])

class PriceManagementApplication

fun main(args: Array<String>) {
	runApplication<PriceManagementApplication>(*args)
}
