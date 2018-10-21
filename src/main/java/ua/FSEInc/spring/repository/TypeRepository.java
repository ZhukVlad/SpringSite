package ua.FSEInc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.FSEInc.domain.Type;
import ua.FSEInc.enums.Gender;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
	List<Type> findByGender (Gender gender);
}
