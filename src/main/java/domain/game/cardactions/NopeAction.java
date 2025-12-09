package domain.game.cardactions;

import domain.game.CardType;
import domain.game.Game;
import domain.game.UIInteraction;

// NopeAction implements Nope card
public class NopeAction implements CardAction {
	@Override
	public void execute(Game game, UIInteraction ui, int playerIndex) {
		ui.displayMessage("decidedToPlayNope", playerIndex);
		game.removeCardFromHand(playerIndex, CardType.NOPE);
		ui.displayMessage("successfullyPlayedNope", playerIndex);
	}
}
