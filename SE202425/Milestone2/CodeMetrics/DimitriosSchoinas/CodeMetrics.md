Metric set: Chidamber-Kemerer Metrics Set

Metrics file:
[worldedit2.csv](https://github.com/user-attachments/files/17652448/worldedit2.csv)

Coupling Between Objects (CBO) is the number of other classes that a class is coupled to.
Depth of Inheritance Tree (DIT) is the maximum length of a path from a class to a root class in the inheritance structure of a system. DIT measures how many super-classes can affect a class.
The Lack of Cohesion in Methods metric is a measure for the number of not connected method pairs in a class representing independent parts having no cohesion. It represents the difference between the number of method pairs not having instance variables in common, and the number of method pairs having common instance variables.
Number of Children (NOC) Calculates the total number of direct subclasses of given class. This metric measures how many sub-classes are going to inherit the methods of the parent class. The size of NOC approximately indicates the level of reuse in an application. If NOC grows it means reuse increases. On the other hand, as NOC increases, the amount of testing will also increase because more children in a class indicate more responsibility. So, NOC represents the effort required to test the class and reuse.
The Response for Class (RFC) metric is the total number of methods that can potentially be executed in response to a message received by an object of a class. This number is the sum of the methods of the class, and all distinct methods are invoked directly within the class methods. Additionally, inherited methods are counted, but overridden methods are not, because only one method of a particular signature will always be available to an object of a given class.
Weighted Method Count (Weighted Method per Class) (WMC) A weighted sum of methods implemented within a class. It is parameterized by a way to compute the weight of each method

Potential trouble spots in the codebase:BiomeCommands Class, BrushCommands Class  and a lot of other classes because of the high Coupling Between Objects metric value and BrushCommands Class because of the high  Response for Class metric value

The high Coupling Between Objects value and the The Response for Class value is related with the code smell "Inaproppriate intimacy" since their value is so high and when analysing the code I can verify the code smells that were pointed by the collected metrics.
