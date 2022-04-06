package dataStructure;

public class Tree<T extends Comparable<T>> {
    Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Tree(T data) {
        root = null;
        this.root = new Node<>(data);
    }

    public Node<T> find(T data) {
        Node<T> current = root;
        try {
            int flag;
            while ((flag = current.getData().compareTo(data)) != 0) {
                if (flag > 0) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
            }
        } catch (NullPointerException e) {
            current = null;
        }
        return current;
    }

    public void deleteKey(T data) {
        root = deleteRec(root, data);
    }

    Node<T> deleteRec(Node<T> root, T data) {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (root.getData().compareTo(data) > 0)
            root.setLeftChild(deleteRec(root.getLeftChild(), data));
        else if (root.getData().compareTo(data) < 0)
            root.setRightChild(deleteRec(root.getRightChild(), data));

        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.getLeftChild() == null)
                return root.getRightChild();
            else if (root.getRightChild() == null)
                return root.getLeftChild();

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.setData(minValue(root.getRightChild()));

            // Delete the inorder successor
            root.setRightChild(deleteRec(root.getRightChild(), root.getData()));
        }

        return root;
    }

    T minValue(Node<T> root) {
        T minv = root.getData();
        while (root.getLeftChild() != null) {
            minv = root.getLeftChild().getData();
            root = root.getLeftChild();
        }
        return minv;
    }

    public void insert(T data) {
        Node<T> current, parent;
        Node<T> newNode = new Node<T>(data);

        if (root == null) {
            root = newNode;
        } else {
            boolean status = true;
            current = root;

            while (status) {
                parent = current;

                if (data.compareTo(current.getData()) < 0) {
                    current = current.getLeftChild();

                    if (current == null) {
                        parent.setLeftChild(newNode);
                        status = false;
                    }
                } else {
                    current = current.getRightChild();

                    if (current == null) {
                        parent.setRightChild(newNode);
                        status = false;
                    }
                }
            }
        }
    }

    public void traverse(int type) {
        switch (type) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
            default:
                System.out.print("\nPreorder(1) - Inorder(2) - Postorder(3)");
        }
        System.out.println();
    }

    private void preOrder(Node<T> auxRoot) {
        if (auxRoot != null) {
            System.out.print(auxRoot.getData() + "-");
            preOrder(auxRoot.getLeftChild());
            preOrder(auxRoot.getRightChild());
        }
    }

    private void inOrder(Node<T> auxRoot) {
        if (auxRoot != null) {
            inOrder(auxRoot.getLeftChild());
            System.out.print(auxRoot.getData() + "-");
            inOrder(auxRoot.getRightChild());
        }
    }

    private void postOrder(Node<T> auxRoot) {
        if (auxRoot != null) {
            postOrder(auxRoot.getLeftChild());
            postOrder(auxRoot.getRightChild());
            System.out.print(auxRoot.getData() + "-");
        }
    }

}