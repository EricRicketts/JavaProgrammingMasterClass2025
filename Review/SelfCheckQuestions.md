## Self-check Questions

### Phase 1: Rebuild the basics from memory

- What is the difference between an instance variable and a static variable?

An instance variable is created when a field is declared in a class without the use of the "static" keyword.  This ties the existance of the field to an object of that class, where an object is created using constructor invocation.  In order to update or retrieve the value of the field,
the user must use object's defined interface for that field.  If permissions allow, it is possible for the user to directly update the field, but this is not a good practice as it breaks field encapsulation.  The syntax for updating or retrieving the field is "objectName.methodName".

A static variable is created when a field is declared in a class with the use of the "static" keyword.  In contrast to the instance variable, a instance of the class is not required to be created in order to access the field.  The variable can be accessed by prefixing the variable with the class name and a period as in "classname.fieldName".  However, it is also best practice encapsulate the field by defining an interface to update or retrieve the static variable.  Methods which access or update the static field must be declared with the "static" keyword.

- Why might you avoid a setter for some fields?

If the designer of the class does not want a field to be upated during the lifecycle of an object, then a setter is should not be declared.  In such cases the field is declared "final" and given a value in the constructor body.

- What happens if a constructor does not initialize a field?

If a constructor does not initialize a field then each field takes its default value according to its type, which happens at field declaration.  If the field is a number then the default value is zero, if the field is an object then the default value is null.