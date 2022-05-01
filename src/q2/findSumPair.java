package q2;

import java.util.HashSet;
import java.util.Scanner;

public class findSumPair {
    static class Node {
        int nodeData;
        Node leftNode, rightNode;
    };

    //
    static Node NewNode(int nodeData) {
        Node temp = new Node();
        temp.nodeData = nodeData;
        temp.leftNode = null;
        temp.rightNode = null;

        return temp;
    }

    // a recurring function to insert the node
    public Node insert(Node root, int key) {
        if (root == null)
            return NewNode(key);
        if (key < root.nodeData)
            root.leftNode = insert(root.leftNode, key);
        else
            root.rightNode = insert(root.rightNode, key);
        return root;
    }

    // a recurring function to find the pairs
    public boolean findpairUtil(Node root, int sum, HashSet<Integer> set) {
        if (root == null)
            return false;

        if (findpairUtil(root.leftNode, sum, set))
            return true;

        if (set.contains(sum - root.nodeData)) {
            System.out.println("Pair is found (" + (sum - root.nodeData) + ", " + root.nodeData + ")");
            return true;
            //	set.add(root.nodeData);
        } else
            set.add(root.nodeData);

        return findpairUtil(root.rightNode, sum, set);
    }


    public void findPairWithGivenSum(Node root, int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!findpairUtil(root, sum, set))
            System.out.print("Pairs do not exit" + "\n");
        //	findpairUtil(root,sum,set);
    }

    // Driver code
    public static void main(String[] args) {
        Node root = null;
        Scanner sc=new Scanner(System.in);
        findSumPair findSP = new findSumPair();

        System.out.println("Enter the number of nodes");
        int nodes=sc.nextInt();
        for(int i=0;i<nodes;i++){
            System.out.println("Enter value to insert:");
            int value = sc.nextInt();
            root = findSP.insert(root, value);
        }
        System.out.println();
        int sum =0;
        System.out.println("Enter the sum to find the pairs");
        sum=sc.nextInt();
        findSP.findPairWithGivenSum(root, sum);
    }
}
