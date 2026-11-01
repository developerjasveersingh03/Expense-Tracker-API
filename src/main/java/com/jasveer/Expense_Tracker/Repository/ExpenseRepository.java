package com.jasveer.Expense_Tracker.Repository;

import com.jasveer.Expense_Tracker.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findByCategoryIgnoreCase(String category);
}
