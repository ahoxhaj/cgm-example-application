class TreeNode {
    final int matchId;
    final String playerName;
    final boolean won;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int matchId, String playerName, boolean won) {
        this.matchId = matchId;
        this.playerName = playerName;
        this.won = won;
        leftChild = null;
        rightChild = null;
    }
}