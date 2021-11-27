package ir.bs.tenant_and_landlord.service.Impl;

import ir.bs.tenant_and_landlord.domain.MyUserDetails;
import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import ir.bs.tenant_and_landlord.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 10:03 PM
 */

@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    private final UserRepository repository;


    public MyUserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Optional<User> user = repository.findByPhoneNumber(phoneNumber);

        user.orElseThrow(()-> new UsernameNotFoundException("کاربری با این نام کاربری یافت نشد!"));
        return /*user.map(MyUserDetails::new).get()*/ null;
    }

    @Override
    public void register(LoginRegisterDTO registerDTO) {
        UserDetails userDetails = loadUserByUsername(registerDTO.getMobileNumber());
    }

    @Override
    public User loadUserByPhoneNumber(String phoneNumber) {
        try {
            return repository.findByPhoneNumber(phoneNumber).get();
        }catch (NoSuchElementException e){
            LoggerFactory.getLogger(MyUserDetails.class).warn("no value");
        }
        return null;
    }

    @Override
    public User findByNationalCode(long nationalCode) {
        return null;
    }
}
