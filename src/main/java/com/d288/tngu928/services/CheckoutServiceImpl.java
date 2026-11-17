package com.d288.tngu928.services;

import com.d288.tngu928.dao.CartRepository;
import com.d288.tngu928.dto.Purchase;
import com.d288.tngu928.dto.PurchaseResponse;
import com.d288.tngu928.entities.Cart;
import com.d288.tngu928.entities.CartItem;
import com.d288.tngu928.entities.Customer;
import com.d288.tngu928.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
    
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase){

        //retrieve the  order info from dto
        Cart cart = purchase.getCart();

        //generate tracking number
        String cartTrackingNumber = generateCartTrackingNumber();
        cart.setOrderTrackingNumber(cartTrackingNumber);

        // populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        // populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        // save to database
        cart.setStatus(StatusType.ordered);
        cartRepository.save(cart);

        // return a response
        return new PurchaseResponse(cartTrackingNumber); //add final to final String PurchaseResponse.java
    }

    private String generateCartTrackingNumber() {
        // random UUID (UUID version-4)...universal unique ID
        //low collision
        return UUID.randomUUID().toString();
    }

}
