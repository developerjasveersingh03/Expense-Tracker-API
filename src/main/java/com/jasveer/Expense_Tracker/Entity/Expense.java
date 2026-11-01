package com.jasveer.Expense_Tracker.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "expenses")
public class Expense {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title should not be empty")
    private String title;

    @Positive(message = "bro amount must be greater than zero!")
    private BigDecimal amount;

    @NotBlank(message = "Category cannot be empty")
    private String category;
    private LocalDate expenseDate;
    public Expense()
    {

    }

}
