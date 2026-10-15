
There are Three types of Error in Java
  1. Syntax Error
  2. Logical Error
  3. RunTime Error

Exception Handling :
 - Exception handling is a way or method to handle RunTime errors, so that Normal flow of Program is maintained.
 - It helps program to gracefully handle exception like ArithmeticException, FileNotFoundException etc.

Exception :
 - Exception is an Event that disrupt the Normal flow of Program. It is an Object which is thrown at Runtime.


Hierarchy of Exception (From parent to child)

(Before Everything I have to add java.lang.____)


- java.lang.Object
   - java.lang.Throwable
     - Error
       - VirtualMachineError
         - OutOfMemoryError
         - StackOverflowError
       - LinkageError
         - ClassFormatError
         - NoClassDefFoundError
     - Exception
       - RunTimeException
         - ArithmeticException
         - NullPointerException
         - IndexOutOfBoundException
         - IllegalArgumentException
       - IOException
         - FileNotFoundException
         - EOFException
       - SQLException
       

Stack Trace Provides detailed information about method calls that led to Exception.

RunTime Exceptions are Unchecked Exception Which is not checked during the Compilation.
Compile Time Exception are Checked Exception Which Occurs During Compile Time

**throw** keyword is used to explicitly throw an Exception
**throws** keyword is used to throw an Exception wit method Signature.

try with resources introduced in Java 7 ,Where we don't have to write finally (we can do in try block what we want to do in finally).