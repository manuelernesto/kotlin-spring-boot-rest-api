package io.github.manuelernesto.playersapi.model

import jakarta.persistence.*


/**
 * @author  Manuel Ernesto (manuelernest0)
 * @date  05/07/22 8:44 PM
 * @version 1.0
 */

@Entity
@Table(name = "tb_player")
data class Player(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
    val name: String,
    val age: Int,
    val nationality: String
)