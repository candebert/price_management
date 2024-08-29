package com.gft.price_management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
@SpringBootApplication
@ComponentScan(basePackages = ["com.gft.price_management"])

class PriceManagementApplication

fun main(args: Array<String>) {
	runApplication<PriceManagementApplication>(*args)
}
