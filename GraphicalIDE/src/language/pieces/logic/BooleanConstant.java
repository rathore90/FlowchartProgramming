package language.pieces.logic;

import java.awt.Point;

import javax.swing.JOptionPane;

import language.Connection;
import language.Piece;
import language.ProgramContext;
import language.type.Type;
import language.value.ProgramValueBoolean;

/**
 * The Class NumberConstant.
 */
public class BooleanConstant extends Piece {

	/** The value stored by this piece. */
	private ProgramValueBoolean value;

	/**
	 * Instantiates a new number constant.
	 *
	 * @param value
	 *            the value
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public BooleanConstant(final Boolean value, final int x, final int y) {
		super(0, 1, x, y);
		setValue(value);
	}

	/**
	 * Instantiates a new number constant with a value of 0.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public BooleanConstant(final int x, final int y) {
		this(false, x, y);
	}

	/**
	 * returns the piece name.
	 *
	 * @return the string
	 */
	public static String name() {
		return "Logic.Boolean Constant";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see language.Piece#update(language.ProgramContext)
	 */
	@Override
	public void updatePiece(final ProgramContext context) {
		for (final Connection c : getOutputs()) {
			c.changeInput(value);
		}
	}

	/**
	 * Sets the value stored by this piece..
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(final Boolean value) {
		this.value = new ProgramValueBoolean(value);
		setOutputText(0, value.toString());
		this.updateNextTick();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see language.Piece#doubleClicked(java.awt.Point)
	 */
	@Override
	public void doubleClicked(final Point p) {

		final String input = JOptionPane.showInputDialog("Set Value: ", String.valueOf(value));
		if (input != null) {
			setValue(Boolean.valueOf(input));
		}
	}

	@Override
	public boolean shouldUpdateEveryTick() {
		return false;
	}

	@Override
	public Type getOutputType() {
		return Type.BOOLEAN;
	}

	public boolean getValue() {
		return value.getValue();
	}
}
