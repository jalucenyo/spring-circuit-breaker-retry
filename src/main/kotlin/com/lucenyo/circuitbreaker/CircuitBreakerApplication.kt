package com.lucenyo.circuitbreaker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@SpringBootApplication
@EnableRetry
class CircuitBreakerApplication

fun main(args: Array<String>) {
  runApplication<CircuitBreakerApplication>(*args)
}



