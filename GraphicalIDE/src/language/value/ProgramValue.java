package language.value;

import language.type.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class ProgramValue.
 *
 * @param <T>
 *            the generic type
 */
public abstract class ProgramValue<T> {

	/** The value. */
	T value;

	/**
	 * Instantiates a new program value.
	 *
	 * @param value
	 *            the value
	 */
	public ProgramValue(final T value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (value == null) {
			return "Nothing";
		}
		return value.toString();
	}

	public abstract Type getType();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (value == null ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ProgramValue<?> other = (ProgramValue<?>) obj;
		if (value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!value.equals(other.value)) {
			return false;
		}
		return true;
	}

}
