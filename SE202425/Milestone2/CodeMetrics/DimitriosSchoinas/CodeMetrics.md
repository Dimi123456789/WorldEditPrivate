Metric set: Chidamber-Kemerer Metrics Set

Metrics file:
[worldedit2.csv](https://github.com/user-attachments/files/17652448/worldedit2.csv)

Report:
Weighted Methods per Class (WMC):
Measures the sum of complexities for all methods in a class. Higher WMC values indicate more complex classes with numerous or complex methods. 
High WMC suggests that a class is doing too much, which may lead to difficulties in understanding and maintaining the class. Classes with lower WMC are generally simpler and more focused.
High WMC values can suggest potential code smells such as Divergent Class (a class that has too many responsibilities) and Long Method. Reducing WMC through method extraction or refactoring could enhance readability and maintainability.
Depth of Inheritance Tree (DIT):
Represents the maximum inheritance depth of a class within the hierarchy. Higher values mean a class is further down in the inheritance hierarchy.
Higher DIT values indicate more inheritance and potential for reuse, but may also introduce greater complexity.
A deep inheritance tree (high DIT) can make code more challenging to understand and maintain. A potential code smell is for example Refused Bequest (when subclasses do not use inherited methods). Monitoring DIT helps to ensure inheritance is used appropriately, enhancing reusability without adding unnecessary complexity.
Number of Children (NOC):
Counts the direct subclasses a class has.
High NOC indicates that a class is a parent to many subclasses, which can suggest it is widely reused or generalized.
A high NOC can sometimes point to Speculative Generality (overly generalized classes created with future use cases in mind) and potential Divergent class aspects (excessive responsibility in a single class). Classes with fewer children are often more focused, while classes with numerous children should be reviewed for appropriate use of inheritance versus composition.
Coupling Between Object Classes (CBO):
Measures the number of classes that a class is coupled with. High CBO indicates strong dependencies between classes.
Higher coupling makes code harder to change because modifications in one class can affect many others.
High CBO is often associated with Feature Envy (a class that overly relies on data or functionality in other classes) and Inappropriate Intimacy (classes too familiar with each other’s details). Reducing CBO through refactoring or introducing interfaces can improve modularity and make maintenance easier.
Response for a Class (RFC):
Counts the methods that can be invoked in response to a message sent to a class, including both its own methods and methods of other classes it calls.
High RFC values indicate that a class has a large “surface area” of functionality, making it potentially more complex to understand and test.
High RFC values can suggest a Divergent Class (if the class has many methods and interacts heavily with others) or Feature Envy (if it relies on methods from other classes excessively). Monitoring RFC can guide simplifying class interactions to improve readability and testability.
Lack of Cohesion in Methods (LCOM):
Measures the cohesiveness of methods within a class. Higher values indicate lower cohesion, meaning methods within a class are less likely to use the same fields or methods.
High LCOM suggests that a class may be handling unrelated responsibilities and is a candidate for refactoring.
High LCOM values are indicators of Large Class . Improving cohesion by breaking up large classes can help align with the Single Responsibility Principle, simplifying maintenance.

Potential trouble spots in the codebase:BiomeCommands Class, BrushCommands Class  and a lot of other classes because of the high Coupling Between Objects metric value and BrushCommands Class because of the high  Response for Class metric value

The high Coupling Between Objects value and the The Response for Class value is related with the code smell "Inaproppriate intimacy" since their value is so high and when analysing the code I can verify the code smells that were pointed by the collected metrics.
