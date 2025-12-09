package domain.game.cardactions;

import domain.game.*;

// Implements Defuse card
public class DefuseAction implements CardAction {

	@Override
	public void execute(Game game, UIInteraction ui, int playerIndex) {
		Player currentPlayer = game.getPlayerAtIndex(playerIndex);

		ui.displayMessage("defusedMessage");
		int defuseIndex = currentPlayer.getIndexOfCard(CardType.DEFUSE);
		currentPlayer.removeCardFromHand(defuseIndex);

		int deckSize = game.getDeckSize();
		ui.displayMessage("whereToInsertMessage");
		ui.displayMessage("validRangeMessage", deckSize);

		int insertIndex = -1;
		boolean validInput = false;
		while (!validInput) {
			try {
				insertIndex = ui.getUserInputInteger();

				if (insertIndex >= 0 && insertIndex <= deckSize) {
					validInput = true;
				} else {
					ui.displayMessage("invalidInputMessage");
					ui.displayMessage("validRangeMessage", deckSize);
				}
			} catch (Exception e) {
				ui.displayMessage("invalidInputMessage");
				// remove invalid token
				ui.getUserInputToken();
			}
		}

		game.getDeck().insertExplodingKittenAtIndex(insertIndex);
		game.setCurrentPlayerNumberOfTurns(0);
	}
}
