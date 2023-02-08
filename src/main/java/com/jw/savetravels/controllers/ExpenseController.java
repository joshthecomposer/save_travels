package com.jw.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jw.savetravels.models.Expense;
import com.jw.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
		@Autowired
		ExpenseService eServ;

		@GetMapping("/")
		public String index() {
			return "redirect:/expenses";
		}
		
		@GetMapping("/expenses")
		public String dashboard(
				Model m
				) {
			List<Expense> expenses = eServ.findAll();
			System.out.println(expenses);
			m.addAttribute("expenses", expenses);
			m.addAttribute("expense", new Expense());
			return "index.jsp";
		}
		
		@PostMapping("/expenses/create")
		public String save(
				@Valid @ModelAttribute("expense") Expense expense,
				BindingResult result
				) {
			if (result.hasErrors()) {
				return "/index.jsp";
			}
			eServ.save(expense);
			return "redirect:/expenses";
		}
		
		@GetMapping("/expenses/edit/{id}")
		public String edit(
				@PathVariable("id") Long id,
				Model m
				) {
			m.addAttribute("expense", eServ.findById(id));
			
			return "/edit.jsp";
		}
		
		@PutMapping("/expenses/edit/{id}")
		public String update(
				@Valid @ModelAttribute("expense") Expense e,
				BindingResult result
				) {
			if (result.hasErrors()) {
				return "/edit.jsp";
			} else {
			eServ.save(e);
			return "redirect:/expenses";
			}
		}
		
		@DeleteMapping("/expenses/delete/{id}")
		public String delete(
				@PathVariable("id") Long id
				) {
			eServ.deleteById(id);
			return "redirect:/expenses";
		}
		
		@GetMapping("/expenses/view/{id}")
		public String view(
				@PathVariable("id") Long id,
				Model m
				) {
			m.addAttribute("e", eServ.findById(id));
			return "/view.jsp";
		}
}
