package domain.game.cardactions;

import domain.game.Game;
import domain.game.UIInteraction;

// implements the Skip card
public class SkipAction implements CardAction {

    @Override
    public void execute(Game game, UIInteraction ui) {
        ui.displayMessage("decidedSkip");
        int turnsLeft = game.playSkip(false);
        ui.displayMessage("turnsRemaining", turnsLeft);
    }
}