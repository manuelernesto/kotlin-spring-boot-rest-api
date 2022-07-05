package io.github.manuelernesto.demoplayersapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlayersApiApplication

fun main(args: Array<String>) {
    runApplication<PlayersApiApplication>(*args)
}
