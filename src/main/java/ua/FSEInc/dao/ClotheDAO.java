package ua.FSEInc.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import ua.FSEInc.domain.Clothe;
import ua.FSEInc.enums.Gender;
import ua.FSEInc.enums.Size;

public interface ClotheDAO extends GeneralDAO<Clothe> {
	// последние просматриваемые
	List<Clothe> findTopClothes(int limit); // TODO: переделать на последние просматриваемые
	
	List<Clothe> findNewAdded(Gender gender, int limit);
	
	Page<Clothe> findByTypeId(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long typeId);
	
	//  показать все одежду в ценовом диапазоне
	Page<Clothe> findByPriceBetween(BigDecimal price1, BigDecimal price2, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);
	
	// показать все одежду по полу и типу
	Page<Clothe> findByGenderType(Gender gender, long typeId, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);
	
	// показать все одежду по типу, полу и размеру
	Page<Clothe> findByTypeGenderSize(long typeId, Gender gender, Size size, int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);
	
	void updateViewCount(long viewCount, long id);
	
	void updateRating(long totalVoteCount, long totalRating, int avgRating, long id);
}
