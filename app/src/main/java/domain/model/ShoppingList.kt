package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ShoppingList(
    val id: Int,
    val name: String,
    val items: List<ShoppingItem>
)
