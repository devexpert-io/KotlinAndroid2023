package com.devexperto.modulo7_client_ej1.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Pedido(val number: String, val contents: List<PedidoItem>)

@Serializable
data class PedidoItem(val item: String, val amount: Int, val price: Double)