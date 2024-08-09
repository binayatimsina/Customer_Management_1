package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.inject.Inject;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private List<Customer> customerList;

    @BeforeEach
    public void setup() {
        customerList = new ArrayList<Customer>();
        Customer c1 = new Customer(1, "John Doe");
        Customer c2 = new Customer(2, "Jane Adams");
        Customer c3 = new Customer(3, "Alice Jones");
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
    }


    @Test
    public void testGetAllCustomers() {
        when(customerService.getAllCustomers()).thenReturn(customerList);        
        assertNotNull(customerController.getAllCustomers());
        assertEquals(customerList, customerController.getAllCustomers());

    }

    @Test
    public void testGetCustomerById() {
        when(customerService.getCustomerByID(1L)).thenReturn(java.util.Optional.ofNullable(customerList.get(0)));
        assertNotNull(customerController.getCustomerById(1L));
        assertEquals(customerList.get(0), customerController.getCustomerById(1L));
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer(4, "Binaya Timsina");
        customerList.add(customer);
        when(customerService.addCustomer("Binaya Timsina")).thenReturn(customer);
        Map<String, String> body = new HashMap<>();
        body.put("name", "Binaya Timsina");
        assertNotNull(customerController.createCustomer(body));
        assertEquals(customer, customerController.createCustomer(body));
    }

    @Test
    public void testUpdateCustomerList() {
        Customer customer = new Customer(1, "John Doe");
        customerList.remove(0);
        customerList.add(0, customer);
        when(customerService.updateCustomer("John Doe", 1L)).thenReturn(customer);
        Map<String, String> body = new HashMap<>();
        body.put("name", "John Doe");
        assertNotNull(customerController.updateCustomerList(body, 1L));
        assertEquals(customer, customerController.updateCustomerList(body, 1L));
    }

    @Test
    public void testDeleteCustomer() {
        when(customerService.deleteCustomer(anyLong())).thenReturn(true);
        assertEquals(true, customerController.deleteCustomer(1L));
    }

}
