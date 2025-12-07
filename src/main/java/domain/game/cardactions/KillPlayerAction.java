package domain.game.cardactions;

import domain.game.Game;
import domain.game.Player;
import domain.game.UIInteraction;

public class KillPlayerAction implements CardAction {
    @Override
    public void execute(Game game, UIInteraction ui) {
        int playerIndex = game.getPlayerTurn();
        Player currentPlayer = game.getPlayerAtIndex(playerIndex);

        ui.displayMessage("noDefuseCardMessage");
        ui.displayMessage("youExplodedMessage");

        currentPlayer.setIsDead();
        game.setCurrentPlayerNumberOfTurns(0);
    }
}
