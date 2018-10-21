package ua.FSEInc.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ua.FSEInc.dao.ClotheDAO;
import ua.FSEInc.domain.Clothe;
import ua.FSEInc.enums.Gender;
import ua.FSEInc.enums.Size;
import ua.FSEInc.spring.repository.ClotheRepository;

@Service
public class ClotheService implements ClotheDAO {

	@Autowired
	ClotheRepository clotheRepositiry;

	@Override
	public List<Clothe> getAll() {
		return clotheRepositiry.findAll();
	}

	@Override
	public List<Clothe> search(String... searchString) {
		// return clotheRepositiry.findByNameContainingIgnoreCase(searchString[0]);
		return null;
	}

	@Override
	public Clothe get(long id) {
		return clotheRepositiry.findOne(id);
	}

	@Override
	public Clothe save(Clothe obj) {
		clotheRepositiry.save(obj);
		return obj;
	}

	@Override
	public void delete(Clothe object) {
		clotheRepositiry.delete(object);
	}

	@Override
	public List<Clothe> getAll(Sort sort) {
		return clotheRepositiry.findAll(sort);
	}

	@Override
	public Page<Clothe> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return clotheRepositiry.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
	}

	@Override
	public Page<Clothe> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		return clotheRepositiry.searchByParams(searchString[0], searchString[0], searchString[0],
				new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
	}

	@Override
	public List<Clothe> findTopClothes(int limit) {
		return clotheRepositiry.findTopClothes(new PageRequest(0, limit, new Sort(Sort.Direction.DESC, "viewCount")));
	}

	@Override
	public List<Clothe> findNewAdded(Gender gender, int limit) {
		return clotheRepositiry.findNewByGender(gender, new PageRequest(0, limit, new Sort(Sort.Direction.DESC, "id")));
	}

	@Override
	public Page<Clothe> findByTypeId(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			long typeId) {
		return clotheRepositiry.findByTypeId(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)),
				typeId);
	}

	@Override
	public Page<Clothe> findByGenderType(Gender gender, long typeId, int pageNumber, int pageSize, String sortField,
			Direction sortDirection) {
		return clotheRepositiry.findByGenderType(gender, typeId,
				new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
	}

	@Override
	public void updateViewCount(long viewCount, long id) {
		clotheRepositiry.updateViewCount(viewCount, id);

	}

	@Override
	public void updateRating(long totalVoteCount, long totalRating, int avgRating, long id) {
		clotheRepositiry.updateRating(totalVoteCount, totalRating, avgRating, id);

	}

	@Override
	public Page<Clothe> findByPriceBetween(BigDecimal price1, BigDecimal price2, int pageNumber, int pageSize,
			String sortField, Direction sortDirection) {
		return clotheRepositiry.findByPriceBetween(price1, price2,
				new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
	}

	@Override
	public Page<Clothe> findByTypeGenderSize(long typeId, Gender gender, Size size, int pageNumber, int pageSize,
			String sortField, Direction sortDirection) {
		return clotheRepositiry.findByTypeGenderSize(typeId, gender, size,
				new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
	}

}
