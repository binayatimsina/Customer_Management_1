package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    
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
        when(customerRepository.findAll()).thenReturn(customerList);
        assertNotNull(customerService.getAllCustomers());
        assertEquals(customerService.getAllCustomers(), customerList);
    }

    @Test
    public void testGetCustomerByID() {
        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(customerList.get(0)));
        assertNotNull(customerService.getCustomerByID(1));
        assertEquals(customerService.getCustomerByID(1).get(), customerList.get(0));
    }

    @Test
    public void testCreateCustomer() {
        Customer c4 = new Customer(4, "Ben John");
        customerList.add(c4);
        when(customerRepository.save(any(Customer.class))).thenReturn(c4);
        assertNotNull(customerService.addCustomer("Ben John"));
        assertEquals(customerService.addCustomer("Ben John"), c4);
    }

    @Test
    public void testUpdateCustomer() {
        Customer c5 = new Customer(4, "Binaya");
        customerList.add(c5);
        when(customerRepository.findById(4L)).thenReturn(java.util.Optional.ofNullable(customerList.get(3)));
        when(customerRepository.save(any(Customer.class))).thenReturn(c5);
        assertEquals(customerService.updateCustomer("Binaya", 4), c5);
    }

    @Test
    public void testDeleteCustomer() {
        when(customerRepository.findById(any())).thenReturn(null);
        assertEquals(customerService.deleteCustomer(1L), true);
    }

    @Test
    public void testPurchase() {
        Customer c6 = new Customer(6, "Binaya");
        customerList.add(c6);
        when(customerRepository.findById(6L)).thenReturn(java.util.Optional.ofNullable(customerList.get(3)));
        customerService.purchase(100.0, 6);
        assertEquals(customerList.get(3).getTotalSales(), 100.0);
    }

    @Test
    public void testPurchaseWithCredit() {
        Customer c7 = new Customer(7, "Binaya");
        customerList.add(c7);
        when(customerRepository.findById(7L)).thenReturn(java.util.Optional.ofNullable(customerList.get(3)));
        customerService.purchaseWithCredit(100.0, 7);
        assertEquals(customerList.get(3).getBalanceDue(), 100.0);
    }

}
