package com.lucenyo.circuitbreaker

import org.slf4j.LoggerFactory
import org.springframework.retry.annotation.CircuitBreaker
import org.springframework.retry.annotation.Recover
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class UserClient {

  private val log = LoggerFactory.getLogger(this.javaClass)

  // Si se producen 10 errores (maxAttempts) en medio minuto (openTimeOut), se abre el circuito durante 1 minuto(resetTimeout).
  @CircuitBreaker(maxAttempts = 10, openTimeout = 30000, resetTimeout = 60000)
  fun findUsers(): List<User>{
    log.info("Find users")
    return (RestTemplate())
      .getForObject("https://randomuser.me/api1", Results::class.java)!!.results!!
  }

  // La firma del metodo tiene que ser igual al metodo del circuitBreaker e incluir la excepcion.
  @Recover
  fun recover(e: Throwable): List<User>{
    log.info("Recover method of circuit breaker")
    log.error("Exception: ", e.message)
    return listOf(User(name = Name(title = "Mr.", first = "Fallback", last = ":-)")))
  }

}