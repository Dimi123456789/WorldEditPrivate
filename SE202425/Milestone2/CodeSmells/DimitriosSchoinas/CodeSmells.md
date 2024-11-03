Inaproppriate Intimacy

Code snipet:

![image](https://github.com/user-attachments/assets/6e818302-4c5e-4c9e-80b1-06ccf386183e)
![image](https://github.com/user-attachments/assets/4f735f8d-2a2e-4af0-8ebd-8d7470192e8f)

Exact location: WorldEditPrivate\worldedit-core\src\main\java\com\sk89q\worldedit\command\ToolCommands.java     

Explanation of the rationale for identifying this code smell: The ToolCommands class relies on multiple components and accesses many different classes and their specific functions to perform command operations. This is especially evident in methods that use several classes and objects from other packages (CommandManager, LocalSession, WorldEdit, Player, etc.), indicating that ToolCommands has a high level of coupling with these classes. This reliance on the internal workings of many classes suggests that ToolCommands might be too "intimate" with these other classes.
I found this code smell because the code metrics showed that this method had high coupling

Long method

Code snipet:

![image](https://github.com/user-attachments/assets/03a66fc2-ddd2-45f8-a4a8-436f9c933c20)
![image](https://github.com/user-attachments/assets/5a9fc203-87c9-4e63-b5a5-735a37978fd6)
![image](https://github.com/user-attachments/assets/c9b6ec71-3256-46e0-9980-bcd0417c8684)
![image](https://github.com/user-attachments/assets/4a2ff669-85d7-4d86-9339-f6140e942d14)
![image](https://github.com/user-attachments/assets/fc485814-0879-4f1f-a4ad-285811b173c4)
![image](https://github.com/user-attachments/assets/6c0445b9-43f5-43ed-a253-cb681b722fb2)

Exact location: WorldEditPrivate\worldedit-core\src\main\java\com\sk89q\worldedit\extent\clipboard\io\sponge\SpongeSchematicV2Writer.java      ( write2() method)

Explanation of the rationale for identifying this code smell: 
The method is lengthy, spanning numerous lines with multiple embedded blocks and layers of logic. This makes it hard to read, understand, and maintain.It performs several distinct tasks that could be refactored into separate methods
I found this code smell because the code metrics showed that it is a long method

Long parameter list

Code snipet:

![image](https://github.com/user-attachments/assets/4d9fb2ba-1e88-429a-97b3-ce06f8d75b58)

Exact location:
WorldEditPrivate\worldedit-core\src\main\java\com\sk89q\worldedit\command\UtilityCommands.java    ( butcher() method)

Explanation of the rationale for identifying this code smell: 
This method has too many parameters, making it hard to understand and maintain. Excessive parameters often indicate the need for refactoring, possibly by grouping related parameters into objects or classes
I chose this code smell because the metric profile showed that this method had very high parameter number.
