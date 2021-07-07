package test.com.example.testDemo.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class TrieStruct {
    @Autowired
    private TrieNode root;
    
    // public TrieStruct(){
    //     super();
    //     root = new TrieNode();
    // }

    public void insert(String word) {
        TrieNode current = this.root;
        TrieNode temp;
        for (char l: word.toCharArray()) {
           // System.out.println(current.toString());
            temp = current.getChildren().get(l);
            if(temp == null){
                current.getChildren().put(l, new TrieNode());

            }
            current = current.getChildren().get(l);
        }
        current.setWord(true);
        current.setContent(word);
    }

    public Set<String> find(String word) {
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return null;
            }
            current = node;
        }
        Set<String> words = new HashSet<String>();
        if(current.getIsWord() == true)
        words.add(current.getContent());
        // System.out.println("Curr "+current.toString());
        dfs(current,words);
        return words;
    }

    void dfs(TrieNode current, Set<String> words){
        current.getChildren().forEach((a,trieNode)->{
            if(trieNode.getIsWord()){
               // System.out.println("In "+trieNode.getContent());
                words.add(trieNode.getContent());
            }
            dfs(trieNode,words);
        });

    }
    
    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }
    public static void main(String[] args){
        Set<String> medicines = null;
        TrieStruct root1 = new TrieStruct();
        List<String> ex = new ArrayList<String>();
        ex.add("ram");
        ex.add("ramx");
        ex.add("ramxyz");
        ex.add("ramx");
        ex.add("ramxyz");
        ex.add("ramt");
        ex.add("ramyc");
        for(int i=0;i<ex.size();i++){
           System.out.println(root1.toString());
            root1.insert(ex.get(i));
        }
        medicines = root1.find("ram");
        medicines.forEach(s-> System.out.println(s));
    }

    @Override
    public String toString() {
        return "TrieStruct [root=" + root + "]";
    }
}
