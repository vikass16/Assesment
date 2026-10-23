Collection framework:
 - Collection framework is a group of object used to manipulate the data in form of object.
 - It contains class and Interfaces. Class like HashMap, LinkedList and vector 

List : An ordered collection that contains duplicate elements (eg. ArrayList, LinkedList).
Set : A collection that cannot contains duplicate elements (eg. HashSet, TreeSet)
Queue : A collection designed for holding elements prior to processing(eg. PriorityQueue)
Deque : A double-ended queue that allows Insertion and removal from both ends (eg. ArrayDeque).
Map : An Interface that represents a collection of key-value pairs (eg. HashMap, TreeMap)

 
    List : contains duplicates
    Important methods used in List [ add(E e), add(int index, E element), get(index), set(index, ele), remove(index)/remove(object), indexOf(Object o)/lastIndexOf(obj o)]
    set : contains unique elements  
    Important methods used in Set [ add(E e), remove(), contains(Obj o), iterator(), first(), last()]
    Tree : contains in sorted order
    LinkedList : contains in Insertion Order

    Map : contains a key-value pair data  
    Important methods of map  [ put(K key, V value), get()/getOrDefault(), remove(), containsKey(), containsValue(), KeySet()/values()/entrySet(), putIfAbset()

ArrayList : ArrayList is class in collection framework, Which implements List interface.
          - It is efficient for Accessing element [o(1)] because of index based element.
          - It is not Efficient for insertion and deletion [O(n)]
LinkedList - LinkedList is a class in Collection framework Which implements List Interface.
          - it is efficient when we have to insert or remove an Element from list. [O(1)].
          - It has slower random access than ArrayList. 

CopyOnWriteArrayList : it is used to read and write to Arraylist on same time without ConcurrentModification Exception


===================== Normal HashMap  vs  IdentityHashMap  vs HashMap which overrides hashCode() and equals() ======================

1. Normal HashMap (Without Overrides) — Accurate

• Your view: It uses buckets and indexing based on the object's default hashcode. Even if two objects have identical internal data, they are treated as unique, occupying different spaces in the map. This wastes memory if you logically consider those objects to be duplicates.
• The Refinement: You are spot on. Because .equals() isn't overridden, HashMap falls back to checking OldObj == NewObj. Since they are separate instances in memory, the map thinks they are completely different keys. They might land in different buckets, or if they happen to share the same bucket index due to a hash collision, they will sit next to each other in a linked list structure inside that same bucket. Either way, memory is wasted with duplicate entries.

2. IdentityHashMap — Accurate

• Your view: It completely bypasses standard methods and uses the == operator to check references. It stores data in a flat array format, and separate instances with the same data will never overwrite each other.
• The Refinement: Perfect. Because it uses a flat array ([Key1, Value1, Key2, Value2...]) instead of creating individual wrapper Node objects for every single entry, it has a very low memory footprint per entry. However, because it relies strictly on ==, it will keep every single instance you pass to it, never overwriting unless it is the exact same memory address.

3. HashMap with Overridden hashCode & equals — Accurate

• Your view: It explicitly compares objects using OldObj.equals(NewObj). If they are structurally equal, the new value overwrites the old one, keeping only one entry in the bucket.
• The Refinement: Exactly. This is the memory-efficient way to write business applications. By telling the HashMap exactly what makes two objects "the same" (like a User ID or an Order Number), you guarantee that your map stays clean, compact, and free of duplicate data bloat.


================== COMPARATOR   vs   COMPARABLE ================

Both Comparable and Comparator are Java interfaces used to sort collections of objects, but they are used differently:

1. Comparable (Natural / Default Sorting)

• Location: Implemented inside the target class itself.
• Method: Overrides the int compareTo(T o) method, which takes one parameter (the other object to compare against this).
• Usage: Used for a single, default sorting strategy (e.g., always sorting by id or always by name).
• How to call: Collections.sort(myList) (Java automatically uses the internal compareTo logic).

2. Comparator (Custom / Flexible Sorting)

• Location: Implemented outside the target class (often in the main class, a separate class, or as a lambda expression).
• Method: Implements the int compare(T o1, T o2) method, which takes two parameters to compare them.
• Usage: Used for custom sorting logic. It allows you to sort by multiple different fields (e.g., sort by name, or sort by id) and easily switch between ascending and descending orders.
• How to call: Collections.sort(myList, myComparator) (You must explicitly pass the sorting logic).


--------------------- SortedMap     vs       NavigableMap    vs    TreeMap --------------------------------
TreeMap is a class Which implements SortedMap interface and SortedMap is an interface which extends Map Interface.
It sorts the Map on the basis of Key (according to key : if key is String then in a-z manner and if key in numeric then in 1-100 manner like this)
NavigationMap is an Interface which extends SortedMap Which is also an Interface.
TreeMap extends NavigationMap.

  
    Map  (Interface)
      --> SortedMap   (Interface)
                 --> NavigableMap  (Interface)
                               --> TreeMap  (class)
  

-------------------  HashTable ----------------------
1. Similar as HashMap but threadSafe (means Synchronized)
2. No null Key or Value allowed 
3. It is a Legacy class, replaced by ConcurrentHashMap
4. HashTable is slower than HashMap because it is threadSafe
5. It creates only LinkedList in case of collision not BST like HashMap.
6. All methods are Synchronized in HashTable

**Synchronization** is the most common technique used to achieve thread safety by enforcing mutual exclusion—allowing 
only one thread to access a critical section of code at a time

--------------------  ConcurrentHashMap  -------------------
1. Java 7 --> Segment based locking --> 16 segments --> smaller hashmaps
2. Only the segment is being written or read from is locked.
3. read : do not require locking unless there is a writes operation happening on the same segment.
4. write : lock required.

5. java 8 --> No segmentation
6. Compare and swap approach is used (No locking required except in resizing and collision condition).


------------------------  Immutable Map  ---------------------------
ImmutableMap is a map which values we can't change once it is instantiated.
Can not add or remove elements.

Map<String, Integer> map = Map.of("Vikas",78,"Vipin",82,"Atul",89,"Anish",90); // Limited only for 10 key-value pair.
Map<String, Integer> map = Map.ofEntries(Map.entry("Vikas",78),Map.entry("Vipin",82),Map.entry("Atul",90));  // Using this we can put Unlimited values into ImmutableMap.
This is a clean way to create an ImmutableMap, Where we can't add or remove values, if try then will get UnSupportedException.


------------------------  ConcurrentSkipListMap  -----------------------------------
1. A Map which is Sorted(TreeSet) and ThreadSafe --> ConcurrentSkipListMap
2. SkipList is a Data Structure where data is stored after using ConcurrentSkipListMap
3. SkipList is a Probabilistic data structure that allows for efficient search, insertion, and deletion operation.


------------------------------  Iterator  ------------------------------------------
Iterator is Interface which extends Iterable Interface.
Example :   

       Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
          System.out.println(it.next());
        }

       Iterator<Integer> it = list.iterator();
       while(it.hasNext()){
        int num = it.next();
         if(num % 2 == 0){
            it.remove();
         }
        }


---------------------------  Set :  HashSet, LinkedHashSet, TreeSet -------------------------------
1. Set is a collection that cannot contain duplicate elements.
2. faster operations
3. Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
4. Set --> HashSet, LinkedHashSet, TreeSet, EnumSet
5. It contains only key that's unique too.
 However, Set is not threadSafe So we use ConcurrentSkipListSet<>() class Instead for thread-safety


    Set<Integer> set1 = new ConcurrentSkipListSet<>(); // Used for thread - safety for Set [ No null allowed ]

    Set (only one null elements allowed)  [ These are not threadSafe ]
    HashSet --> Unique + Unordered  
    LinkedHashSet --> Unique + Insertion order maintained
    TreeSet --> Unique + Sorted order (here no null key allowed,throws NullPointerEcdeption)

     Map (one null Key and Unlimited null values allowed)
     HashMap --> Duplicates Values + Unordered   [replacement is ConcurrentHashMap for thread-safety (No null key or values allowed)]
     LinkedHashMap --> Duplicates Values + Insertion Order maintained
     TreeMap --> Duplicates Values + Sorted Order (No null key allowed) [replacement is ConcurrentSkipListMap for thread-safety]
     
     List --> Allows Duplicates and null vaules
     Use CopyOnWriteArrayList for thread-safety instead of ArrayList 
     

    