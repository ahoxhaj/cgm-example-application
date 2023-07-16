import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

record TennisTournament(TreeNode root) {

    // Function for the depth-first search
    public TreeNode findMatchByIdDFS(int matchId) {
        return findMatchByIdDFS(root, matchId);
    }

    private TreeNode findMatchByIdDFS(TreeNode node, int matchId) {
        if (node == null) {
            return null;
        }

        if (node.matchId == matchId) {
            return node;
        }

        TreeNode leftResult = findMatchByIdDFS(node.leftChild, matchId);
        if (leftResult != null) {
            return leftResult;
        }

        return findMatchByIdDFS(node.rightChild, matchId);
    }

    // Function for the breadth-first search
    public List<String> findPlayersWithWinsBFS() {
        List<String> playersWithWins = new ArrayList<>();
        if (root == null) {
            return playersWithWins;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.won) {
                playersWithWins.add(currentNode.playerName);
            }

            if (currentNode.leftChild != null) {
                queue.add(currentNode.leftChild);
            }

            if (currentNode.rightChild != null) {
                queue.add(currentNode.rightChild);
            }
        }

        return playersWithWins;
    }
}