package life.elements;

import java.util.List;

/**
 *	Representation Deoxyribonucleic acid
 *
 * @author Lekanich
 * @since 0.1
 * @version 0.1
 */
public class DNA implements Macromolecule{
	private final Pair[] pairs;

	/**
	 * Pair nucleobase
	 * @author Lekanich
	 * @since 0.1
	 * @version 0.1
	 */
	final public static class Pair {
		private Nucleobase firstNucleobase;
		private Nucleobase lastNucleobase;

		/**
		 * аденин соединяется только с тимином, гуанин — только с цитозином
		 */
		public enum Nucleobase {
			ADENINE("ADENINE"),
			GUANINE("GUANINE"),
			THYMINE("THYMINE"),
			CYTOSINE("CYTOSINE");

			private String string;

			Nucleobase(String string) {
				this.string = string;
			}

			@Override
			public String toString() {
				return string;
			}
		}

		final public static class NotComplementarityException extends Exception {
			public NotComplementarityException(String msg) {
				super("Can't complementary nucleobase: " + msg);
			}
		}

		public Pair(Nucleobase first, Nucleobase last) throws NotComplementarityException {
			if (!checkCorrect(first, last)) throw new NotComplementarityException(first.toString() + " " + last.toString());
			this.firstNucleobase = first;
			this.lastNucleobase = last;
		}

		public Nucleobase getFirstNucleobase() {
			return firstNucleobase;
		}

		public void setFirstNucleobase(final Nucleobase firstNucleobase) {
			this.firstNucleobase = firstNucleobase;
		}

		public Nucleobase getLastNucleobase() {
			return lastNucleobase;
		}

		public void setLastNucleobase(final Nucleobase lastNucleobase) {
			this.lastNucleobase = lastNucleobase;
		}

		private boolean checkCorrect(Nucleobase first, Nucleobase last) {
			switch (first) {
				case ADENINE:
					return last == Nucleobase.THYMINE ? true : false;
				case GUANINE:
					return last == Nucleobase.CYTOSINE ? true : false;
				case THYMINE:
					return last == Nucleobase.ADENINE ? true : false;
				case CYTOSINE:
					return last == Nucleobase.GUANINE ? true : false;
				default: return false;
			}
		}
	}

	final public static class InitDNAException extends Exception {}

	public DNA (List<Pair> pairs) throws InitDNAException {
		if (pairs == null || pairs.size() == 0) throw new InitDNAException();
		this.pairs = pairs.toArray(new Pair[1]);
	}

	public DNA (Pair[] pairs) throws InitDNAException {
		if (pairs == null || pairs.length == 0) throw new InitDNAException();
		this.pairs = pairs;
	}


}
