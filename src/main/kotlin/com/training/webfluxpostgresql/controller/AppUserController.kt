package com.training.webfluxpostgresql.controller

import com.training.webfluxpostgresql.model.AppUser
import com.training.webfluxpostgresql.service.AppUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api")
class AppUserController (
    private val appUserService: AppUserService
        ) {

    @GetMapping("/users")
    fun getAll() : Flux<AppUser> = appUserService.findAll()
}