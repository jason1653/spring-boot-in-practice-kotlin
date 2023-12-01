package io.spring.ch03_mongodb

import com.mongodb.BasicDBObjectBuilder
import com.mongodb.DBObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate

@SpringBootTest
class Ch03MongodbApplicationTests(
    @Autowired
    private val mongoTemplate: MongoTemplate
) {

    @Test
    fun contextLoads() {
    }

    @Test
    fun testMongoTemplate() {
        val objects = BasicDBObjectBuilder
            .start()
            .add("Manning", "Spring Boot In Practice")
            .get()

        mongoTemplate.save(objects, "collection")

        assertThat(mongoTemplate.findAll(DBObject::class.java, "collection"))
            .extracting("Manning")
            .containsOnly("Spring Boot In Practice")
    }
}
