package org.egorov.repository;

import org.egorov.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends JpaRepository<Good, Long> {

    @Query(value = "select category_id " +
            "from goods " +
            "where id = :goodId", nativeQuery = true)
    Long findCategoryId(Long goodId);

    @Query(value = "select number_days_storage " +
            "from expiration_date " +
            "where category_id = :categoryId and place_id = :placeId", nativeQuery = true)
    Integer findExpirationDate(Long categoryId, Long placeId);
}
