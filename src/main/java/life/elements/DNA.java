package life.elements;

import java.util.List;

/**
 * <short desctiption>
 *
 * <long desctiption>
 *
 * @author Suburban Squirrel
 * @since <version>
 */
public class DNA implements Macromolecule{
	private List<Pair> pairs;


	final public static class Pair {
		private Nucleobase firstNucleobase;
		private Nucleobase lastNucleobase;

		/**
		 * аденин соединяется только с тимином, гуанин — только с цитозином
		 */
		public enum Nucleobase { ADENINE, GUANINE, THYMINE, CYTOSINE }

		final public static class ComplementarityException extends Exception {
			public ComplementarityException(String msg) {
				super("");
			}
		}

		public Pair(Nucleobase first, Nucleobase last) throws ComplementarityException {
			if (!checkCorrect(first, last)) throw new ComplementarityException("");
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


	public DNA (int countPairs, List<Pair> pairs) {

	}

}
