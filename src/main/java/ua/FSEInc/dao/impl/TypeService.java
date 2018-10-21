package ua.FSEInc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ua.FSEInc.dao.TypeDAO;
import ua.FSEInc.domain.Type;
import ua.FSEInc.enums.Gender;
import ua.FSEInc.spring.repository.TypeRepository;

@Service
public class TypeService implements TypeDAO {

	@Autowired
	TypeRepository typeRepository;

	@Override
	public List<Type> getAll() {
		return typeRepository.findAll();
	}

	@Override
	public List<Type> search(String... strings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type get(long id) {
		return typeRepository.getOne(id);
	}

	@Override
	public Type save(Type obj) {
		typeRepository.save(obj);
		return obj;
	}

	@Override
	public void delete(Type object) {
		typeRepository.delete(object);
	}

	@Override
	public List<Type> getAll(Sort sort) {
		return typeRepository.findAll(sort);
	}

	@Override
	public Page<Type> getAll(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		return typeRepository.findAll(new PageRequest(pageNumber, pageSize, new Sort(sortDirection, sortField)));
	}

	@Override
	public Page<Type> search(int pageNumber, int pageSize, String sortField, Direction sortDirection,
			String... searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Type> findByGender(Gender gender) {
		return typeRepository.findByGender(gender);
	}

}
