import org.junit.Before;
import org.junit.Test;
import tech.strategio.Product;
import tech.strategio.ProductNotFoundException;
import tech.strategio.ShoppingCart;

import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartTest {


    ShoppingCart test_cart;

    @Before
    public void createObject() {
        test_cart = new ShoppingCart(); //shopping cart with one object
    }
    @Test
    public void defaultItems() {
        assertEquals(0, test_cart.getItemCount());
    }

    @Test
    public void addItem() {
        //tests if item incrementation works
        test_cart.addItem(new Product("Apple", 2.99));
        assertEquals(1,test_cart.getItemCount());
        test_cart.addItem(new Product("Banana", 0.69));
        assertEquals(2,test_cart.getItemCount());

    }

    @Test
    public void addItemPrice() {
        //tests if item price summation works
        test_cart.addItem(new Product("Apple", 2.99));
        assertEquals(2.99,test_cart.getBalance());
        test_cart.addItem(new Product("Banana", 0.69));
        assertEquals(3.68,test_cart.getBalance());
    }

    @Test
    public void emptyCart() {
        //add 2 items and then remove them all with empty() method.
        test_cart.addItem(new Product("Apple", 2.99));
        test_cart.addItem(new Product("Banana", 0.69));
        assertEquals(2,test_cart.getItemCount());
        test_cart.empty();
        assertEquals(0, test_cart.getItemCount());
    }

    @Test
    public void removeItem() throws ProductNotFoundException {
        //add 1 item, remove it, the item count should be 0.
        Product product = new Product("Apple", 2.99);
        test_cart.addItem(product);
        assertEquals(1,test_cart.getItemCount());
        test_cart.removeItem(product);
        assertEquals(0, test_cart.getItemCount());
    }

    @Test
    public void removeItemNotFound() {
        Product product = new Product("Apple", 2.99);
        try {
            test_cart.removeItem(product);
            fail("Exception was not thrown");
        } catch (ProductNotFoundException e) {
            System.out.println("Error: The product was not found.");
        }
    }



}
