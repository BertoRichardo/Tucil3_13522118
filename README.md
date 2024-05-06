# Description

Word ladder, also known as Doublets, word-links, change-the-word puzzles, paragrams, laddergrams, or word golf, is a popular word game for people of all ages. It was invented by Lewis Carroll, an author and mathematician, in 1877. In this game, players are given two words, called the start word and the end word. The goal is to find a chain of words that connects the start word to the end word. The number of letters in the start and end words is always the same. Each adjacent word in the chain may only differ by one letter. This program uses 3 algorithms to solve the Word Ladder: Uniform Cost Search (UCS) Algorithm, Greedy Best First Search (GDFS) Algorithm, and A\* Algorithm.

# Requirement

Tested on openjdk 11 on Linux and Java 21 on Windows

# How to Compile

Windows and Linux :

```
javac -d bin src/*.java
```

# How to Run

Windows & Linux :  
Make sure program already compiled by your machine, run this command from the root directory:

```
java -cp bin Main <algorithm (ucs/greedy/astar)> <start> <end>
```

# Contributor

Berto Richardo Togatorop - 13522086
