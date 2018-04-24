package ltd.repository;

import ltd.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 用户
 *
 * songshu 2017/11/23 15:17
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
