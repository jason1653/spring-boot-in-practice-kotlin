package io.spring.ch03_database

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.sql.DataSource

@SpringBootTest
class Ch03DatabaseApplicationTests(
    @Autowired
    private val dataSource: DataSource,
) {

    @Test
    fun givenDatasourceAvailableWhenAccessDetailsThenExpectDetails() {
        println(dataSource.javaClass.name)
        assertThat(dataSource.javaClass.name).isEqualTo("com.zaxxer.hikari.HikariDataSource")
        assertThat(dataSource.connection.metaData.databaseProductName).isEqualTo("H2")
    }
}
