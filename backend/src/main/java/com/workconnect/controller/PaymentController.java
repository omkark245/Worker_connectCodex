package com.workconnect.controller;

import com.workconnect.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @PostMapping("/razorpay/order")
    public ApiResponse createOrder(@RequestParam Long workerId, @RequestParam Integer amountInr) {
        return ApiResponse.ok("Razorpay order created",
                Map.of("workerId", workerId,
                        "amountInr", amountInr,
                        "orderId", "order_" + UUID.randomUUID()));
    }

    @PostMapping("/razorpay/verify")
    public ApiResponse verifyPayment(@RequestBody Map<String, String> payload) {
        return ApiResponse.ok("Payment verified (stub, add signature verification in production)", payload);
    }
}
