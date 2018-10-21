package ua.FSEInc.jsfui.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import ua.FSEInc.dao.ClotheDAO;
import ua.FSEInc.domain.Clothe;
import ua.FSEInc.enums.Gender;
import ua.FSEInc.jsfui.enums.SearchType;
import ua.FSEInc.jsfui.model.LazyDataTable;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
@Component
@Getter
@Setter
public class GenderController {
	private Gender male = Gender.MALE;
	private Gender female = Gender.FEMALE;
	private Gender child = Gender.CHILD;
}
