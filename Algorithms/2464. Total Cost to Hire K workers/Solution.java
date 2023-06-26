class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        if (costs == null || costs.length < k || candidates <= 0) {
            return 0;
        }
        
        long result = 0;
        int leftIndex = candidates - 1, rightIndex = Math.max(leftIndex + 1, costs.length - candidates);
        Queue<int[]> leftItems = new PriorityQueue<int[]>((x1, x2) -> {
            if (x1[1] == x2[1]) {
                return x1[0] - x2[0];
            }
            return x1[1] - x2[1];
        });
        for (int i = 0; i <= leftIndex; i++) {
            leftItems.offer(new int[]{i, costs[i]});
        }
        Queue<int[]> rightItems = new PriorityQueue<int[]>((x1, x2) -> {
            if (x1[1] == x2[1]) {
                return x1[0] - x2[0];
            }
            return x1[1] - x2[1];
        });
        for (int i = costs.length - 1; i >= rightIndex; i--) {
            rightItems.offer(new int[]{i, costs[i]});
        }
        
        while (k-- > 0) {
            if (leftItems.size() == 0) {
                int[] rightItem = rightItems.poll();
                result += rightItem[1];
                if (leftIndex + 1 < rightIndex) {
                    leftIndex++;
                    leftItems.offer(new int[]{leftIndex, costs[leftIndex]});
                }
            } else if (rightItems.size() == 0) {
                int[] leftItem = leftItems.poll();
                result += leftItem[1];
                if (rightIndex - 1 > leftIndex) {
                    rightIndex--;
                    rightItems.offer(new int[]{rightIndex, costs[rightIndex]});
                }
            } else {
                int[] leftItem = leftItems.peek();
                int[] rightItem = rightItems.peek();
                if (leftItem[1] <= rightItem[1]) {
                    result += leftItem[1];
                    leftItems.poll();
                    if (leftIndex + 1 < rightIndex) {
                        leftIndex++;
                        leftItems.offer(new int[]{leftIndex, costs[leftIndex]});
                    }
                } else {
                    result += rightItem[1];
                    rightItems.poll();
                    if (rightIndex - 1 > leftIndex) {
                        rightIndex--;
                        rightItems.offer(new int[]{rightIndex, costs[rightIndex]});
                    }
                }
            }
        }
        return result;
    }
}
