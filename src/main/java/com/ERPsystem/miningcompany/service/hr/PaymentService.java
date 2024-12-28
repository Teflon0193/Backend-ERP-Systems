package com.ERPsystem.miningcompany.service.hr;

import com.ERPsystem.miningcompany.Entity.hr.Payment;

import com.ERPsystem.miningcompany.Repository.hr.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    // Create a new payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by ID
    public Payment getPaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isEmpty()) {
            throw new RuntimeException("Payment not found with ID: " + id);
        }
        return payment.get();
    }

    // Get payments by employee ID
    public List<Payment> getPaymentsByEmployeeId(Long employeeId) {
        return paymentRepository.findByEmployeeId(employeeId);
    }

    // Get payments by month
    public List<Payment> getPaymentsByMonth(String month) {
        return paymentRepository.findByMonth(month);
    }

    // Update an existing payment
    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment existingPayment = getPaymentById(id);
        existingPayment.setEmployee(updatedPayment.getEmployee());
        existingPayment.setMonth(updatedPayment.getMonth());
        existingPayment.setAmountPaid(updatedPayment.getAmountPaid());
        return paymentRepository.save(existingPayment);
    }

    // Delete a payment
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

}
