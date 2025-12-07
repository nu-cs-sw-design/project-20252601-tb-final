package domain.game;

// UIInteraction represents an object the domain layer use to request the UI
public interface UIInteraction {
    // args accepted for formatting messages
    void displayMessage(String messageKey, Object... args);

    int getUserInputInteger();

    String getUserInputToken();
}
