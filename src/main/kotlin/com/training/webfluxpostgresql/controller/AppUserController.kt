package com.training.webfluxpostgresql.controller

import com.training.webfluxpostgresql.model.AppUSerRequest
import com.training.webfluxpostgresql.model.AppUser
import com.training.webfluxpostgresql.service.AppUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class AppUserController (
    private val appUserService: AppUserService
        ) {

    @GetMapping("/users")
    fun getAll() : Flux<AppUser> = appUserService.findAll()

    @GetMapping("/users/{id}")
    fun getById(@PathVariable id: Long) : Mono<AppUser> = appUserService.findById(id)

//    @GetMapping("/users/{anotherName}")
//    fun getByIdWithBinding(@PathVariable("anotherName") id: Long) : Mono<AppUser> = appUserService.findById(id)

    @PostMapping("/users")
    fun createUser(@RequestBody appUSerRequest: AppUSerRequest) : Mono<AppUser> =
        appUserService.createUser(appUSerRequest)
}