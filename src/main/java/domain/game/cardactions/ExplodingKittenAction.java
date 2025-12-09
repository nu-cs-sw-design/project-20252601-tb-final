package domain.game.cardactions;

import domain.game.*;

// Implements Exploding Kitten card
public class ExplodingKittenAction implements CardAction {
	@Override
	public void execute(Game game, UIInteraction ui, int playerIndex) {

		ui.displayMessage("explodingKittenMessage");

		boolean isPlayerExploded = false;
		try {
			isPlayerExploded = game.playExplodingKitten(playerIndex);
		} catch (UnsupportedOperationException e) {
			ui.displayMessage("invalidPlayerIndexExplodingKitten");
		}

		if (isPlayerExploded) {
			ui.displayMessage("noDefuseCardMessage");
			ui.displayMessage("youExplodedMessage");
			return;
		}

		Player player = game.getPlayerAtIndex(playerIndex);

		if (player.getIsCursed()) {
			handleCursedDefuse(game, ui, player, playerIndex);
		} else {
			delegateToDefuse(game, ui, playerIndex);
		}
	}

	private void handleCursedDefuse
			(Game game, UIInteraction ui, Player player, int playerIndex) {
		ui.displayMessage("cursedExplodingMessage");

		while (true) {
			ui.displayMessage("findDefuseCardMessage", player.getHandSize() - 1);
			String defuseString = ui.getUserInputToken();
			try {
				int defuseIndex = Integer.parseInt(defuseString);
				if (defuseIndex < 0 || defuseIndex >= player.getHandSize()) {
					throw new IndexOutOfBoundsException();
				}

				Card card = player.getCardAt(defuseIndex);
				CardType type = card.getCardType();
				if (type == CardType.DEFUSE) {
					delegateToDefuse(game, ui, playerIndex);
					return;

				} else if (type == CardType.EXPLODING_KITTEN) {
					ui.displayMessage("anotherExplodingKittenMessage");
					player.removeCardFromHand(defuseIndex);

					this.execute(game, ui, playerIndex);
					if (!player.hasCard(CardType.DEFUSE)) {
						ui.displayMessage("noDefuseCardMessage");
						ui.displayMessage("youExplodedMessage");
						return;
					}
					ui.displayMessage("defusedFirstExplodingKitten");
					// Continue loop to handle the original bomb

				} else if (
						type == CardType.STREAKING_KITTEN &&
						player.hasCard(CardType.EXPLODING_KITTEN)
				) {
					ui.displayMessage("discardStreakingKittenMessage");
					player.removeCardFromHand(defuseIndex);
					player.removeCardFromHand(
							player.getIndexOfCard(
									CardType.EXPLODING_KITTEN
							)
					);

					this.execute(game, ui, playerIndex);
					if (!player.hasCard(CardType.DEFUSE)) {
						ui.displayMessage("noDefuseCardMessage");
						ui.displayMessage("youExplodedMessage");
						return;
					}
					ui.displayMessage("defusedFirstExplodingKitten");
				} else {
					ui.displayMessage("notDefuseCardMessage");
					player.removeCardFromHand(defuseIndex);
					ui.displayMessage("discardCardMessage");
					ui.displayMessage("reenterDefuseMessage");
				}
			} catch (RuntimeException e) {
				ui.displayMessage("invalidInputMessage");
			}
		}
	}

	private void delegateToDefuse(Game game, UIInteraction ui, int playerIndex) {
		ActionFactory factory = new ActionFactory();
		CardAction defuseAction = factory.createAction(CardType.DEFUSE);
		defuseAction.execute(game, ui, playerIndex);
	}

}
