package domain.model

data class ShoppingList(
    val id: Int,
    val name: String,
    val items: List<ShoppingItem>
)
