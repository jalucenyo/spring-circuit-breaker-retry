package com.lucenyo.circuitbreaker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UsersController(
  val userClient: UserClient
) {

  @GetMapping("/users")
  fun getUser(): List<User> {
    return userClient.findUsers()
  }

}