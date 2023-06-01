package com.apple.io.controller;

import com.apple.io.dto.checkout.CheckoutItemDto;
import com.apple.io.dto.checkout.StripeResponse;
import com.apple.io.service.impl.AuthenticationServiceImpl;
import com.apple.io.service.impl.OrderServiceImpl;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @Autowired
    private OrderServiceImpl orderService;

    //stripe session checkout api

    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList)
            throws StripeException {
        Session session = orderService.createSession(checkoutItemDtoList);
        StripeResponse stripeResponse = new StripeResponse(session.getId());
        return new ResponseEntity<>(stripeResponse, HttpStatus.OK);
    }
}
