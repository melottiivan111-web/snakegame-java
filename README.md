# 🐍 SnakeGame - Java (2017)

Welcome to my ancient Java Snake game — a project born on June 17th, 2017, back when I was just 17 years old.  
This was one of my earliest attempts at creating something visual and interactive, long before I understood the fundamentals of clean code, object-oriented design, or even modular thinking.

## 🕹️ What is this?

This is a fully playable version of the classic Snake game, written entirely in raw Java Swing and AWT, without the use of classes or objects (beyond the JFrame wrapper and some basic event handling).  
It’s a living fossil from my programming past — a chaotic yet functional glimpse into my mind as a teenager trying to figure things out line by line.

Yes, it works.  
Yes, you can move the snake, collect apples, and crash into walls.  
But the code? The code is... something else entirely.

## 🤯 The Code

_"Only God knows how this was made."_

That’s not hyperbole — that’s the truth.  
The code is not structured. There’s no MVC pattern. There are no comments in most places.  
It’s a strange hybrid of procedural logic, spontaneous inspiration, and desperate hacks.

Some highlights:

- Global variables everywhere  
- A 400x400 2D int array used as the game field  
- No class for Snake, no class for Apple, no class for GameEngine  
- Movement handled via raw key events with if trees and directional booleans  
- The paint() method abused as a game loop via repeated calls to repaint() and Thread.sleep()  
- Collision detection based on raw array comparisons  
- One file. One main method. One big nostalgic mess.

But somehow... it runs.

## 🛠️ Technologies Used

- Java SE 8 (or higher)  
- Swing / AWT  
- No external libraries  
- No game engine  
- Just pure Java logic and pixel-level graphics with drawLine

## 🎮 Controls

Use the arrow keys or WASD to control the snake:  
← or A – Move Left  
→ or D – Move Right  
↑ or W – Move Up  
↓ or S – Move Down  
Double-click the window to start the game.

Once the game starts:

- Each apple collected increases the snake’s length.  
- Crashing into a wall or your own tail ends the game.  
- A popup shows your final score.

## 🤣 Friends’ Reactions

My friends love to laugh at this code — but despite the jokes, they also have mad respect for what it manages to do.  
After all, this was my teenage brain going full Einstein-level discovery mode, using 100% of its power to crack the code of snake movement — just like he cracked relativity.

## 🧪 Known Issues / Quirks

- No pause or restart button.  
- Pressing multiple keys fast can confuse the snake.  
- The entire game logic is embedded inside paint(), which is not best practice.  
- Speed is tied to Thread.sleep(100) with no fine control.  
- Will crash on systems without GUI support (HeadlessException).

## 🧠 What I’ve Learned Since Then

Since creating this, I’ve grown immensely as a developer and now understand:

- Object-oriented programming principles  
- Code separation and readability  
- Proper game loops and timers  
- Event-driven programming  
- Avoiding global variables and abusing repaint()

But I left this project untouched as a monument to my starting point.

## 🏛️ Why Preserve This?

Every coder has a beginning.  
This game is mine.  
It’s messy, but it’s honest.  
It’s proof that curiosity and passion can create something, even if you don’t know exactly what you’re doing.

## 💡 Can I Improve It?

Definitely.  
Feel free to fork, refactor, modernize.  
But you might also just enjoy the chaos as it is.

## 🔓 License

Public domain — do what you want!  
If you improve it, please share back!

## ✍️ Author

Written by me, 17 years old, on June 17th, 2017.  
Still amazed it actually works.
