package com.jw.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jw.savetravels.models.Expense;
import com.jw.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository repo;
	
	ExpenseService(ExpenseRepository repo) {
		this.repo = repo;
	}
	
	public Expense save(Expense expense) { 
		return repo.save(expense);
	}
	
	public List<Expense> findAll(){
		return repo.findAll();
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public Expense findById(Long id) {
		Optional<Expense> expense = repo.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		} else {
			return null;
		}
	}
}
