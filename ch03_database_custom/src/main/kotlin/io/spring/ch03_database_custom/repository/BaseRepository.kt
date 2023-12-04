package io.spring.ch03_database_custom.repository

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository

@NoRepositoryBean
interface BaseRepository<T, ID> : Repository<T, ID> {
    fun <S : T?> save(entity: S): S

    fun findAll(): List<T>
}
