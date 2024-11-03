Factory method pattern

Code snipet:
 ![image](https://github.com/user-attachments/assets/7a8c075f-2ba3-4ed2-b5e2-f756a127bf5a)

Class diagram:
 ![image](https://github.com/user-attachments/assets/4a007107-3bd6-4b80-b5e7-ad8afb1c04ac)
 

Location on code base: WorldEditPrivate\worldedit-core\src\main\java\com\sk89q\worldedit\command\factory\FeatureGeneratorFactory.java    createFromContext() method

Discussion of the rationale for identifying:
The FeatureGeneratorFactory class uses the createFromContext() method to create a new RegionMaskingFilter instance.
This method accepts an EditContext as a parameter, which gives you access to the context needed to construct a RegionMaskingFilter object configured with a noise filter and a feature generator .
Instead of directly creating these objects in various parts of the code, the FeatureGeneratorFactory factory encapsulates the creation and allows client code to request configured instances without worrying about the internal details.

Adapter pattern

Code snipet:
![image](https://github.com/user-attachments/assets/ed153dd5-3707-4bb5-8d58-1e1dbdb5a402)

Class diagram:

![WhatsApp Image 2024-11-03 at 16 44 34](https://github.com/user-attachments/assets/8c9fdf3e-7ce5-40b2-a24e-af0560a24d0b)

Location on code base: WorldEditPrivate\worldedit-fabric\src\main\java\com\sk89q\worldedit\fabric\FabricAdapter.java  (for example: public static Block adapt(BlockType blockType) )

Discussion of the rationale for identifying:
The Adapter pattern was chosen because it provides a structured and efficient way to convert data between two incompatible systems (Minecraft and WorldEdit) without altering either system. This approach promotes code reuse, maintainability, and scalability while keeping the interfaces clean and compatible.
