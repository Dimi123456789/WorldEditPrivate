
**Code metrics Reviews**

Dimitrios code metrics- Review from Gonçalo Cascais 60046: The metrics are well defined and easy to understand, good work.

Diogo code metrics-Review by João Nascimento 62896 -> Seems nice and I liked the explanation, identifying where could be a code smell, eventhough not identifying which ones.

Goncalo code metrics-Review by João Rivera 62877 -> Looks good to me, well explained and associated to extreme cases of each class, just seems like you could've also added which code smells relates to each metric

Joao Nascimento code metrics- Review by Diogo Mateus 65379: It's explained what each metric does and how it indicate which Code Smells, and I like that. You didn't make a connection with the database and the code. The excel sheet having more information than needed also doesn't help.

Joao Rivera code metrics-Review from Dimitrios Schoinas 65313: I think that your metrics graph is very well done since it makes easier to identify potencial code smells; however, I can't visualise well your metrics excel document possibly due to incopatibilitys


**Code smells Reviews:**

Dimitrios Code Smells

Review code smell 1: João Rivera 62877 -Hard to find how you would proceed with the refactoring since it is in the middle of the explanation of how you found this code smell.

Review code smell 2: Gonçalo Cascais 60046 -Your analysis of the code smell is well done, You've accurately identified the potential issues and provided clear explanations on why they could impact maintainability and readability.

Review code smell3: João Nascimento 62896 -The code smell is well explained and is a correct identification of a long parameter code smell. The solution apresented should solve the problem in question. Well done.

Diogo Code smells

Review code smell 1: João Nascimento 62896 - It is true, this Long Parameter code smell could lead to a very difficult understanding of the code.

Review code smell 2: Dimitrios Schoinas 65313 - This particular snippet shows multiple method calls across different classes, resulting in a complex dependency chain. So I think it is well defined

Review code smell 3: Gonçalo Cascais 60046 - I believe that making this adjustment will enhance the clarity of the code and simplify future updates or modifications

Goncalo code smells

Review Code Smells 1: João Rivera 62877 - Looks good to me, the suggestion for the refactoring also seems correct and how I would do it.

Review Code Smell 2: Diogo Mateus 65379 - I agree with the found problem. The implementation of that Class should solve the issue in question. Good work.

Review Code Smell 3: João Nascimento 62896 - Agreed, it is a too long method impacting the understanding of the code, good job identifying it!

Joao Nascimento code smells

Review code smell 1: João Rivera 62877 - Looks good only shares the same problem I had with the other code smell I reviewed that is the refactoring is hard to find as it is in the middle of the explanation of how you found the code smell.

Review code smell 2: Dimitrios Schoinas 65313 - This code smell seems well identified since there is not any code inside it , which means that this method is a good example for speculative generality code smell since it doesn't add any behavior and adds unnecessary 
complexity to the code.
Review code smell 3: Diogo Mateus 65379 - Looks all good to me. Well identified and for sure a Long Method code smell.

Joao Rivera code smells

Review Code Smell 1: Diogo Mateus 65379 - More examples than needed which helps identify and visualize the problems better, good work. You also divided the main points well. The only thing to note is that in the Code Snippet, it would be easier if you showed in which line the method was located, as it would make it easier to find in the Class.

Reveiew Code Smell 2: Dimitrios Schoinas 65313 -I think that overall you selected a good code smell since I can easily see a better implementation as you said.

Reveiew Code Smell 3: Gonçalo Cascais 60046 - I completely agree with your suggestion to create an object for the parameters instead of passing multiple individual parameters. This approach will definitely enhance the clarity and maintainability of our code.


**Design Patterns:**

Dimitrios Patterns

Review Code Smell 1: Diogo Mateus 65379 - More examples than needed which helps identify and visualize the problems better, good work. You also divided the main points well. The only thing to note is that in the Code Snippet, it would be easier if you showed in which line the method was located, as it would make it easier to find in the Class.

Reveiew Code Smell 2: Dimitrios Schoinas 65313 -I think that overall you selected a good code smell since I can easily see a better implementation as you said.

Reveiew Code Smell 3: Gonçalo Cascais 60046 - I completely agree with your suggestion to create an object for the parameters instead of passing multiple individual parameters. This approach will definitely enhance the clarity and maintainability of our code.
Diogo Patterns

Pattern 1 - Dimitrios Schoinas 65313 - I think that the class is well identified even though you could show a better method as an example

Pattern 2 - João Rivera 62877 - Looks like an iterator pattern and seems to me that the class diagram is also well done.

Patter 3 - Gonçalo Cascais 60046 - Singleton well identified

Goncalo Patterns

Pattern 1 - João Rivera 62877 - Everyithing looks good on this one.

Pattern 2 - João Nasicmento 62896 - Is a good identification of the pattern. Explains the necessity of it well. Good work!

Pattern 3 - Dimitrios Schoinas - I think it is well explained since the class has just 1 entry and 1 access point to that instance

Joao Nascimento Patterns

Pattern 1 - João Rivera 62877 - Seems like a factory pattern to me well done.

Pattern 2 - Gonçalo Cascais 60046 - The template pattern is well identified.

Pattern 3 - Diogo Mateus 65379 - Looks well done, I agree that it's an observer Design Pattern.

Joao Rivera Patterns

Pattern 1 - Dimitrios Schoinas 65313- I think that it is a very good example of the singleton design pattern

Pattern 2 - João Nascimento 62896 - Agreed and well identified!

Pattern 3 - Diogo Mateus 65379- You think well, that's a proxy indeed. Well done.

**Use cases Reviews**:

Dimitrios Use cases
Review from João Rivera 62877: I feel like the saying the player binds the tool is incorrect as it is the system itself that binds it, the player simply selects which tool he wishes to be bound.

Diogo Use cases
Review from Gonçalo Cascais 60046: Everything seems fine, all use cases are clearly identified

Goncalo use cases
Review from Gonçalo Cascais 60046: Everything seems fine, all use cases are clearly identified

Joao Nascimento use cases
Diogo Mateus 65379: At the moment of this writing, you have the same Use Case that Rivera did "pos1". That's something you need to change, since he did it first.

Joao Rivera Use cases
Review from João Nascimento 62896 -> A nice and detailed description and a very nice graphic, these are very good use cases, good job!
