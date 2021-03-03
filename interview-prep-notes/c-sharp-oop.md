# C# Classes
## C# Naming Convention
<pre>
Pascal Case begins with uppercase for each word.
camel Case begins with lowercase for the first word and uppercase for the remaining words.
Pascal Case is used to name Class, Interface and etc.
camel Case is used to name variable, paramter and etc.
</pre>

## The difference between Instance C# Class Member and C# Static Class Member
```csharp
//Instance member/method/variable is accessible from an object. one instance per object. 

public int count = 0; 

// Static member/method/variable can be accessed from the class. one instance per class.
public static int count = 0; // always place static keyword after the access modifier
```
# Common Exception related to OOP

| C# | Java |  Description |
| - | - | - |
| System.NotImplementedException     |   java.lang.UnsupportedOperationException     |  Not implementing a method of a abstract class or interface leads to a runtime error.  The exeption is usually thrown by the default implemention of methods that are supposed to be overridden. |
