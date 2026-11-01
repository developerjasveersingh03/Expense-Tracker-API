package com.jasveer.Expense_Tracker.controller;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.jasveer.Expense_Tracker.Entity.Expense;
import com.jasveer.Expense_Tracker.Service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import org.springframework.data.domain.Sort;
@RestController
@RequestMapping("api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
     public ExpenseController(ExpenseService expenseService)
     {
         this.expenseService = expenseService;
     }
     @GetMapping
    public List<Expense> getAllExpenses()
     {
         return expenseService.getAllExpense();
     }

     @PostMapping
     public Expense createExpense( @Valid @RequestBody Expense expense)
     {
         return expenseService.saveExpense(expense);
     }
     @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id , @Valid @RequestBody Expense expense)
     {
         return expenseService.updateExpense(id, expense);
     }


     @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id)
     {
         expenseService.deleteExpense(id);
     }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }




    @GetMapping("/page")
    public Page<Expense> getExpenses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return expenseService.getExpenses(pageable);
    }

    @GetMapping("/category/{category}")
    public List<Expense> getExpensesByCategory(@PathVariable String category) {
        return expenseService.getExpensesByCategory(category);
    }
}


