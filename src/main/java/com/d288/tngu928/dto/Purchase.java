package com.d288.tngu928.dto;

import com.d288.tngu928.entities.Cart;
import com.d288.tngu928.entities.CartItem;
import com.d288.tngu928.entities.Customer;

import java.util.Set;

public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

    public Customer getCustomer() {
        return this.customer;
    }

    public Cart getCart() {
        return this.cart;
    }

    public Set<CartItem> getCartItems() {
        return this.cartItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
