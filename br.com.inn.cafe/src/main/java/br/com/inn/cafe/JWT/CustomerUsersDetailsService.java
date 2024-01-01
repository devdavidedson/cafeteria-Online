package br.com.inn.cafe.JWT;

import br.com.inn.cafe.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Objects;

public class CustomerUsersDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    private br.com.inn.cafe.POJO.User userDetails;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetails = userDao.findByEmailId(username);
        if (!Objects.isNull(userDetails))
            return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
        else
            throw new UsernameNotFoundException("Usuário não encontrado.");
        
    }
}
