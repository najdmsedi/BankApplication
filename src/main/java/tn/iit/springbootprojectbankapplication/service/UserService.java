package tn.iit.springbootprojectbankapplication.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.iit.springbootprojectbankapplication.dao.UserDao;
import tn.iit.springbootprojectbankapplication.entity.User;
import tn.iit.springbootprojectbankapplication.exception.UserNotFoundException;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User saveUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userDao.save(user);
    }

    public Optional<User> findUser(String userName){
        return userDao.findByUsername(userName);
    }
    public ResponseEntity<Integer> login(User user) {
        User userToFind = findUser(user.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        String encodedPassword = userToFind.getPassword();
        boolean isPwdRight = passwordEncoder.matches(user.getPassword(), encodedPassword);

        if (!isPwdRight) {
            throw new UserNotFoundException("Password user does not match");
        }

        return ResponseEntity.ok().body(userToFind.getId());
    }



}
