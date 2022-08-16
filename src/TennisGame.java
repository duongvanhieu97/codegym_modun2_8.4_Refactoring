public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int play1Score, int play2Score) {
        String stringCore = "";
        int adventagePoint = 4;

        int tempScore;
        if (play1Score == play2Score) {
            stringCore = showSameCore(play1Score);
        } else {
            if (play1Score >= adventagePoint || play2Score >= adventagePoint) {
                stringCore = showScoreWin(player1Name, player2Name, play1Score, play2Score);
            } else {
                stringCore = showScoreAfterWin(play1Score, play2Score, stringCore);
            }
        }
        return stringCore;
    }

    private static String showScoreAfterWin(int play1Score, int play2Score, String stringCore) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = play1Score;
            else {
                stringCore += "-";
                tempScore = play2Score;
            }
            stringCore = showScore(stringCore, tempScore);
        }
        return stringCore;
    }

    private static String showScore(String stringCore, int tempScore) {
        switch (tempScore) {
            case 0 -> stringCore += "Love";
            case 1 -> stringCore += "Fifteen";
            case 2 -> stringCore += "Thirty";
            case 3 -> stringCore += "Forty";
        }
        return stringCore;
    }

    private static String showScoreWin(String player1Name, String player2Name, int play1Score, int play2Score) {
        String stringCore;
        int minusResult = play1Score - play2Score;
        if (minusResult == 1) stringCore = "Advantage" + player1Name;
        else if (minusResult == -1) stringCore = "Advantage" + player2Name;
        else if (minusResult >= 2) stringCore = "Win for " + player1Name;
        else stringCore = "Win for" + player2Name;
        return stringCore;
    }

    private static String showSameCore(int play1Score) {
        String score;
        score = showSameScore(play1Score);
        return score;
    }

    private static String showSameScore(int play1Score
    ) {
        String score = switch (play1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        };
        return score;
    }
}
