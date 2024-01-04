package br.com.inn.cafe.dao;

import br.com.inn.cafe.POJO.User;
import br.com.inn.cafe.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer > {

    User findByEmailId(@Param("email") String email);

    List<UserWrapper> getAllUser();

}
