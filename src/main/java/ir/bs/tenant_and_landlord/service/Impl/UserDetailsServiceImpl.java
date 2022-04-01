package ir.bs.tenant_and_landlord.service.Impl;

import ir.bs.tenant_and_landlord.domain.UserDetails;
import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import ir.bs.tenant_and_landlord.repository.UserRepository;
import ir.bs.tenant_and_landlord.service.UserDetailsService;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 10:03 PM
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;


    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Optional<User> user = repository.findByPhoneNumber(phoneNumber);

        user.orElseThrow(()-> new UsernameNotFoundException("کاربری با این نام کاربری یافت نشد!"));
        return /*user.map(MyUserDetails::new).get()*/ null;
    }

    @Override
    public void register(LoginRegisterDTO registerDTO) {
        org.springframework.security.core.userdetails.UserDetails userDetails = loadUserByUsername(registerDTO.getMobileNumber());
    }

    @Override
    public User loadUserByPhoneNumber(String phoneNumber) {
        try {
            return repository.findByPhoneNumber(phoneNumber).get();
        }catch (NoSuchElementException e){
            LoggerFactory.getLogger(UserDetails.class).warn("no value");
        }
        return null;
    }

    @Override
    public User findByNationalCode(long nationalCode) {
        return null;
    }
}
