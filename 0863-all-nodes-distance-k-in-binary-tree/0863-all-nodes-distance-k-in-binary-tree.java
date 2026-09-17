class Solution {

    public void levelOrder(TreeNode root, HashMap<TreeNode, TreeNode> parent) {

        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        parent.put(root, null);

        while(!q.isEmpty()) {

            TreeNode curr = q.poll();

            if(curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }

            if(curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();

        if(root == null || target == null) return res;

        // Step 1: Create parent map
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        levelOrder(root, parent);

        // Step 2: BFS starting from target
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        while(!queue.isEmpty()) {

            int size = queue.size();

            if(k == 0) break;

            for(int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();

                // Parent
                TreeNode par = parent.get(curr);

                if(par != null && !visited.contains(par)) {
                    visited.add(par);
                    queue.offer(par);
                }

                // Left
                if(curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }

                // Right
                if(curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }
            }

            k--;
        }

        // Nodes currently in queue are exactly distance k
        while(!queue.isEmpty()) {
            res.add(queue.poll().val);
        }

        return res;
    }
}