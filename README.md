# TDT4240 individual exercise 2

## References

- Brent Aureli Codes tutorial https://www.youtube.com/watch?v=rzBVTPaUUDg&list=PLZm85UZQLd2TPXpUJfDEdWTSgszionbJy
- LibGDX "A simple game" https://libgdx.com/wiki/start/a-simple-game
- Singleton pattern https://en.wikipedia.org/wiki/Singleton_pattern

## Exercise 2

The chosen program from exercise 1 is the Pong program.

### Singleton pattern

The pong program has a GameStateManager that is intended to manage the different states of the game, and as such it makes sense to only have one instance of the GameStateManager class, one "manager".

The singleton pattern is implemented in GameStateManager following the lazy implementation example from the Wikipedia article on the Singleton pattern to ensure that only one instance of the GameStateManager class is created, by making the constructor private and the `getInstance()` method is used to get the instance of the GameStateManager class.

```diff
public class GameStateManager {
+   private static GameStateManager instance = null;
    private Stack<State> states;

-   public GameStateManager() {
+   private GameStateManager() {
        states = new Stack<State>();
    }
+    public static GameStateManager getInstance() {
+       if (instance == null) {
+           instance = new GameStateManager();
+       }
+        return instance;
+   }
}
```

### The template method pattern

The template method pattern is used to standardize the structure of the game and define a high-level algorithm. This is done by creating an abstract class `State` that defines the basic steps of the game; initializing the game, updating the game loop, rendering the graphics, and handling user input. Concrete implementations can then happen in subclasses.

An example is the `PongState` class, which extends the `State` class and implements the abstract methods. The `public abstract void update(float dt)` method controls the game loop; the flow of the game and all its elements based on elapsed time. In our example, the PongState subclass uses the update method to update the positions and animations of the game entities (the "ball" and "paddles"), while the MenuState subclass could use it to update the selected menu item.

### Theory questions

Observer, State, Template method, and Abstract Factory are design patterns, while Model View Controller, Entity Component System, and Pipe and filter are architectural patterns.

Design patterns are reusable solutions to common software development problems. They provide a general template or a set of guidelines that can be applied in various situations, focusing on specific parts of the system.

Architectural patterns, on the other hand, define the overall structure or organization of the code. They provide a high-level view to how components should be organized and how they should interact with each other.

The chosen pattern implementation is described in the previous section, and the advantages are clear. **The disadvantages** of the template method pattern is that it is inflexible as changes to the structure of the game will require changes to the abstract class which affects the whole hierarchy. For a simple problem, using the template method pattern could result in overengineering and overcomplication.
