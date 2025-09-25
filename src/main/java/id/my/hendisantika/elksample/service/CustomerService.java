package id.my.hendisantika.elksample.service;

import id.my.hendisantika.elksample.entity.Customer;
import id.my.hendisantika.elksample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-elk-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 25/09/25
 * Time: 16.56
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> listAllCustomers() {
        log.info("START - listAllCustomers");

        var customers = customerRepository.findAll();

        log.info("END - listAllCustomers");

        return customers;
    }
}
