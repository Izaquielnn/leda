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

	@SuppressWarnings("unchecked")
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
			return maximum((BSTNode<T>) bstnode.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> bstnode = this.search(element);
		if (bstnode == null || bstnode.isEmpty()) return null;
		BSTNode<T> aux = minimum((BSTNode<T>) bstnode.getRight());
		if (aux != null) return aux;
		else {
			BSTNode<T> parent = (BSTNode<T>) bstnode.getParent();
			while (parent != null && parent.getData().compareTo(bstnode.getData()) < 0){
				parent = (BSTNode<T>) parent.getParent();
			}
			return parent;
		}
		
	}


	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> bstnode = this.search(element);
		if (bstnode == null || bstnode.isEmpty()) return null;
		BSTNode<T> aux = maximum((BSTNode<T>) bstnode.getRight());
		if (aux != null) return aux;
		else {
			BSTNode<T> parent = (BSTNode<T>) bstnode.getParent();
			while (parent != null && parent.getData().compareTo(bstnode.getData()) > 0){
				parent = (BSTNode<T>) parent.getParent();
			}
			return parent;
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
