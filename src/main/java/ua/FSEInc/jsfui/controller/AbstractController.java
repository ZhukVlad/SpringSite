package ua.FSEInc.jsfui.controller;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public abstract class AbstractController<T> implements Serializable {
	
	public abstract Page<T> search(int first, int count, String sortField, Sort.Direction sortDirection);
}
