package com.pocimp.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocimp.entity.Customer;
import com.pocimp.entity.Order;
import com.pocimp.entity.Product;
import com.pocimp.repository.OrderRepository;

@Service
public class OrderService {
	
@Autowired
   private OrderRepository orderRepository;
   
	 public List<Order> getAllOrders() {
	        return orderRepository.findAll();
	    }

	    public Order getOrderById(int id) {
	        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

   public Order createOrder(Order order) {
        
        return orderRepository.save(order);
   }
    
    public void deleteOrder(int id) {
       Order order = getOrderById(id);
       orderRepository.delete(order);
   }
    

//public Order updateOrder(int id, Order updatedOrder) {
//    Order existingOrder = getOrderById(id);
//    
//    if (existingOrder != null) {
//        // Update order properties with the values from updatedOrder
//        existingOrder.setProduct(updatedOrder.getProduct());
//        existingOrder.setCustomer(updatedOrder.getCustomer());
//        // Update other order properties if necessary
//        
//        // Save the updated order back to the repository
//        return orderRepository.save(existingOrder);
//    } else {
//        throw new EntityNotFoundException("Order not found with id: " + id);
//    }
//}
    }
	
	
	
	
