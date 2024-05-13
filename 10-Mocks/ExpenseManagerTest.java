package put.io.testing.mocks;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    private ExpenseRepository expenseRepository;
    private FancyService fancyService;
    private ExpenseManager expenseManager;


    List<Expense> initExpenses() {

        List<Expense> list = new ArrayList<Expense>();

        return List.of(new Expense("Home",100),
                new Expense("Home",200),
                new Expense("Car",90),
                new Expense("Car",100));
    }

    @BeforeEach
    void setUp() {

         expenseRepository = mock(ExpenseRepository.class);
         fancyService = mock(FancyService.class);
         expenseManager = new ExpenseManager(expenseRepository, fancyService);
    }

    @Test
    void calculateTotal() {



        List<Expense> expenses = Arrays.asList(new Expense(), new Expense(), new Expense());

        when(expenseRepository.getExpenses()).thenReturn(expenses);


        assertEquals(expenses.stream().mapToLong(Expense::getAmount).sum(), expenseManager.calculateTotal());

    }


    @Test
    void calculateTotalForCategory() {


        List<Expense> expenses = initExpenses();

        when(expenseRepository.getExpenses()).thenReturn(expenses);


        when(expenseRepository.getExpensesByCategory("Home")).thenReturn(expenses.stream().filter(expense -> expense.getCategory().equals("Home")).collect(toList()));
        when(expenseRepository.getExpensesByCategory("Car")).thenReturn(expenses.stream().filter(expense -> expense.getCategory().equals("Car")).collect(toList()));
        when(expenseRepository.getExpensesByCategory("Food")).thenReturn(expenses.stream().filter(expense -> expense.getCategory().equals("Food")).collect(toList()));
        when(expenseRepository.getExpensesByCategory("Sport")).thenReturn(expenses.stream().filter(expense -> expense.getCategory().equals("Sport")).collect(toList()));


        assertEquals(expenses.stream().filter(expense -> expense.getCategory().equals("Home")).mapToLong(Expense::getAmount).sum(), expenseManager.calculateTotalForCategory("Home"));
        assertEquals(expenses.stream().filter(expense -> expense.getCategory().equals("Car")).mapToLong(Expense::getAmount).sum(), expenseManager.calculateTotalForCategory("Car"));

        assertEquals(0, expenseManager.calculateTotalForCategory("Food"));
        assertEquals(0, expenseManager.calculateTotalForCategory("Sport"));
        //assertEquals(expenses.stream().filter(expense -> expense.getCategory().equals("Food")).mapToLong(Expense::getAmount).sum(), expenseManager.calculateTotalForCategory("Food"));
        //assertEquals(expenses.stream().filter(expense -> expense.getCategory().equals("Sport")).mapToLong(Expense::getAmount).sum(), expenseManager.calculateTotalForCategory("Sport"));
    }

    @Test
    void calculateTotalInDollars() throws ConnectException {



        List<Expense> expenses = initExpenses();
        when(expenseRepository.getExpenses()).thenReturn(expenses);

        when(fancyService.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(new Answer<Double>() {
            @Override
            public Double answer(InvocationOnMock invocation) throws Throwable {
                return (Double) invocation.getArgument(0) / 4;
            }
        });
        assertEquals(expenses.stream().mapToDouble(expense -> expense.getAmount() / 4).sum(), expenseManager.calculateTotalInDollars());

    }

}
