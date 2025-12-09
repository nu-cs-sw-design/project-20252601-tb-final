package domain.game.cardactions;

import domain.game.CardType;

// ActionFactory is a Simple Factory for creating the actions given the card type
public class ActionFactory {

	public CardAction createAction(CardType type) {
		switch (type) {
			case EXPLODING_KITTEN:
				return new ExplodingKittenAction();
			case SHUFFLE:
				return new ShuffleAction();
			case SKIP:
				return new SkipAction();
			case SUPER_SKIP:
				return new SuperSkipAction();
			case NOPE:
				return new NopeAction();
			default:
				throw new IllegalArgumentException("Invalid card type");
		}
	}
}
