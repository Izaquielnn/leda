package adt.bst;


public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.getRoot()) - 1;
	}
	
	private int height(BSTNode<T> bstnode){
		if (bstnode.isEmpty()){
			return 0;
		}
		return 1 +  Math.max(height((BSTNode<T>) bstnode.getLeft()), height((BSTNode<T>) bstnode.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		if (element == null) {
			return new BSTNode<T>();
		}
		return search(this.getRoot(), element);
	}

	private BSTNode<T> search(BSTNode<T> bstnode, T element) {
		if (bstnode.isEmpty() || bstnode.getData().equals(element)) {
			return bstnode;
		}
		
		if ( bstnode.getData().compareTo(element) > 0) {
			return search((BSTNode<T>) bstnode.getLeft(), element);
		} else {
			return search((BSTNode<T>) bstnode.getRight(), element);
		}

	}
		

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(this.root, element);
		}
	}

	
	private void insert(BSTNode<T> bstnode, T element) {
		if (bstnode.isEmpty()) {
			bstnode.setData(element);
			bstnode.setLeft(new BSTNode.Builder<T>().parent(bstnode).build());
			bstnode.setRight(new BSTNode.Builder<T>().parent(bstnode).build());
		} else {
			int comp = bstnode.getData().compareTo(element);
			if (comp > 0) {
				insert((BSTNode<T>) bstnode.getLeft(), element);
			}
			if (comp < 0) {
				insert((BSTNode<T>) bstnode.getRight(), element);
			}
		}
		
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.getRoot());
	}

	private BSTNode<T> maximum(BSTNode<T> bstnode) {
		if (bstnode.isEmpty()) {
			return null;
		} else if (bstnode.getRight().isEmpty()) {
			return bstnode;
		} else {
			return maximum((BSTNode<T>) bstnode.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.getRoot());
	}

	private BSTNode<T> minimum(BSTNode<T> bstnode) {
		if (bstnode.isEmpty()) {
			return null;
		} else if (bstnode.getLeft().isEmpty()) {
			return bstnode;
		} else {
			return minimum((BSTNode<T>) bstnode.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> bstnode = this.search(element);
		if (isEmpty() || bstnode == null || bstnode.isEmpty()) {
			return null;
		}
		if (!bstnode.getRight().isEmpty()) {
			return minimum((BSTNode<T>) bstnode.getRight());
		}
		return sucessor(bstnode, element);
	}


	private BSTNode<T> sucessor(BSTNode<T> bstnode, T element) {
		if (bstnode.getParent() ==null) {
			return null;
		}
		if (bstnode.getParent().getData().compareTo(element) < 0 ) {
			return sucessor((BSTNode<T>) bstnode.getParent(), element);
		} else {
			return (BSTNode<T>) bstnode.getParent();
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> bstnode = this.search(element);
		if (isEmpty() || bstnode == null || bstnode.isEmpty()) {
			return null;
		}
		if (!bstnode.getLeft().isEmpty()) {
			return maximum((BSTNode<T>) bstnode.getLeft());
		}
		return predecessor(bstnode, element);
	}

	private BSTNode<T> predecessor(BSTNode<T> bstnode, T element) {
		if (bstnode.getParent() ==null) {
			return null;
		}
		if (bstnode.getParent().getData().compareTo(element) > 0 ) {
			return predecessor((BSTNode<T>) bstnode.getParent(), element);
		} else {
			return (BSTNode<T>) bstnode.getParent();
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> bstnode = search(element);
		if (!bstnode.isEmpty()) {
			remove(bstnode);
		}

	}

	private void remove(BSTNode<T> bstnode) {
		if (bstnode.isLeaf()) {
			bstnode.setData(null);
			bstnode.setLeft(null);
			bstnode.setRight(null);
		} else if (bstnode.getRight().isEmpty()) {
			bstnode.setData(bstnode.getLeft().getData());
			bstnode.setRight(bstnode.getLeft().getRight());
			bstnode.setLeft(bstnode.getLeft().getLeft());
			bstnode.getRight().setParent(bstnode);
			bstnode.getLeft().setParent(bstnode);
		} else if (bstnode.getLeft().isEmpty()) {
			bstnode.setData(bstnode.getRight().getData());
			bstnode.setLeft(bstnode.getRight().getLeft());
			bstnode.setRight(bstnode.getRight().getRight());
			bstnode.getRight().setParent(bstnode);
			bstnode.getLeft().setParent(bstnode);
		} else {
			T value = bstnode.getData();
			BSTNode<T> sucessor = sucessor(value);
			bstnode.setData(sucessor.getData());
			sucessor.setData(value);
			remove((BSTNode<T>) sucessor);
		}
		
	}

	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		preOrder(this.getRoot(), array, 0);
		return array;
	}

	private int preOrder(BSTNode<T> bstnode, T[] array, int i) {
		if (!bstnode.isEmpty()) {
			array[i] = bstnode.getData();
			i = preOrder((BSTNode<T>) bstnode.getLeft(), array, ++i);
			i = preOrder((BSTNode<T>) bstnode.getRight(), array, i);
		}
		return i;
	}

	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[this.size()];
		order(this.getRoot(), array, 0);
		return array;
	}

	private int order(BSTNode<T> bstnode, T[] array, int i) {
		if (!bstnode.isEmpty()) {
			i = order((BSTNode<T>) bstnode.getLeft(), array, i);
			array[i++] = bstnode.getData();
			i = order((BSTNode<T>) bstnode.getRight(), array, i);
		}
		return i;
		
	}

	@Override
	public T[] postOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		postOrder(this.getRoot(), array, 0);
		return array;
	}

	private int postOrder(BSTNode<T> bstnode, T[] array, int i) {
		if (!bstnode.isEmpty()) {
			i = order((BSTNode<T>) bstnode.getLeft(), array, i);
			i = order((BSTNode<T>) bstnode.getRight(), array, i);
			array[i++] = bstnode.getData();
		}
		return i;
		
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
