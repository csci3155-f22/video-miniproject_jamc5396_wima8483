# Principles and Practice in Programming Languages
# Mini-Project: Fall 2022

See [instructions.md](instructions.md) for submission instructions.

# Higher Order Function Deep Dive

## Description

The higher order function deep dive will look into use cases of FoldLeft/FoldRight functions, Map function, MapFirst function, flatMap, and others. We will use these functions in different tree data structures, working our way from simple use cases to more complex cases such as a tree whose nodes are lists. This material can be used as a study guide to master higher-order functions in Scala, as well as to obtain a deep understanding of representing data structures through abstract syntax. An example of what will be done is: summing the nodes of a tree using FoldLeft/FoldRight, progressing to summing the nodes of a tree whose nodes are a list of integers, requiring the addition of other higher-order functions such as Map. Other use cases and data structures will be added as the project progresses, but all higher-order functions mentioned will be used. The material will be presented as a recorded slide-show with a voice over and should be used by students reviewing for the final exam.
## Repository Organization

#Setting up repository
1) After cloning repository, ensure that the most recent version of Scala is installed, and the Metals extension in VS Code.
2) To check if build is working, in the command line enter 'cd workspace', then 'sbt test'
3) It is imperative to run sbt test within the workspace folder because that is where the build is

#Using repository
1) Navigate to the workspace folder
2) Under the folder src we have ./main and ./test
3) We will be using the worksheet.worksheet.sc file within /src/main to demonstrate code
4) Testing will likely be implemented as well as /src/main/main.scala at a later date 

## Presentation

TODO: Update the following links and remove this line.

- YouTube: https://youtu.be/TODO.
- Script: [script.md](script.md) or [script.pdf](script.pdf).
- Recording: [recording.mp4](recording.mp4).
- Slides (if you use them in your recording): [slides.pdf](slides.pdf) and slide sources (e.g., [slides.pptx](slides.pptx) or [slides.key](slides.key)).

## Resources
Higher-order functions in general
- https://eloquentjavascript.net/05_higher_order.html

Overview of higher-order functions in Scala
- https://www.youtube.com/watch?v=KwrwkyUq6jY 
- https://docs.scala-lang.org/tour/higher-order-functions.html 
- https://www.geeksforgeeks.org/higher-order-functions-in-scala/ 

Foldleft v. Foldright
- https://coderwall.com/p/4l73-a/scala-fold-foldleft-and-foldright 

flatMap
- https://www.geeksforgeeks.org/scala-flatmap-method/
