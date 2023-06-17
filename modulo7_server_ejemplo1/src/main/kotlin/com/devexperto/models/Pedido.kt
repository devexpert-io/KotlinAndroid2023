package com.devexperto.models

import kotlinx.serialization.Serializable

@Serializable
data class Pedido(val number: String, val contents: List<PedidoItem>)

@Serializable
data class PedidoItem(val item: String, val amount: Int, val price: Double)


val pedidosStorage = listOf(
    Pedido("1443",
        listOf(
            PedidoItem("Patatas", 1, 1.0),
            PedidoItem("Palomitas", 5, 5.0),
            PedidoItem("Gusanitos", 13, 6.0)
        )
    ),
    Pedido("6545",
        listOf(
            PedidoItem("Acelgas", 1, 1.0),
            PedidoItem("Tomates", 5, 5.0),
            PedidoItem("Lechuga", 13, 6.0),
            PedidoItem("Brócoli", 13, 6.0),
            PedidoItem("Aceitunas", 13, 6.0),
            PedidoItem("Remolacha", 13, 6.0),
        )
    ),
    Pedido("2345",
        listOf(
            PedidoItem("Gaseosa", 1, 1.0),
            PedidoItem("Refresco de cola", 5, 5.0),
            PedidoItem("Bebida de Limón", 13, 6.0)
        )
    ),
    Pedido("1443",
        listOf(
            PedidoItem("Patatas", 1, 1.0),
            PedidoItem("Palomitas", 5, 5.0),
            PedidoItem("Gusanitos", 13, 6.0)
        )
    ),
    Pedido("6545",
        listOf(
            PedidoItem("Acelgas", 1, 1.0),
            PedidoItem("Tomates", 5, 5.0),
            PedidoItem("Lechuga", 13, 6.0),
            PedidoItem("Brócoli", 13, 6.0),
            PedidoItem("Aceitunas", 13, 6.0),
            PedidoItem("Remolacha", 13, 6.0),
        )
    ),
    Pedido("2345",
        listOf(
            PedidoItem("Gaseosa", 1, 1.0),
            PedidoItem("Refresco de cola", 5, 5.0),
            PedidoItem("Bebida de Limón", 13, 6.0)
        )
    ),
    Pedido("1443",
        listOf(
            PedidoItem("Patatas", 1, 1.0),
            PedidoItem("Palomitas", 5, 5.0),
            PedidoItem("Gusanitos", 13, 6.0)
        )
    ),
    Pedido("6545",
        listOf(
            PedidoItem("Acelgas", 1, 1.0),
            PedidoItem("Tomates", 5, 5.0),
            PedidoItem("Lechuga", 13, 6.0),
            PedidoItem("Brócoli", 13, 6.0),
            PedidoItem("Aceitunas", 13, 6.0),
            PedidoItem("Remolacha", 13, 6.0),
        )
    ),
    Pedido("2345",
        listOf(
            PedidoItem("Gaseosa", 1, 1.0),
            PedidoItem("Refresco de cola", 5, 5.0),
            PedidoItem("Bebida de Limón", 13, 6.0)
        )
    ),
)