

import java.util.ArrayList;
import java.util.Comparator;

import rbtree.RBTree;
import rbtree.RBTreeVisitor;

/**
 * visitor class of pathLenghs
 * @author shiyu
 * @version 2013-11-10
 * @param <T> the type of data stored in the RBTree
 */
public class PathLengths<T> implements RBTreeVisitor<T, ArrayList<Integer>> {
    /**the accumulator for level of node */
    int acc = 0;
    /** the arrayList used for couting pathLeagths*/
    ArrayList<Integer> alist = new ArrayList<Integer>();
  /**
   * The method for the empty tree
   * @param comp the Comparator for the whole tree
   * @return the PathLength for leaf
   */
    public ArrayList<Integer> visitLeaf(Comparator<T> comp) {
        alist.add(acc);
        return alist;

    }

  /**
   * The method for the node of the tree
   * @param comp the Comparator for the whole tree
   * @param color the color of the node, which should be "RED"
   *        or "BLACK"
   * @param data the label/value for the node
   * @param left the left subtree of the node
   * @param right the right subtree of the node
   * @return some value of the type R
   */
    public ArrayList<Integer> visitNode(Comparator<T> comp, String color,
            T data, RBTree<T> left, RBTree<T> right) {
      
        acc++;
        int step = acc;
        left.accept(this);
        acc = step;
        right.accept(this);
        return alist;
    }
}
