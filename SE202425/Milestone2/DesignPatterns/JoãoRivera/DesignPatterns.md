Singleton structure

Code snippet:
![image](https://github.com/user-attachments/assets/7ee21ab2-3c4f-48b9-9285-66475846cf8e)

Class diagram:
![image](https://github.com/user-attachments/assets/3649acec-e2b8-4963-ad4c-a08eabb14f12)

Location on the codebase: worldedit-core/src/main/java/com/sk89q/worldedit/WorldEdit.java    method -> getInstance()

Discussion of the rationale for identifying: I initially thought it would make sense to have only a single instance of the mod running so I went to check if that was in fact what happened and it turned out it was. To identify the pattern i searched for a get instance method and made sure the instance itself was made private so that other classes would never get access to it without the getInstance method.

