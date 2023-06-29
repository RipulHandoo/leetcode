import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] gridArray = new char[m][n];
        int keyCount = 0;
        int[] start = new int[2];
        Set<Character> locks = new HashSet<>();

        // Convert grid to 2D char array and find the starting position and key count
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gridArray[i][j] = grid[i].charAt(j);
                if (gridArray[i][j] == '@') {
                    start[0] = i;
                    start[1] = j;
                } else if (Character.isLowerCase(gridArray[i][j])) {
                    keyCount++;
                } else if (Character.isUpperCase(gridArray[i][j])) {
                    locks.add(gridArray[i][j]);
                }
            }
        }

        int allKeysMask = (1 << keyCount) - 1;
        int[][][] visited = new int[m][n][1 << keyCount];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]][0] = 1;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                int keysMask = curr[2];

                if (keysMask == allKeysMask) {
                    return steps;
                }

                for (int[] dir : DIRECTIONS) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    int newKeysMask = keysMask;

                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && gridArray[newRow][newCol] != '#') {
                        char cell = gridArray[newRow][newCol];

                        if (Character.isLowerCase(cell)) {
                            newKeysMask |= (1 << (cell - 'a'));
                        } else if (Character.isUpperCase(cell) && (keysMask & (1 << (cell - 'A'))) == 0) {
                            continue; // Skip the lock if the corresponding key has not been collected
                        }

                        if (visited[newRow][newCol][newKeysMask] == 0) {
                            visited[newRow][newCol][newKeysMask] = 1;
                            queue.offer(new int[]{newRow, newCol, newKeysMask});
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
