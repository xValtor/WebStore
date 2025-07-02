package org.store.webstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.webstore.Entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
