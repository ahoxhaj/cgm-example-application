import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TennisTournamentTest {

    @Test
    public void testFindMatchByIdDFS() {
        // Create the tournament tree
        TreeNode node1 = new TreeNode(1, "John", true);
        TreeNode node2 = new TreeNode(2, "Sarah", false);
        TreeNode node3 = new TreeNode(3, "Michael", true);
        TreeNode node4 = new TreeNode(4, "Emily", false);

        node1.leftChild = node2;
        node1.rightChild = node3;
        node2.leftChild = node4;

        TennisTournament tournament = new TennisTournament(node1);

        // Perform the DFS search
        TreeNode match1 = tournament.findMatchByIdDFS(1);
        Assertions.assertEquals(1, match1.matchId);
        Assertions.assertEquals("John", match1.playerName);
        Assertions.assertTrue(match1.won);

        TreeNode match4 = tournament.findMatchByIdDFS(4);
        Assertions.assertEquals(4, match4.matchId);
        Assertions.assertEquals("Emily", match4.playerName);
        Assertions.assertFalse(match4.won);

        TreeNode match5 = tournament.findMatchByIdDFS(5);
        Assertions.assertNull(match5);
    }

    @Test
    public void testFindPlayersWithWinsBFS() {
        // Create the tournament tree
        TreeNode node1 = new TreeNode(1, "John", true);
        TreeNode node2 = new TreeNode(2, "Sarah", false);
        TreeNode node3 = new TreeNode(3, "Michael", true);
        TreeNode node4 = new TreeNode(4, "Emily", true);

        node1.leftChild = node2;
        node1.rightChild = node3;
        node2.leftChild = node4;

        TennisTournament tournament = new TennisTournament(node1);

        // Perform the BFS search
        List<String> playersWithWins = tournament.findPlayersWithWinsBFS();
        Assertions.assertEquals(3, playersWithWins.size());
        Assertions.assertTrue(playersWithWins.contains("John"));
        Assertions.assertTrue(playersWithWins.contains("Michael"));
        Assertions.assertTrue(playersWithWins.contains("Emily"));
    }
}
