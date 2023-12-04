package io.spring.ch03_database_paging.repository

import io.spring.ch03_database_paging.model.Course
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : PagingAndSortingRepository<Course, Long>
