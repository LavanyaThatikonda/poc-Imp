package com.pocimp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pocimp.entity.Customer;
import com.pocimp.entity.Order;
import com.pocimp.entity.Product;
import com.pocimp.service.CustomerService;
import com.pocimp.service.OrderService;
import com.pocimp.service.ProductService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	  @PostMapping("/create")
	    public Order createOrder(@RequestBody Order order) {
	     
	        Product product = productService.getProductById(order.getProduct().getId());
	        order.setProduct(product);
	        Customer Customer = customerService.getCustomerByName(order.getCustomer().getName());
	        order.setCustomer(Customer);
	        return orderService.createOrder(order);
	    }
	  @GetMapping("/orders/{id}")
	  public Order getOrderById(@PathVariable int orderId) {
	      return orderService.getOrderById(orderId);
	  }
	  @GetMapping("/orders")
	  public List<Order> getAllOrders() {
	      return orderService.getAllOrders();
	  }
	  
//	  @PutMapping("/orders/{orderId}")
//	  public Order updateOrder(@PathVariable int orderId, @RequestBody Order updatedOrder) {
//	      Order existingOrder = orderService.getOrderById(orderId);
//	      if (existingOrder != null) {
//	          // Update order details
//	          existingOrder.setProduct(updatedOrder.getProduct());
//	          existingOrder.setCustomer(updatedOrder.getCustomer());
//	          // Update other order properties if necessary
//	          
//	          return orderService.updateOrder(existingOrder);
//	      } else {
//	          // Handle order not found error
//	          return null;
//	      }
//	  }


      @DeleteMapping("/orders/{orderId}")
       public void deleteOrder(@PathVariable int orderId) {
    orderService.deleteOrder(orderId);
     }
   }
