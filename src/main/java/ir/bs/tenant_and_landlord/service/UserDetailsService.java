package ir.bs.tenant_and_landlord.service;

import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;


public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService, UserService {

//    private final UserRepository repository;

//    private final PasswordEncoder passwordEncoder;

/*
    public MyUserDetailsService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
*/

    /*@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = repository.findByPhoneNumber(userName);

        user.orElseThrow(()-> new UsernameNotFoundException("کاربری با این نام کاربری یافت نشد!"));
        return *//*user.map(MyUserDetails::new).get()*//* null;
    }*/
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

    void register(LoginRegisterDTO registerDTO);

    User loadUserByPhoneNumber(String phoneNumber);

    User findByNationalCode(long nationalCode);
}
