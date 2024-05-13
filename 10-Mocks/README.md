## Question 2.1:
to change the operation:

we can use mockito InOrder feature, it will ensure that the methods are invoked in a specific order.

in our case we have to verify that connect() is called before queryAll() and close() is called after queryAll().

## Question 5.1: 
no,

 in mockito, it doesn't matter which order you put the expectations in for the same method with different arguments. 
 
 mockito will use the latest expectation that matches the method call.