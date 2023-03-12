package org.egorov.repository;

import org.egorov.model.GoodLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodLocalRepository extends JpaRepository<GoodLocal, Long> {
}
