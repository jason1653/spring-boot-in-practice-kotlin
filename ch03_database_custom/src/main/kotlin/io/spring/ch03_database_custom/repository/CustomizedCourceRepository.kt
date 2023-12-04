package io.spring.ch03_database_custom.repository

import io.spring.ch03_database_custom.model.Course

interface CustomizedCourceRepository : BaseRepository<Course, Long>
