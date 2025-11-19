package sol_251119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42892
 * 길 찾기 게임
 */

public class Sol_42892 {
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }

        Arrays.sort(nodes, (a, b) -> {
            if (a.y != b.y) return b.y - a.y; // y 내림차순
            return a.x - b.x; // y가 같으면 x 오름차순
        });

        Tree tree = new Tree();
        for (Node node : nodes) {
            tree.insert(node);
        }

        List<Integer> preorder =  tree.preorder();
        List<Integer> inorder =  tree.inorder();

        int[][] answer = new int[2][nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = inorder.get(i);
        }

        return answer;
    }

    private class Node {
        public int x, y, value;
        Node left = null;
        Node right = null;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("x:%d  \ty:%d  \tvalue: %d", x, y, value);
        }
    }

    private class Tree{
        Node root;

        public void insert(Node node) {
            if (root == null) root = node; // 첫 노드는 루트
            else insertNode(root, node);
        }

        private void insertNode(Node parent, Node node) {
            if (node.x < parent.x) {    // 왼쪽 서브트리
                if (parent.left == null) parent.left = node;
                else insertNode(parent.left, node);
            } else {                    // 오른쪽 서브트리
                if (parent.right == null) parent.right = node;
                else insertNode(parent.right, node);
            }
        }

        public List<Integer> preorder(){
            List<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;
        }

        private void preorder(Node node, List<Integer> result){
            if(node == null) return;
            result.add(node.value);
            preorder(node.left, result);
            preorder(node.right, result);
        }

        public List<Integer> inorder(){
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            return result;
        }

        private void inorder(Node node, List<Integer> result){
            if (node == null) return;
            inorder(node.left, result);
            inorder(node.right, result);
            result.add(node.value);
        }
    }
}
