Differences Between Abstract class and Interface

Abstract class :
 - An abstract class in Java is a class declared using the abstract keyword.
 - It can contain abstract methods (without a body), concrete methods (with a body), instance variables, and constructors. 
 - It is used to provide common state(instance variable) and behavior(methods) to related classes while allowing subclasses to implement specific behavior. 

Interface :
 - An interface in Java is a reference type declared using the interface keyword.
 - It defines a contract that implementing classes agree to follow. 
 - It is useful for specifying common capabilities across classes, whether those classes are related through inheritance.

Difference between Abstract class and Interface

Abstract class:
  - uses abstract Keyword
  - Can have both abstract and concrete method
  - can have instance variable and other fields [Partially abstraction]
  - can have constructors
  - A class can Extend only one class
Interface:
  - uses interface keyword
  - can have default, static, private and abstract methods
  - can not have constructors
  - fields are implicitly _private static final_ [which makes it fully abstraction]
  - A class implement multiple interface

Interview Answer "Difference between Abstract class and Interface"?
Answer :
An abstract class is used when related classes need to share common state and implementation. 
For example, BankAccount can contain shared fields like account number and balance, 
a common deposit() method, and an abstract withdraw() method that different account types implement differently.

An interface defines a contract that classes agree to follow. 
For example, a Payment interface can declare pay(), which classes like UPI, CreditCard, and PayPal implement in their own ways.

We cannot instantiate either an abstract class or an interface directly, 
but we can create objects of concrete subclasses or implementing classes and refer to those objects through abstract-class or interface references.

Final point to remember: 
An abstract class can share both state and implementation. 
An interface primarily defines a contract or capability. 
Neither can be instantiated directly, but both support polymorphism.
