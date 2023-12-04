package io.spring.ch03_database_querydsl.repository

import io.spring.ch03_database_querydsl.model.Course
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : CrudRepository<Course, Long>, QuerydslPredicateExecutor<Course>
