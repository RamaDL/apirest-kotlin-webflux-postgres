package com.training.webfluxpostgresql.service

import com.training.webfluxpostgresql.model.AppUser
import com.training.webfluxpostgresql.repository.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class AppUserService (
    private val appUserRepository : AppUserRepository
){
    fun findAll(): Flux<AppUser> = appUserRepository.findAll()
}