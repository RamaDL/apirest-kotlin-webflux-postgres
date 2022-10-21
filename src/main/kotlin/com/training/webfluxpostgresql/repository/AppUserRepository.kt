package com.training.webfluxpostgresql.repository

import com.training.webfluxpostgresql.model.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AppUserRepository : ReactiveCrudRepository<AppUser, Long>