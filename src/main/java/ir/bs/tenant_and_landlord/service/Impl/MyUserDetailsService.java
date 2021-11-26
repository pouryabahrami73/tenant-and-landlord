package ir.bs.tenant_and_landlord.service.Impl;

import ir.bs.tenant_and_landlord.domain.MyUserDetails;
import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import ir.bs.tenant_and_landlord.repository.UserRepository;
import ir.bs.tenant_and_landlord.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService, UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public MyUserDetailsService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUserName(userName);

        user.orElseThrow(()-> new UsernameNotFoundException("کاربری با این نام کاربری یافت نشد!"));
        return /*user.map(MyUserDetails::new).get()*/ null;
    }
    /*@Override
    public User save(User user) {
        User savedUser = repository.save(user);
        return savedUser;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<User> findAllActiveOrInactive(boolean situation) {
        return repository.findAllByActive(situation);
    }

    @Override
    public List<User> findAllActiveOrInactiveByFirstname(boolean situation, String firstName) {
        return repository.findAllByActiveAndFirstName(false, firstName);
    }

    @Override
    public List<User> findAllActiveOrInactiveByLastName(boolean situation, String lastName) {
        return repository.findAllByActiveAndLastName(false, lastName);
    }

    @Override
    public List<User> findAllActiveOrInactiveByRoles(boolean situation, String roles) {
        return repository.findAllByActiveAndRoles(false, roles);
    }

    @Override
    public List<User> findAllActiveOrInactiveByFirstNameAndLastName(boolean situation, String firstName, String lastName) {
        return repository.findAllByActiveAndFirstNameAndLastName(false, firstName, lastName);
    }

    @Override
    public List<User> findAllActiveOrInactiveByFirstNameAndRoles(boolean situation, String firstName, String roles) {
        return repository.findAllByActiveAndFirstNameAndRoles(false, firstName, roles);
    }

    @Override
    public List<User> findAllActiveOrInactiveByLastNameAndRoles(boolean situation, String lastName, String roles) {
        return repository.findAllByActiveAndLastNameAndRoles(false, lastName, roles);
    }

    @Override
    public List<User> findAllActiveOrInactiveByFirstNameAndLastNameAndRoles(boolean situation, String firstName, String lastName, String roles) {
        return repository.findAllByActiveAndFirstNameAndLastNameAndRoles(false, firstName, lastName, roles);
    }

    @Override
    public String hashPass(String pass) {
        String passWord = passwordEncoder.encode(pass);
        return passWord;
    }*/

    @Override
    public void register(LoginRegisterDTO registerDTO) {

    }

    @Override
    public User findByUserName(String name) {
        try {
            return repository.findByUserName(name).get();
        }catch (NoSuchElementException e){
            LoggerFactory.getLogger(MyUserDetails.class).warn("no value");
        }
        return null;
    }

    @Override
    public User findByNationalCode(long nationalCode) {
        return repository.findByNationalCode(nationalCode);
    }
}
