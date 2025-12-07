package domain.game;

// NopeAction implements Nope card
public class NopeAction implements CardAction {
    @Override
    public void execute(Game game, UIInteraction ui) {
        int playerIndex = game.getPlayerTurn();

        ui.displayMessage("decidedToPlayNope", playerIndex);
        game.removeCardFromHand(playerIndex, CardType.NOPE);

        if (game.hasPendingActions()) {
            game.popAction();
            ui.displayMessage("successfullyPlayedNope", playerIndex);
        }
    }
}