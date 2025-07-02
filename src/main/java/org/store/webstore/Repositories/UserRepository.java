package org.store.webstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.webstore.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
