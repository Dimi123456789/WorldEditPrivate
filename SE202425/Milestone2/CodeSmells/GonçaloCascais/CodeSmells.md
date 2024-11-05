Multiple try-catch blocks in sequence

Code snippet:

![image](https://github.com/user-attachments/assets/ec54381b-8d33-48c2-b208-1cd9752c97e2)

Exact location: WorldEditPrivate/worldedit-core/src/main/java/com/sk89q/worldedit/command
/LegacySnapshotUtilCommands.java

Explanation of the rationale for identifying this code smell: In the restore method, there are multiple try-catch blocks in sequence, with some nested inside others. This is an indication that the code is performing too many exception-prone operations in a single function, which reduces clarity and increases maintenance complexity.

Refactoring proposal:  Refactor into Helper Methods: Split the logic into smaller, more specialized methods that handle different operations. For instance, move the snapshot loading logic into a separate method that can handle exceptions more specifically.
Encapsulate Error Handling in Utility Methods: Create utility methods that wrap operations in try-catch blocks to improve readability and reduce code duplication.


-------------------------------------------------------------------------------------------------------------------------------------------------------------------
Complex Conditional Logic

Code snippet:

![image](https://github.com/user-attachments/assets/e1a3ac15-1959-4536-a43d-3de31f5b44fe)

Exact location: WorldEditPrivate/worldedit-core/src/main/java/com/sk89q/worldedit/command
/GenerationCommands.java

Explanation of the rationale for identifying this code smell: The logic for determining the zero and unit vectors is quite complex, involving multiple conditional branches. This makes the code harder to read and understand, increasing the risk of errors during maintenance.

Refactoring proposal: Extract this logic into a separate method, such as calculateOriginAndUnit, that returns a pair of Vector3 objects. This would simplify the main method and make the code more readable and easier to maintain.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

Excessive Number of Parameters

Code snippet:

![image](https://github.com/user-attachments/assets/c608edc8-526f-4d14-8861-eeec6aa59147)

![image](https://github.com/user-attachments/assets/317a4d27-e801-402b-830f-b8639f9f98ab)

Exact location: WorldEditPrivate/worldedit-core/src/main/java/com/sk89q/worldedit/command/UtilityCommands.java

Explanation of the rationale for identifying this code smell: The method takes a large number of parameters (10 switches and an argument). This is difficult to read, maintain, and understand. It also makes the method susceptible to user error when calling it with so many switches.

Refactoring proposal: Create a ButcherOptions class or data structure that encapsulates these parameters, improving readability and making it easier to manage options as a single object.

