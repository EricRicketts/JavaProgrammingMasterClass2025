## Self-check Questions

### Phase 3: Records and POJO-style data objects

- Why are records good for simple data?

The question asks, "Why are records are good for simple data?"  In thinking about how to answer the question, I thought along the lines of "Why are records a good store for simple data?"  Records provide built in methods specifically designed to store and access data.  These methods do not readily lend themselves to more complicated manipulation of data other than simple deposits and retrievals.  All fields in a record are implicitly final, ensuring the record's state cannot be modified after creation.   

- When would a record be a bad choice?

Records would be a bad choice if the data stored needs a lot of validation before storage or a lot of manipulation before retrieval.  A record's storage and retrieval methods are very simple setter and getter methods, with no options for modifications.

- What do records automatically provide?

Records provide getter and setter methods named after their fields, a non-argument constructor, and implementations for toString(), hashCode(), and equals().