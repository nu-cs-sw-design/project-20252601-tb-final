package domain.game.cardactions;

import domain.game.Game;
import domain.game.UIInteraction;

// CardAction interface allows cards to define the actions that they preform by acting
// on the game and UIInteraction objects. Actions are implemented by overriding the execute
// method
public interface CardAction {
	void execute(Game game, UIInteraction ui, int playerIndex);
}
