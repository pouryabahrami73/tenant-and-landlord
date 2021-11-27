package ir.bs.tenant_and_landlord.repository;

import ir.bs.tenant_and_landlord.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 10:20 PM
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
//    Optional<User> findByUserName(String userName);

    User findByNationalCode(long nationalCode);
}
