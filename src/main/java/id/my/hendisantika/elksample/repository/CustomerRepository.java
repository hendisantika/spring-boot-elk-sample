package id.my.hendisantika.elksample.repository;

import id.my.hendisantika.elksample.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
