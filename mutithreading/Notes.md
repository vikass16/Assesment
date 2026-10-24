
A Core is an Individual processing unit within a CPU. Modern CPUs can have multiple cores, allowing them to perform multiple tasks simultaneously.


     Program - A Set of Instruction written in Programming language that tells the computer how to perform a specific task.
         (Microsoft Word is a program that allows users to create and edit documents)

     Process - A process is an instance of a program runs, the operating system creates a process to manage its executions.
         (When we open Microsoft Word, it becomes a process in the operating system).

Thread : A Thread is the smallest unit of executions within a process. A Process can have multiple threads, which share the same resource but can run independently.
         
        Program --> Process(Program start running) --> thread1, thread2, thread3.....thread n. (Multithreading).
        [Each threads are smallest unit of Executions and they run independently and it is known as Multithreading] 
         
 
        Multitasking allows an operating system to run multiple processes simultaneously. On single-core CPUs, true
        parallel execution occurs, with tasks distributed across cores. The OS Scheduler balance the load, ensuring
        efficient and responsive system performance.
        
        Multitasking utilizes the capabilties of a CPU and its cores. When an operating system performs multitasking,
        It can assign different tasks to different cores. This is more efficient than assigning all tasks to a single core. 

        # Multithreading
        Multithreading refers to the ability to execute multiple threads within a single process concurrently.

Multitasking enhance the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks or threads.
These threads can be processed simultaneously, making better use the CPU's capabilities.

#in a single core system:
Both threads and processes are managed by the OS scheduler through time slicing and context switching to create the illusion 
of simultaneous execution.

#in a multicore system:
Both threads and processes can run in true parallel on different cores, with the OS scheduler distributing tasks across the 
cores to optimize performance.


     Multitasking allows us to run multiple applications simultaneously, improving productivity and system utilization.
     Mutithreading allows a single application to perform multiple tasks at the same time, improving applications performance and responsiveness.

There are two ways to create threads in Java
1. by extending Thread class
2. by implementing Runnable Interface 

 #Java Thread LifeCycle
       
    New : A thread is in this state when it is created but not yet started.
    Runnable : After the start method is called, the thread becomes runnable. It's ready to run and waiting for CPU time.
    Running : The thread is in this state when it is executing. 
    Blocking/Waiting : A thread is in state when it is waiting for a resource or for another thread to perform an action.
    Terminated : A thread is in this staten when it has finished executing.

Important Notes 
  
    Difference between Process and Thread
    Process ->
              1. Independent Execution Unit
              2. Process has it's own memory
              3. Expansive creation
              4. Slow context switching
    Thread  ->
              1. Lighweight Exectution Unit
              2. Shares Process memory
              3. Cheap creation
              4. fast context switching

    Difference between wait() and sleep()
    wait() ->
              1. It releases lock
              2. belongs to the Object class
              3. It is used for Communication
    sleep()  ->
              1. It doesn't releases lock
              2. belongs to thread class
              3. It is used for pause



#Terminologies
  
    Synchronization provides an implicit lock to threads on shared resources. (It can be unnecessarly that thread 1 sharing resouces  by locking it for so long then for thread 2 it would not be benificial. 
    that's why we use Explicit lock( ReentrantLock)
    Synchronization : The coordination of simultaneous processes, threads, 
                      or tasks in an operating system so they execute in a predictable order and share system resources safely.
                      Synchronization is done by locking shared resources.
    Synchronization is used to avoid race condition and inconsistent data.

    Critical Section : A segment of code or part of a program where shared resources (such as global variables, memory, files, or databases) are accessed and modified.
    
    Race Condition : An undesirable flaw that occurs when multiple processes or threads access and modify shared data simultaneously, 
                     and the final outcome depends on the unpredictable (non-deterministic) order of execution.
 
    Mutual Exclusion : A concurrency control property which guarantees that if one process or thread is executing inside its critical section, 
                       no other process or thread can enter or execute in its critical section for that same resource at the same time.


Lock is an Interface. we can create its object by using its Implementation class ReentrantLock.

    tryLock() : Aquires the lock if it is free within the given waiting time and the current thread has not been Interrupted.
                If the lock is available this method returns immediately with the value true.
                If the lock is not available then the current thread becomes disabled for thread schduling purposes and lies dormant until one of three things happens.
                 - The lock aquire by the current thread.
                 - Some other thread interrupts the current thread
                 - The specified waiting time elapses.
    unlock() : it released the lock after that specified time.
    lock() : This applies on thread which is waiting for another thread to release the lock.


FEW Important Points

    start() : This method creates new thread and internally calls run().
    run() : runs as a normal method.
    sleep() : pause a thread for specific time, it doesn't release lock.
    join() : it is used to keep a thread in waiting state until target threads completes.
    yield() : thread.yield() method tells schedular to give chance to another threads as well but it won't guarantee.
    priority() : thread.setPriority(Thread.MAX_PRIORITY); it is used to give the priority to threads but high priority does not guarantee execution first.

    DeadLock : Deadlock is a condition where process waits infinitly for the reousrces held by each other.
              It occurs when four condition is satisfied [Mutual Exclusion, Hold and wait, Circular wait, No pre-emption].
              Deadlock can be prevent by elemenating at least one condition of these.

   
    Inter-thread Communication :
        wait() : releases lock and goes to sleep().
        notify() : wakes up one random thread.
        notifyAll() : wakes up all threads 
    both notify() and notifyAll() continues  executing it's synchronized block.

    Executor framework : It is used for threead reuse and better performance.
    Thread pool : Collection of reusable threads. benifits are - less memory consumption, better performance, Less thread creates overhead.

    Runnable : No returns value (a method which runs run() method)
    Callable : returns value (public Integer call())

    volatile keyword : It ensures visibilty between threads.
       volatile : visibilty between threads.
       Synchronization : visibility + mutual exclusion.

    Atomic class : is a way in java to perform thread-safe without synchronization.
    