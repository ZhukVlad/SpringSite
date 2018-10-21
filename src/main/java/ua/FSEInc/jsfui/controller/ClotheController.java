package ua.FSEInc.jsfui.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
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
import ua.FSEInc.domain.Clothe;
import ua.FSEInc.enums.Gender;
import ua.FSEInc.jsfui.model.LazyDataTable;
import ua.FSEInc.jsfui.controller.AbstractController;
import ua.FSEInc.jsfui.enums.SearchType;


@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
@Component
@Getter
@Setter
@Log
public class ClotheController extends AbstractController<Clothe> {
	public static final int DEFAULT_PAGE_SIZE = 20;
	public static final int TOP_CLOTHE_LIMIT = 6;
	public static final int NEW_CLOTHE_LIMIT = 2;

	private int rowsCount = DEFAULT_PAGE_SIZE;
	
	private SearchType searchType;

	@Autowired
	private ClotheDAO clotheDAO;

	public LazyDataTable<Clothe> lazyModel;

	private Page<Clothe> clothePages;
	private List<Clothe> topClothe;
	
	private String searchText;
	private long typeId;
	private long clotheId;

	@PostConstruct
	public void init() {
		lazyModel = new LazyDataTable<Clothe>(this);
	}

	@Override
	public Page<Clothe> search(int pageNumber, int pageSize, String sortField, Direction sortDirection) {
		if (sortField == null) {
			sortField = "name";
		}

		if (searchType == null) {
			clothePages = clotheDAO.getAll(pageNumber, pageSize, sortField, sortDirection);
		} else {
			switch (searchType) {
			case SEARCH_TYPE:
				clothePages = clotheDAO.findByTypeId(pageNumber, pageSize, sortField, sortDirection, typeId);
				break;
			case SEARCH_TEXT:
				clothePages = clotheDAO.search(pageNumber, pageSize, sortField, sortDirection, searchText);
				break;
			case ALL:
				clothePages = clotheDAO.getAll(pageNumber, pageSize, sortField, sortDirection);
				break;
			}
		}
		return clothePages;
	}

	public List<Clothe> getTopClothe() {
		topClothe = clotheDAO.findTopClothes(TOP_CLOTHE_LIMIT);
		return topClothe;
	}
	
	public List<Clothe> getNewAdded(Gender gender) {
		return clotheDAO.findNewAdded(gender, NEW_CLOTHE_LIMIT);
	}
	
	public void searchByMenu(long typeId) {
		this.searchType = SearchType.SEARCH_TYPE;
		this.typeId = typeId;
	}
	
	public void searchAction() {
		this.searchType = SearchType.SEARCH_TEXT;
	}
	
	public Clothe getById() {
		return clotheDAO.get(clotheId);
	}
	
	public int getProc(long views, long votes) {
		return BigDecimal.valueOf((votes/(views+1))*100).intValue();
	}
}