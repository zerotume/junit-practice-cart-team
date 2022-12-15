# JUnit Shopping Cart Exercise

This task is in beta. Send a message to Ernie for any feedback and constructive criticism.

Based on a project by Filippo Ricca DISI, Università di Genova, Italy.

## Instructions


As this is not a submittable assignment, feel free to pair or mob program with other Technologists as needed.

1. Clone this repo and run the code on an IDE of your choice (this is _not_ a GitHub Classroom repo, so cloning directly is fine)
2. Use Google find out how to use Maven to install JUnit and create unit tests.
3. Create JUnit tests to fill the product specifications below.

## Product Specifications
 - When created, the cart has 0 items 
 - When empty, the cart has 0 items 
 - When a new product is added, the number of items must be
incremented 
 - When a new product is added, the new balance must be the sum of the
previous balance plus the cost of the new product 
 - When an item is removed, the number of items must be decreased 
 - When a product not in the cart is removed, a
`ProductNotFoundException` must be thrown 
   - Hint: insert the call in a `try` block and put a `fail()` after the call to
`removeItem()`

