package algorithm_and_data_structure_basic.session16;

import dependentClass.TreeNode;

/*deep copy a tree*/
public class Q01_2DeepCopyTree {
	public static TreeNode deepCopyTree(TreeNode root) {
		// corner&base case
		if (root == null) {
			return null;
		}

		// general case
		TreeNode newRoot = new TreeNode(root.val);
		newRoot.left = deepCopyTree(root.left);
		newRoot.right = deepCopyTree(root.right);
		return newRoot;
	}
}