import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example of the Tournament Tree
        TreeNode match1 = new TreeNode(1, "John", true);
        TreeNode match2 = new TreeNode(2, "Sarah", false);
        TreeNode match3 = new TreeNode(3, "Michael", true);
        TreeNode match4 = new TreeNode(4, "Emily", false);
        TreeNode match5 = new TreeNode(5, "David", true);
        TreeNode match6 = new TreeNode(6, "Olivia", false);
        TreeNode match7 = new TreeNode(7, "James", true);
        TreeNode match8 = new TreeNode(8, "Sophia", false);

        TreeNode quaterfinal1 = new TreeNode(9, null, false);
        quaterfinal1.leftChild = match1;
        quaterfinal1.rightChild = match2;

        TreeNode quaterfinal2 = new TreeNode(10, null, false);
        quaterfinal2.leftChild = match3;
        quaterfinal2.rightChild = match4;

        TreeNode quaterfinal3 = new TreeNode(11, null, false);
        quaterfinal3.leftChild = match5;
        quaterfinal3.rightChild = match6;

        TreeNode quaterfinal4 = new TreeNode(12, null, false);
        quaterfinal4.leftChild = match7;
        quaterfinal4.rightChild = match8;

        TreeNode semifinal1 = new TreeNode(13, null, false);
        semifinal1.leftChild = quaterfinal1;
        semifinal1.rightChild = quaterfinal2;

        TreeNode semifinal2 = new TreeNode(14, null, false);
        semifinal2.leftChild = quaterfinal3;
        semifinal2.rightChild = quaterfinal4;

        TreeNode finalRoot = new TreeNode(15, null, false);
        finalRoot.leftChild = semifinal1;
        finalRoot.rightChild = semifinal2;

        TennisTournament tournament = new TennisTournament(finalRoot);

        // depth search
        TreeNode match = tournament.findMatchByIdDFS(5);
        if (match != null) {
            System.out.println("Match found: ID = " + match.matchId + ", Player: " + match.playerName);
        } else {
            System.out.println("Match not found.");
        }

        // breadth search
        List<String> playersWithWins = tournament.findPlayersWithWinsBFS();
        System.out.println("Player with at least one win:");
        for (String playerName : playersWithWins) {
            System.out.println(playerName);
        }
    }
}
