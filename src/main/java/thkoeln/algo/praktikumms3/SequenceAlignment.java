package thkoeln.algo.praktikumms3;

import java.util.Scanner;

public class SequenceAlignment {
    private int matchReward = 2;
    private int mismatchPenalty = -1;
    private int gapPenalty = -2;

    private static String seq_a;
    private static String seq_b;

    private static String aligned_seq_a = "";
    private static String buffer = "";
    private static String aligned_seq_b = "";

    private static int[][] matrix;

    public SequenceAlignment (String s1, String s2){
        seq_a = s1;
        seq_b = s2;
    }

    /*
    A C C G G T C - G A G T G C G C G G A A G C - C G G C C G A
        | |   | |   | |   | | |   |   |     | |   |   |       |
    G T C G T T C G G A A T G C - C - G T T G C T C T G T A A A

    A C C G G T C G A G T G C G C G G A A - G C C G - - G C - C - G - A - -
          |   | | |     |   | |   |   | |   | | | |     | |   |   |   |
    - - - G - T C G - - T T C G - G - A A T G C C G T T G C T C T G T A A A

    A C C G G T C G - A G T G C G C G G A A G C - C G G C C G A
        | |   | | |   |   | | |   | |       | |   |   |       |
    G T C G T T C G G A A T G C - C G T T - G C T C T G T A A A
     */

    public static void main(String[] args) {

        SequenceAlignment alignment = new SequenceAlignment("ACCGGTCGAGTGCGCGGAAGCCGGCCGA",
                                                            "GTCGTTCGGAATGCCGTTGCTCTGTAAA");

        ScoreModifier scoreModifier = createScoreModifier();
        alignment.alignSequences(scoreModifier);
    }

    private static ScoreModifier createScoreModifier(){
        int match;
        int mismatch;
        int gap;

        Scanner scanner = new Scanner(System.in);
        match = getIntFromUser("Enter match-reward: ");
        mismatch = getIntFromUser("Enter mismatch-penalty: ");
        gap = getIntFromUser("Enter gap-penalty: ");
        System.out.println();

        return new ScoreModifier(match,mismatch,gap);
    }

    private static int getIntFromUser(String question){
        String answer;

        Scanner scanner = new Scanner(System.in);
        System.out.print(question);

        do {
            answer = scanner.nextLine();

            try {
                return Integer.parseInt(answer);
            }
            catch (Exception e){
                System.out.print("Integer required, try again: ");
            }

        } while (true);
    }

    public void alignSequences(ScoreModifier scoreMod){
        matchReward = scoreMod.matchScore;
        mismatchPenalty = scoreMod.mismatchScore;
        gapPenalty = scoreMod.indel;

        matrix = new int[seq_a.length()+1][seq_b.length()+1];

        prepareMatrix();
        fillMatrix();

        printMatrix();

        int alignmentScore = matrix[seq_a.length()][seq_b.length()];
        System.out.println();
        System.out.println("The alignment score is "+alignmentScore);
        System.out.println();

        backtrace(seq_a.length(),seq_b.length());
        System.out.println(aligned_seq_a);
        System.out.println(buffer);
        System.out.println(aligned_seq_b);
    }

    private void prepareMatrix() {
        for(int i = 0; i <= seq_a.length(); i++)
            matrix[i][0] = i * gapPenalty;
        for(int j = 0; j <= seq_b.length(); j++)
            matrix[0][j] = j * gapPenalty;
    }

    private void fillMatrix() {
        for (int i = 1; i <= seq_a.length(); i++) {
            for (int j = 1; j <= seq_b.length(); j++) {
                int matchScore = mismatchPenalty;
                if (seq_a.charAt(i-1) == seq_b.charAt(j-1))
                    matchScore = matchReward;

                int match = matrix[i-1][j-1] + matchScore;
                int deletion = matrix[i-1][j] + gapPenalty;
                int insertion = matrix[i][j-1] + gapPenalty;

                matrix[i][j] = Math.max(match,Math.max(deletion,insertion));
            }
        }
    }

    public static void printMatrix() {
        String seq_1 = " " + seq_a;
        String seq_2 = " " + seq_b;
        System.out.printf("%4s", " ");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.printf("%4s", seq_1.charAt(i));
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%4s", seq_2.charAt(i));
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void backtrace(int i, int j) {
        if (i == 0 && j == 0)
            return;
        else if (i == 0) {
            addInsertion(j);
            backtrace(i, j-1);
        } else if (j == 0) {
            addDeletion(i);
            backtrace(i-1, j);
        } else {
            int score = matrix[i][j];
            int matchScore = matrix[i - 1][j - 1];
            int deletionScore = matrix[i - 1][j];
            int insertionScore = matrix[i][j - 1];

            boolean matchBool = false;

            if (score == matchScore + mismatchPenalty || score == matchScore + matchReward) {
                boolean match = seq_a.charAt(i - 1) == seq_b.charAt(j - 1);
                if (match)
                    matchBool = true;
            } else
                matchScore = Integer.MIN_VALUE;

            if (score != deletionScore + gapPenalty) {
                deletionScore = Integer.MIN_VALUE;
            }
            if (score != insertionScore + gapPenalty) {
                insertionScore = Integer.MIN_VALUE;
            }


            int prevScore = Math.max(matchScore, Math.max(deletionScore, insertionScore));
            if (prevScore == matchScore) {
                if (matchBool) {
                    addMatch(i,j);
                    backtrace(i - 1, j - 1);
                } else {
                    addMismatch(i,j);
                    backtrace(i - 1, j - 1);
                }
            } else if (prevScore == deletionScore) {
                addDeletion(i);
                backtrace(i - 1, j);
            } else if (prevScore == insertionScore) {
                addInsertion(j);
                backtrace(i, j - 1);
            }
        }
    }

    private void addMatch(int i, int j){
        aligned_seq_a = seq_a.charAt(i - 1) + " " + aligned_seq_a;
        buffer = "|" + " " + buffer;
        aligned_seq_b = seq_b.charAt(j - 1) + " " + aligned_seq_b;
    }
    private void addMismatch(int i, int j){
        aligned_seq_a = seq_a.charAt(i - 1) + " " + aligned_seq_a;
        buffer = " " + " " + buffer;
        aligned_seq_b = seq_b.charAt(j - 1) + " " + aligned_seq_b;
    }
    private void addDeletion(int i){
        aligned_seq_a = seq_a.charAt(i - 1) + " " + aligned_seq_a;
        buffer = " " + " " + buffer;
        aligned_seq_b = "-" + " " + aligned_seq_b;
    }
    private void addInsertion(int j){
        aligned_seq_a = "-" + " " + aligned_seq_a;
        buffer = " " + " " + buffer;
        aligned_seq_b = seq_b.charAt(j - 1) + " " + aligned_seq_b;
    }

}

class ScoreModifier {
    int matchScore, mismatchScore, indel;

    public ScoreModifier(int pMatchScore, int pMismatchScore, int pIndel) {
        matchScore = pMatchScore;
        mismatchScore = pMismatchScore;
        indel = pIndel;
    }
}