package ir.bs.tenant_and_landlord.service.Impl;

import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import ir.bs.tenant_and_landlord.repository.UserRepository;
import ir.bs.tenant_and_landlord.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 10:03 PM
 */

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService, UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public MyUserDetailsServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
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
    public User findByUserName(String name) {
        return null;
    }

    @Override
    public User findByNationalCode(long nationalCode) {
        return null;
    }
}
