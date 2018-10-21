package ua.FSEInc.spring.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.FSEInc.domain.Clothe;
import ua.FSEInc.enums.Gender;
import ua.FSEInc.enums.Size;

@Repository
public interface ClotheRepository extends JpaRepository<Clothe, Long> {

	Page<Clothe> findByPriceBetween(BigDecimal price1, BigDecimal price2, Pageable pageable);
	
	Page<Clothe> findByTypeId(Pageable pageable, long typeId);
	
	@Query("select new ua.FSEInc.domain.Clothe(c.id, c.name, c.gender, c.type, c.size, c.price, c.color, c.material, c.image, c.descr, c.avgRating, c.totalRating, c.totalVoteCount, c.viewCount) from Clothe c LEFT JOIN c.type t where LOWER(c.name) LIKE LOWER(concat('%',:clotheName,'%')) or LOWER(c.color) LIKE LOWER(concat('%',:color,'%')) or LOWER(t.name) LIKE LOWER(concat('%',:typeName,'%'))")
	Page<Clothe> searchByParams(@Param("clotheName") String clotheName, @Param("color") String color, @Param("typeName") String typeName, Pageable pageable);

	@Query("select new ua.FSEInc.domain.Clothe(c.id, c.name, c.gender, c.type, c.size, c.price, c.color, c.material, c.image, c.descr, c.avgRating, c.totalRating, c.totalVoteCount, c.viewCount) from Clothe c where c.gender=:gender")
	List<Clothe> findNewByGender(@Param("gender") Gender gender, Pageable pageable);

	@Query("select new ua.FSEInc.domain.Clothe(c.id, c.name, c.gender, c.type, c.size, c.price, c.color, c.material, c.image, c.descr, c.avgRating, c.totalRating, c.totalVoteCount, c.viewCount) from Clothe c")
	List<Clothe> findTopClothes(Pageable pageable);

	@Query("select new ua.FSEInc.domain.Clothe(c.id, c.name, c.gender, c.type, c.size, c.price, c.color, c.material, c.image, c.descr, c.avgRating, c.totalRating, c.totalVoteCount, c.viewCount) from Clothe c where c.gender=:gender and c.type.id=:typeId")
	Page<Clothe> findByGenderType(@Param("gender") Gender gender, @Param("typeId") long typeId, Pageable pageable);

	@Query("select new ua.FSEInc.domain.Clothe(c.id, c.name, c.gender, c.type, c.size, c.price, c.color, c.material, c.image, c.descr, c.avgRating, c.totalRating, c.totalVoteCount, c.viewCount) from Clothe c where c.type.id=:typeId and c.gender=:gender and c.size=:size")
	Page<Clothe> findByTypeGenderSize(@Param("typeId") long typeId, @Param("gender") Gender gender,
			@Param("size") Size size, Pageable pageable);

	@Modifying
	@Query("update Clothe c set c.viewCount=:viewCount where c.id=:id")
	void updateViewCount(@Param("viewCount") long viewCount, @Param("id") long id);

	@Modifying
	@Query("update Clothe c set c.totalVoteCount=:totalVoteCount, c.totalRating=:totalRating, c.avgRating=:avgRating where c.id=:id")
	void updateRating(@Param("totalVoteCount") long totalVoteCount, @Param("totalRating") long totalRating,
			@Param("avgRating") int avgRating, @Param("id") long id);

}
