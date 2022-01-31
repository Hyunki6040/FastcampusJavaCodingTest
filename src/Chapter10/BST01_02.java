package Chapter10;

public class BST01 {
    public static void main(String[] args){
        NodeMgmt myTree = new NodeMgmt();
        myTree.insertData(2);
        myTree.insertData(1);
        myTree.insertData(4);
        myTree.insertData(5);
        
        Node result = myTree.search(4);
        System.out.println(result.right.value);
    }
    
    static class Node{
            Node left;
            Node right;
            int value;
            
            public Node(int value){
                this.value = value;
                this.left = null;
                this.right = null;
            }
        }
    
    static class NodeMgmt {
        Node head = null;
        
        
        
        public boolean insertData(int value){
            if(this.head != null){
                Node this_node = this.head;
                while(true){
                    if(value < this_node.value){
                        if(this_node.left != null){
                            this_node = this_node.left;    
                        }else{
                            this_node.left = new Node(value);
                            break;
                        }
                    }else{
                        if(this_node.right != null){
                            this_node = this_node.right;    
                        }else{
                            this_node.right = new Node(value);
                            break;
                        }
                    }
                }
                
            }else{
                this.head = new Node(value);
            }
            
            return true;
        }
        
        public Node search(int value){
            if(this.head == null){
                return null;
            }else{
                Node this_node = this.head;
                while(this_node != null){
                    if(this_node.value == value){
                        return this_node;
                    }else if(value < this_node.value){
                        this_node = this_node.left;
                    }else{
                        this_node = this_node.right;
                    }
                }
                return null;
            }
        }
    }
}

