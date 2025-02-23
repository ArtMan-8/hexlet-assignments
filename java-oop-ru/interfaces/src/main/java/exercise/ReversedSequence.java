package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String sequence;

    public ReversedSequence(String sequence) {
        this.sequence = sequence;
    }

    public int length() {
        return sequence.length();
    }

    public char charAt(int index) {
        return sequence.charAt(length() - index - 1);
    }

    public CharSequence subSequence(int start, int end) {
        return new ReversedSequence(sequence.substring(start, end));
    }

    public String toString() {
        return new StringBuilder(sequence).reverse().toString();
    }
}
// END
