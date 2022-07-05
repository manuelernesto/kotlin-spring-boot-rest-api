package io.github.manuelernesto.demoplayersapi.controller

import io.github.manuelernesto.demoplayersapi.model.Player
import io.github.manuelernesto.demoplayersapi.service.PlayerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  19/06/22 10:38 AM
 * @version 1.0
 */


@RequestMapping("api/v1/players")
@RestController
class PlayerController(val service: PlayerService) {

    @GetMapping
    fun getAllPlayers() = service.getAll()

    @GetMapping("/{id}")
    fun getPlayer(@PathVariable id: Long) = service.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePlayer(@RequestBody player: Player): Player = service.create(player)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePlayer(@PathVariable id: Long) = service.remove(id)

    @PutMapping("/{id}")
    fun updatePlayer(
        @PathVariable id: Long, @RequestBody player: Player
    ) = service.update(id, player)
}