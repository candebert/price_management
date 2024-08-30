package com.gft.price_management.infrastructure

import com.gft.price_management.infrastructure.entity.Brand
import com.gft.price_management.infrastructure.entity.Price
import com.gft.price_management.infrastructure.entity.Product
import jakarta.transaction.Transactional
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import java.util.*

@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PriceRepositoryImplTest {

    @Autowired
    private lateinit var testEntityManager: TestEntityManager
    @Autowired
    private lateinit var priceRepositoryImpl: PriceRepositoryImpl

    private lateinit var brand: Brand
    private lateinit var product: Product

    @Test
    @Transactional
    @Rollback
    fun getPriceTest() {
        brand = testEntityManager.persist(Brand(name =  "Inditest"))
        product = testEntityManager.persist(Product(name =  "TestShirt"))
        val price = testEntityManager.persist(
            Price(
                brand = brand,
                product = product,
                price = 30.5,
                priceList = 1,
                priority = 1,
                currency = "EUR",
                startDate = Date(2024, 6, 5, 8, 30),
                endDate = Date(2024, 7, 5, 19, 30)
            )
        )
        testEntityManager.flush()

        assertThrows<NotImplementedError> {
            priceRepositoryImpl
                .get(Date(2024, 6, 30, 8, 30), 1, 1)
        }
    }
}