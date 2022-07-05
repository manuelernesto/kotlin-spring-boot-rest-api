package io.github.manuelernesto.demoplayersapi.service

import io.github.manuelernesto.demoplayersapi.model.Player
import io.github.manuelernesto.demoplayersapi.repository.PlayerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  05/07/22 8:46 PM
 * @version 1.0
 */

@Service
class PlayerService(val repository: PlayerRepository) {

    fun getAll(): List<Player> = repository.findAll()

    fun getById(id: Long): Player = repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(player: Player): Player = repository.save(player)

    fun remove(id: Long) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, player: Player): Player {
        return if (repository.existsById(id)) {
            player.id = id
            repository.save(player)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}
