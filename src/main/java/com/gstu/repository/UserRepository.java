package com.gstu.repository;

import com.gstu.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
*
* TODO
* */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    /*
     * Находим пользователя по его имени. Используем в регитсрации
     * */
    User findByUsername(String username);
}
