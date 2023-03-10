import org.junit.Before;
import org.junit.Test;
import tech.strategio.Product;
import tech.strategio.ProductNotFoundException;
import tech.strategio.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartTest {

//
    ShoppingCart test_cart;
    Product apple;
    Product banana;

    @Before
    public void createObject() {
        test_cart = new ShoppingCart(); //shopping cart with one object
        apple = new Product("Apple", 2.99);
        banana = new Product("Banana", 0.69);
    }
    // When created, the cart has 0 items
    @Test
    public void defaultItems() {
        assertEquals(0, test_cart.getItemCount());
    }

    // When a new product is added, the number of items must be incremented
    @Test
    public void addItem() {
        //tests if item incrementation works
        test_cart.addItem(apple);
        assertEquals(1,test_cart.getItemCount());
        test_cart.addItem(banana);
        assertEquals(2,test_cart.getItemCount());

    }
// When a new product is added, the new balance must be the sum of the previous balance plus the cost of the new product
    @Test
    public void addItemPrice() {
        //tests if item price summation works
        test_cart.addItem(apple);
        assertEquals(2.99,test_cart.getBalance());
        test_cart.addItem(banana);
        assertEquals(3.68,test_cart.getBalance());
    }
    // When empty, the cart has 0 items
    @Test
    public void emptyCart() {
        //add 2 items and then remove them all with empty() method.
        test_cart.addItem(apple);
        test_cart.addItem(banana);
        assertEquals(2,test_cart.getItemCount());
        test_cart.empty();
        assertEquals(0, test_cart.getItemCount());
    }
// When an item is removed, the number of items must be decreased
    @Test
    public void removeItem() throws ProductNotFoundException {
        //add 1 item, remove it, the item count should be 0.
        //Product product = new Product("Apple", 2.99);
        test_cart.addItem(apple);
        assertEquals(1,test_cart.getItemCount());
        test_cart.removeItem(apple);
        assertEquals(0, test_cart.getItemCount());
    }

    // When a product not in the cart is removed, a ProductNotFoundException must be thrown
    @Test
    public void removeItemNotFound() {
        //Product product = new Product("Apple", 2.99);
        try {
            test_cart.removeItem(apple);
            fail("Exception was not thrown");
        } catch (ProductNotFoundException e) {
            System.out.println("Error: The product was not found.");
        }
    }



}
