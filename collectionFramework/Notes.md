Collection framework:
 - Collection framework is a group of object used to manipulate the data in form of object.
 - It contains class and Interfaces. Class like HashMap, LinkedList and vector 

List : An ordered collection that contains duplicate elements (eg. ArrayList, LinkedList).
Set : A collection that cannot contains duplicate elements (eg. HashSet, TreeSet)
Queue : A collection designed for holding elements prior to processing(eg. PriorityQueue)
Deque : A double-ended queue that allows Insertion and removal from both ends (eg. ArrayDeque).
Map : An Interface that represents a collection of key-value pairs (eg. HashMap, TreeMap)

List : contains duplicates
set : contains unique elements
Tree : contains in sorted order
LinkedList : contains in Insertion Order

Map : contains a key-value pair data

ArrayList : ArrayList is class in collection framework, Which implements List interface.
          - It is efficient for Accessing element [o(1)] because of index based element.
          - It is not Efficient for insertion and deletion [O(n)]
LinkedList - LinkedList is a class in Collection framework Which implements List Interface.
          - it is efficient when we have to insert or remove an Element from list. [O(1)].
          - It has slower random access than ArrayList. 

CopyOnWriteArrayList : it is used to read and write to Arraylist on same time without ConcurrentModification Exception



1. Normal HashMap (Without Overrides) — Accurate

• Your view: It uses buckets and indexing based on the object's default hashcode. Even if two objects have identical internal data, they are treated as unique, occupying different spaces in the map. This wastes memory if you logically consider those objects to be duplicates.
• The Refinement: You are spot on. Because .equals() isn't overridden, HashMap falls back to checking OldObj == NewObj. Since they are separate instances in memory, the map thinks they are completely different keys. They might land in different buckets, or if they happen to share the same bucket index due to a hash collision, they will sit next to each other in a linked list structure inside that same bucket. Either way, memory is wasted with duplicate entries.

2. IdentityHashMap — Accurate

• Your view: It completely bypasses standard methods and uses the == operator to check references. It stores data in a flat array format, and separate instances with the same data will never overwrite each other.
• The Refinement: Perfect. Because it uses a flat array ([Key1, Value1, Key2, Value2...]) instead of creating individual wrapper Node objects for every single entry, it has a very low memory footprint per entry. However, because it relies strictly on ==, it will keep every single instance you pass to it, never overwriting unless it is the exact same memory address.

3. HashMap with Overridden hashCode & equals — Accurate

• Your view: It explicitly compares objects using OldObj.equals(NewObj). If they are structurally equal, the new value overwrites the old one, keeping only one entry in the bucket.
• The Refinement: Exactly. This is the memory-efficient way to write business applications. By telling the HashMap exactly what makes two objects "the same" (like a User ID or an Order Number), you guarantee that your map stays clean, compact, and free of duplicate data bloat.

          