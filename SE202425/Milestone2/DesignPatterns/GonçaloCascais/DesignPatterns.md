Adapter pattern

Code snippet:

![image](https://github.com/user-attachments/assets/8c6dbdd9-b65a-4225-a005-bf686bf079eb)

Class diagram:

![image](https://github.com/user-attachments/assets/7b881b8f-4df8-4f7f-897a-cdd71ad2c496)

Exact location: WorldEditPrivate/worldedit-fabric/src/main/java/com/sk89q/worldedit/fabric/FabricAdapter.java

Discussion of the rationale for identifying: The FabricAdapter, as a Adapter pattern, helps the communication between two incompatible systems. In this case the systems are the minecraft and the WorldEdit.
It receives a World object (from the WorldEdit API) and checks if it is an instance of FabricWorld. If it is, this means that the World is already adapted for WorldEdit, and the method retrieves the original Level contained within FabricWorld.

----------------------------------------------------------------------------------------------------
Iterator Pattern

Code snippet:

![image](https://github.com/user-attachments/assets/39203809-1a98-45ad-a05b-73c2b9460d06)

![image](https://github.com/user-attachments/assets/2ecf7636-4084-4c18-956b-f2267ef3a47b)


Class diagram:

![image](https://github.com/user-attachments/assets/83561090-9ce3-46dd-937c-294abb0243a3)

Exact location: WorldEditPrivate/worldedit-core/src/main/java/com/sk89q/worldedit/regions
/Polygonal2DRegion.java and
WorldEditPrivate/worldedit-core/src/main/java/com/sk89q/worldedit/regions/iterator/FlatRegion3DIterator.java

Discussion of the rationale for identifying: The Polygonal2DRegion class contains a list of points in a polygonal region, represented as BlockVector3. For users of this class, the internal structure of the points, their storage, or the details of each coordinate's calculation are not directly exposed. Instead, the iterator() method returns an iterator (FlatRegion3DIterator) that encapsulates the logic for navigating through the 3D points. This level of abstraction is a central characteristic of the Iterator Pattern.


--------------------------------------------------------------------------------------------------------
Singleton pattern 

Code snippet:

![image](https://github.com/user-attachments/assets/e6b8741c-2437-4b47-9809-24b75c1eb4af)

Class diagram:

![image](https://github.com/user-attachments/assets/aeb4cb06-f75f-4f58-b30e-451f35664a98)

Exact location: WorldEditPrivate/worldedit-core/src/main/java/com/sk89q/worldedit/util/time
/FileNameDateTimeParser.java

Discussion of the rationale for identifying: I was looking through the code when I saw a reference to a calendar and thought it would make sense to just have an instance of a calendar. I checked and found the FileNameDateTimeParser class.


