package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;


import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {


    private  IFancyDatabase myDatabase;
    private ExpenseRepository expenseRepository;
    private int testingValue = 5;

    @BeforeEach
    void setUp(){
        myDatabase = mock(MyDatabase.class);
        expenseRepository = new ExpenseRepository(myDatabase);
    }

    @Test
    void loadExpenses() {


        when(myDatabase.queryAll()).thenReturn(Collections.emptyList());

        expenseRepository.loadExpenses();

        assertTrue(expenseRepository.getExpenses().isEmpty());


        InOrder inOrder = inOrder(myDatabase);
        inOrder.verify(myDatabase).connect();
        inOrder.verify(myDatabase).queryAll();
        inOrder.verify(myDatabase).close();




    }

    @Test
    void saveExpenses() {


        for(int i=0; i<testingValue; i++){
            expenseRepository.addExpense(new Expense());
        }

        expenseRepository.saveExpenses();
        verify(myDatabase, times(testingValue)).persist(any(Expense.class));
    }
}
