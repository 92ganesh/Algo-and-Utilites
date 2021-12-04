class Trie{
    private class Node{
        boolean isWord = false;
        Node[] children = new Node[26];
    }

    private Node root;

    Trie(){
        root = new Node();
    }

    void add(String word){
        Node temp = root;
        for(int i=0;i<word.length();i++){
            if(temp.children[word.charAt(i)-'a']==null){
                temp.children[word.charAt(i)-'a'] = new Node();
            }
            temp = temp.children[word.charAt(i)-'a'];

            if(i==word.length()-1){
                temp.isWord=true;
            }
        }
    }

    boolean search(String word){
        boolean hasWord = false;
        Node temp = root;
        for(int i=0;i<word.length();i++){
            if(temp.children[word.charAt(i)-'a']==null){
                hasWord = false; break;
            }
            temp = temp.children[word.charAt(i)-'a'];

            if(i==word.length()-1){
                if(temp.isWord){
                    hasWord = true;
                }else{
                    hasWord = false;
                }
            }
        }
        return hasWord;
    }
}