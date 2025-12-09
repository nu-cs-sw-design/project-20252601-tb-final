package domain.game.cardactions;

import domain.game.Game;
import domain.game.UIInteraction;

// ShuffleAction implements shuffle card
public class ShuffleAction implements CardAction {
	@Override
	public void execute(Game game, UIInteraction ui, int playerIndex) {
		ui.displayMessage("decidedShuffle");

		int numberOfShuffle;
		final int maxNumberOfShuffles = 100;
		while (true) {
			ui.displayMessage("enterShuffleTimes");
			try {
				numberOfShuffle = ui.getUserInputInteger();
				if (numberOfShuffle > maxNumberOfShuffles) {
					ui.displayMessage("maxShuffleMessage");
				} else if (numberOfShuffle > 0) {
					break;
				} else {
					ui.displayMessage("enterPositiveInteger");
				}
			} catch (Exception e) {
				ui.displayMessage("enterInteger");
				ui.getUserInputToken();
			}
		}
		game.playShuffle(numberOfShuffle);
	}
}
