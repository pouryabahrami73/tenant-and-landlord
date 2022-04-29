package ir.bs.tenant_and_landlord.service.Impl;

import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import ir.bs.tenant_and_landlord.domain.mapper.UserMapper;
import ir.bs.tenant_and_landlord.exception.AuthenticationException;
import ir.bs.tenant_and_landlord.repository.UserRepository;
import ir.bs.tenant_and_landlord.service.UserDetailsService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 10:03 PM
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);


    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Optional<User> user = repository.findByPhoneNumber(phoneNumber);

        return /*user.map(MyUserDetails::new).get()*/ null;
    }

    @Override
    public void register(LoginRegisterDTO registerDTO) {
        checkIfUserIsPresent(registerDTO);
        registerUser(registerDTO);
    }

    private void registerUser(LoginRegisterDTO registerDTO) {
        User user = userMapper.toEntity(registerDTO);
        repository.save(user);
    }

    private void checkIfUserIsPresent(LoginRegisterDTO registerDTO) {
        Optional<User> user = loadUserByPhoneNumber(registerDTO.getPhoneNumber());
        user.ifPresent(user1 -> {
            String msg = String.format("کاربری با شماره ٪s قبلا ثبت نام کرده", user.get().getPhoneNumber());
            throw new AuthenticationException(msg, HttpStatus.NOT_ACCEPTABLE);
        });
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
