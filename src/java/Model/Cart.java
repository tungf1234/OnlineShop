package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The Cart class represents a shopping cart that holds a list of items.
 * It allows users to add, remove, and modify the quantity of items in the cart.
 *
 * @author msi
 */
public class Cart {

    private List<Item> items;

    /**
     * Default constructor for the Cart class.
     */
    public Cart() {
    }

    /**
     * Constructor to create a Cart with a list of items.
     *
     * @param items The list of items in the cart.
     */
    public Cart(List<Item> items) {
        this.items = items;
    }

    /**
     * Get the list of items in the cart.
     *
     * @return The list of items.
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Set the list of items in the cart.
     *
     * @param items The list of items to set.
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Get the quantity of an item in the cart by its ID.
     *
     * @param id The ID of the item.
     * @return The quantity of the item.
     */
    public int getQuantityById(String id) {
        return getItemById(id).getQuantity();
    }

    private Item getItemById(String id) {
        for (Item i : items) {
            if (i.getProduct().getProductId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Add an item to the cart or update the quantity if it already exists.
     *
     * @param item The item to add or update.
     */
    public void addItem(Item item) {
        if (getItemById(item.getProduct().getProductId()) != null) {
            Item existingItem = getItemById(item.getProduct().getProductId());
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.add(item);
        }
    }

    /**
     * Change the quantity of an item in the cart.
     *
     * @param productId The ID of the item to change.
     * @param quantity  The new quantity of the item.
     * @throws Throwable If the item is not found in the cart.
     */
    public void changeQuantity(String productId, int quantity) throws Throwable {
        if (quantity == 0) {
            return;
        }

        Item selectedItem = this.items.stream()
                .filter(i -> i.getProduct().getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> { throw new NoSuchElementException(); });
        int selectedItemIndex = items.indexOf(selectedItem);
        int newQuantity = selectedItem.getQuantity() + quantity;

        if (newQuantity < 1) {
            this.removeItem(productId);
        } else {
            selectedItem.setQuantity(newQuantity);
            items.set(selectedItemIndex, selectedItem);
        }
    }

    /**
     * Remove an item from the cart by its ID.
     *
     * @param id The ID of the item to remove.
     */
    public void removeItem(String id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    /**
     * Calculate the total cost of all items in the cart.
     *
     * @return The total cost of all items in the cart.
     */
    public double getTotalMoney() {
        double total = 0;
        for (Item item : items) {
            total += (item.getQuantity() * item.getProduct().getProductPrice());
        }
        return total;
    }

    private Product getProductById(String id, List<Product> list) {
        for (Product product : list) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Construct a Cart from a text representation and a list of products.
     *
     * @param txt  The text representation of the cart.
     * @param list The list of products to associate with items in the cart.
     */
    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] itemStrings = txt.split("/");
                for (String itemString : itemStrings) {
                    String[] parts = itemString.split(":");

                    String id = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    Product product = getProductById(id, list);
                    Item item = new Item(product, quantity, product.getProductPrice() * 2);
                    addItem(item);
                }
            }
        } catch (NumberFormatException e) {
            // Handle NumberFormatException if necessary
        }
    }
}
