
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