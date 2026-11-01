package com.jasveer.Expense_Tracker.Service;


import com.jasveer.Expense_Tracker.Entity.Expense;
import com.jasveer.Expense_Tracker.Repository.ExpenseRepository;
import com.jasveer.Expense_Tracker.exception.ExpenseNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class ExpenseService {

    public final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense updateExpense) {
        Expense existingExpense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException("Expense not found"));

        existingExpense.setTitle(updateExpense.getTitle());
        existingExpense.setAmount(updateExpense.getAmount());
        existingExpense.setCategory(updateExpense.getCategory());
        existingExpense.setExpenseDate(updateExpense.getExpenseDate());

        return expenseRepository.save(existingExpense);

    }

    public void deleteExpense(Long id)
    {
        Expense expense =expenseRepository.findById(id).orElseThrow(() ->new ExpenseNotFoundException("Expense not found"));
        expenseRepository.delete(expense);
    }


    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException("Expense not found"));
    }
    public Page<Expense> getExpenses(Pageable pageable) {
        return expenseRepository.findAll(pageable);
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategoryIgnoreCase(category);
    }
}
