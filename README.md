# 🐍 SnakeGame - Java (2017)

Welcome to my ancient Java Snake game — a project born on **June 17th, 2017**, back when I was just 17 years old.  
This was one of my earliest attempts at creating something visual and interactive, long before I understood the fundamentals of clean code, object-oriented design, or even modular thinking.

## 🕹️ What is this?

This is a fully playable version of the classic Snake game, written entirely in **raw Java Swing and AWT**, without the use of classes or objects (beyond the `JFrame` wrapper and some basic event handling).  
It’s a living fossil from my programming past — a chaotic yet functional glimpse into my mind as a teenager trying to figure things out line by line.

Yes, it works.  
Yes, you can move the snake, collect apples, and crash into walls.  
But the code? The code is... something else entirely.

## 🤯 The Code

> _"Only God knows how this was made."_

That’s not hyperbole — that’s the truth.  
The code is not structured. There’s no MVC pattern. There are no comments in most places.  
It’s a strange hybrid of procedural logic, spontaneous inspiration, and desperate hacks.

Some highlights:
- Global variables everywhere
- A 400x400 2D int array used as the game field
- No class for `Snake`, no class for `Apple`, no class for `GameEngine`
- Movement handled via raw key events with `if` trees and directional booleans
- The `paint()` method abused as a game loop via repeated calls to `repaint()` and `Thread.sleep()`
- Collision detection based on raw array comparisons
- One file. One main method. One big nostalgic mess.

But somehow... it runs.

## 🛠️ Technologies Used

- Java SE 8 (or higher)
- Swing / AWT
- No external libraries
- No game engine
- Just pure Java logic and pixel-level graphics with `drawLine`

## 🎮 Controls

Use the arrow keys or **WASD** to control the snake:

- `←` or `A` – Move Left  
- `→` or `D` – Move Right  
- `↑` or `W` – Move Up  
- `↓` or `S` – Move Down

Double-click the window to start the game.

Once the game starts:
- Each apple collected increases the snake’s length.
- Crashing into a wall or your own tail ends the game.
- A popup shows your final score.

## 🧪 Known Issues / Quirks

- There is no pause or restart button.
- If you press multiple keys rapidly, strange things may happen.
- The entire game logic is embedded inside the `paint()` method, which should NOT be used as a game loop.
- Game speed is tied to `Thread.sleep(100)`, with no proper timing control.
- If your system doesn't support GUI (e.g. you're running headless), the game will crash with `HeadlessException`.

## 🧠 What I’ve Learned Since Then

Since creating this project, I’ve grown immensely as a developer. I now understand:
- The value of object-oriented programming
- Proper code separation and readability
- Game loops, timers, and animation frames
- User input debouncing and event-driven programming
- How to not abuse global variables and repaint()

But I’ve decided to leave this project **as it was** — untouched — as a monument to how far I’ve come.

## 🏛️ Why Preserve This?

Because every developer has a beginning.  
This game is mine.

It might be ugly, unoptimized, and confusing, but it holds tremendous sentimental value.  
I didn’t understand what I was doing, but I was doing it anyway.  
That’s the spirit of a true beginner — pure creativity, fueled by curiosity and trial-and-error.

This isn’t meant to impress.  
This is meant to **remember**.

## 💡 Can I Improve It?

Definitely.  
In fact, if you’re looking at this code and your fingers are itching to refactor it — go for it.  
Fork the project. Rewrite it using proper classes (`Snake`, `Apple`, `GameBoard`, etc.).  
Use JavaFX. Add sound. Add a scoring system.  
Or just enjoy the beautiful chaos as it is.

## 🔓 License

This project is public and unlicensed.  
Do whatever you want with it — but if you improve it, I’d love to see what you’ve done.  
Drop a star or a comment.  
Or just smile, knowing someone else once wrote code like this too.

---

## ✍️ Author

Created by me, aged 17, on June 17th, 2017.

Still wondering how I managed to make it work.
