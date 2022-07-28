//package pl.coderslab;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import pl.coderslab.security.User;
//import pl.coderslab.security.UserRepository;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//@Service
//public class UserServiceImpl implements UserService {
//   private final BCryptPasswordEncoder passwordEncoder;
//    private final RoleRepository roleRepository;
//    private final UserRepository userRepository;
//
//    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository, UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.roleRepository = roleRepository;
//        this.userRepository = userRepository;
//    }
//    @Override
//    public User findByEmail(String email) {
//        return userRepository.findByEmail (email);
//    }
//
//    @Override
//    public User findByUserName(String username) {
//        return userRepository.findByName (username);
//    }
//
//    @Override
//    public void saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Role userRole = roleRepository.findByName("ROLE_USER");
//        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
//        userRepository.save(user);
//    }
//}