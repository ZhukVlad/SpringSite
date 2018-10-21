package ua.FSEInc.jsfui.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import ua.FSEInc.dao.ClotheDAO;
import ua.FSEInc.dao.TypeDAO;
import ua.FSEInc.domain.Clothe;
import ua.FSEInc.domain.Type;
import ua.FSEInc.enums.Gender;
import ua.FSEInc.jsfui.enums.SearchType;
import ua.FSEInc.jsfui.model.LazyDataTable;

@ManagedBean
@SessionScoped
@Component
@Getter
@Setter
@Log
public class TypeController extends AbstractController<Type>{
	
	@Autowired
	private TypeDAO typeDAO;

	@Override
	public Page<Type> search(int first, int count, String sortField, Direction sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Type> findByGender(Gender gender){
		return typeDAO.findByGender(gender);
	}

}
