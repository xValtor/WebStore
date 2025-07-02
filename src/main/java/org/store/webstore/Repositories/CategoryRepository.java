package org.store.webstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.store.webstore.Entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
