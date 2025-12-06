package presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import domain.model.ShoppingItem
import domain.model.ShoppingList
import presentation.theme.AppColors

@Preview(showBackground = true)
@Composable
fun CarouselPreview(
){

// Shopping List: "Monthly Groceries"
    val groceryItems = listOf(
        ShoppingItem(id = 1, name = "Brown Rice", quantity = 5, unity = "kg", isChecked = true),
        ShoppingItem(id = 2, name = "Pinto Beans", quantity = 2, unity = "kg", isChecked = false),
        ShoppingItem(id = 3, name = "Extra Virgin Olive Oil", quantity = 1, unity = "bottle", isChecked = true),
        ShoppingItem(id = 4, name = "Coarse Salt", quantity = 1, unity = "package", isChecked = false),
        ShoppingItem(id = 5, name = "Ground Coffee", quantity = 2, unity = "packages", isChecked = false)
    )
    val shoppingListGroceries = ShoppingList(id = 101, name = "Monthly Groceries", items = groceryItems)

// Shopping List: "Weekly Market"
    val marketItems = listOf(
        ShoppingItem(id = 6, name = "Silver Banana", quantity = 1, unity = "dozen", isChecked = false),
        ShoppingItem(id = 7, name = "Tomato", quantity = 6, unity = "unit", isChecked = true),
        ShoppingItem(id = 8, name = "Onion", quantity = 4, unity = "unit", isChecked = true),
        ShoppingItem(id = 9, name = "Potato", quantity = 2, unity = "kg", isChecked = false),
        ShoppingItem(id = 10, name = "Lettuce", quantity = 1, unity = "unit", isChecked = false)
    )
    val shoppingListMarket = ShoppingList(id = 102, name = "Weekly Market", items = marketItems)

// Shopping List: "Weekend Barbecue"
    val barbecueItems = listOf(
        ShoppingItem(id = 11, name = "Picanha (Top Sirloin Cap)", quantity = 2, unity = "kg", isChecked = false),
        ShoppingItem(id = 12, name = "Toscana Sausage", quantity = 1, unity = "kg", isChecked = false),
        ShoppingItem(id = 13, name = "Chicken Wings (Drumettes)", quantity = 1, unity = "kg", isChecked = true),
        ShoppingItem(id = 14, name = "Charcoal", quantity = 1, unity = "bag", isChecked = false),
        ShoppingItem(id = 15, name = "Garlic Bread", quantity = 2, unity = "packages", isChecked = false)
    )
    val shoppingListBarbecue = ShoppingList(id = 103, name = "Weekend Barbecue", items = barbecueItems)

// Shopping List: "Cleaning Supplies"
    val cleaningItems = listOf(
        ShoppingItem(id = 16, name = "Dish Soap", quantity = 3, unity = "unit", isChecked = false),
        ShoppingItem(id = 17, name = "Bleach", quantity = 2, unity = "liters", isChecked = true),
        ShoppingItem(id = 18, name = "Washing Powder", quantity = 1, unity = "box", isChecked = false)
    )
    val shoppingListCleaning = ShoppingList(id = 104, name = "Cleaning Supplies", items = cleaningItems)

// --- FINAL LIST CONTAINING ALL SHOPPING LISTS ---
    val mockShoppingLists = listOf(
        shoppingListGroceries,
        shoppingListMarket,
        shoppingListBarbecue,
        shoppingListCleaning
    )

    Surface (
        color = AppColors.Cream,
        modifier = Modifier
    ){
        CarouselCard(mockShoppingLists)
    }
}

@Composable
fun CarouselCard(list: List<ShoppingList>){
    Column (
        modifier = Modifier
            .background(AppColors.Transparent)
    ){
        ButtonEditList("Editar listas de supermercado")
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(list) { shoppingList ->
                ListItemCard(
                    shoppingList = shoppingList,
                    //modifier = Modifier.width(400.dp)
                    modifier = Modifier.fillParentMaxWidth(fraction = 0.8f)
                )
            }
        }
    }
}

@Composable
fun ButtonEditList(text: String) {
    Button(
        colors = ButtonDefaults.buttonColors(AppColors.Transparent),
        onClick = {},
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ){
        Text(
            text = text,
            color = AppColors.Black,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(end = 8.dp)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = "Add",
            tint = AppColors.Black
        )
    }
}
