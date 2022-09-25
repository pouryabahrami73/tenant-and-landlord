package ir.bs.tenant_and_landlord.service.Impl;

import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import ir.bs.tenant_and_landlord.domain.mapper.UserMapper;
import ir.bs.tenant_and_landlord.exception.AuthenticationException;
import ir.bs.tenant_and_landlord.repository.UserRepository;
import ir.bs.tenant_and_landlord.service.CustomUserDetailsService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
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
public class UserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);


    public UserDetailsServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Optional<User> user = repository.findByPhoneNumber(phoneNumber);

        return /*user.map(MyUserDetails::new).get()*/ null;
    }

    @Override
    public void tryToRegister(LoginRegisterDTO registerDTO) {
        if (checkIfUserIsPresent(registerDTO)) {
            throw new AuthenticationException("کاربری با این شماره قبلا ثبت نام کرده", HttpStatus.NOT_ACCEPTABLE);
        } else {
            registerUser(registerDTO);
        }
    }

    private void registerUser(LoginRegisterDTO registerDTO) {
        User user = userMapper.toEntity(registerDTO, passwordEncoder);
        repository.save(user);
    }

    private boolean checkIfUserIsPresent(LoginRegisterDTO registerDTO) {
        Optional<User> user = loadUserByPhoneNumber(registerDTO.getPhoneNumber());
        return user.isPresent();
    }

    @Override
    public Optional<User> loadUserByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public User findByNationalCode(long nationalCode) {
        return null;
    }
}
