package ua.FSEInc.dao;

import java.util.List;

import ua.FSEInc.domain.Type;
import ua.FSEInc.enums.Gender;

public interface TypeDAO extends GeneralDAO<Type> {
	List<Type> findByGender(Gender gender);
}
