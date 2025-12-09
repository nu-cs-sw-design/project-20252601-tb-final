package domain.game.cardactions;

import domain.game.Game;
import domain.game.UIInteraction;

// implements the Super Skip card
public class SuperSkipAction implements CardAction {

	@Override
	public void execute(Game game, UIInteraction ui, int playerIndex) {
		ui.displayMessage("decidedSkip");
		int turnsLeft = game.playSkip(true);
		ui.displayMessage("turnsRemaining", turnsLeft);
	}
}
