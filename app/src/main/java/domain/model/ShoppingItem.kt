package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ShoppingItem (
    val id: Int,
    val name: String,
    val quantity: Int,
    val unity: String,
    val isChecked: Boolean
)

