package domain.game.cardactions;

import domain.game.*;

// Implements Exploding Kitten card
public class ExplodingKittenAction implements CardAction {
    @Override
    public void execute(Game game, UIInteraction ui) {
        ui.displayMessage("explodingKittenMessage");

        int playerIndex = game.getPlayerTurn();
        Player currentPlayer = game.getPlayerAtIndex(playerIndex);

        if (currentPlayer.hasCard(CardType.DEFUSE)) {
            new DefuseAction().execute(game, ui);
        } else {
            new KillPlayerAction().execute(game, ui);
        }
    }
}
