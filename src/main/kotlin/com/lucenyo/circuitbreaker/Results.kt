package com.lucenyo.circuitbreaker

data class Results(
  val results: List<User>? = null
)

data class User(
  val name: Name? = null
)

data class Name(
  val title: String? = null,
  val first: String? = null,
  val last: String? = null,
)
