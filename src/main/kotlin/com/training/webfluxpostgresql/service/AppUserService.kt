package com.training.webfluxpostgresql.service

import com.training.webfluxpostgresql.model.AppUSerRequest
import com.training.webfluxpostgresql.model.AppUser
import com.training.webfluxpostgresql.model.BadRequestException
import com.training.webfluxpostgresql.model.NotFoundException
import com.training.webfluxpostgresql.repository.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AppUserService (
    private val appUserRepository : AppUserRepository
){
    fun findAll(): Flux<AppUser> = appUserRepository.findAll()

    fun findById(id: Long) : Mono<AppUser> =
        appUserRepository.findById(id).switchIfEmpty(
            Mono.error(
                NotFoundException("User with id $id was not found.")
            )
        )

    fun createUser(appUSerRequest: AppUSerRequest): Mono<AppUser> =
        appUserRepository.findByEmail(appUSerRequest.email).flatMap<AppUser?> {
            Mono.error<AppUser>(
                BadRequestException("User with email ${appUSerRequest.email} already exists.")
            )
        }.switchIfEmpty(
            appUserRepository.save(
                AppUser(
                    name = appUSerRequest.name,
                    email = appUSerRequest.email
                )
            )
        )
}