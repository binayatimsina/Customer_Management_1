package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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
        System.out.println("hi");
        assertNotNull(customerRepository.findAll());
        assertEquals(customerRepository.findAll(), customerList);

    }
}
