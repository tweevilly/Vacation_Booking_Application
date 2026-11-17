package com.d288.tngu928.services;

import com.d288.tngu928.dto.Purchase;
import com.d288.tngu928.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
