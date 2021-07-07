package test.com.example.testDemo.Trie;

import java.util.HashMap;

public class TrieNode {

    private HashMap<Character, TrieNode> children;
    private String content;
    private boolean isWord;

    public TrieNode(){
        super();
        this.children = new HashMap<>();
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }
    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean getIsWord() {
        return isWord;
    }
    public void setWord(boolean isWord) {
        this.isWord = isWord;
    }

    @Override
    public String toString() {
        return "TrieNode [children=" + children + ", content=" + content + ", isWord=" + isWord + "]";
    }
    
}
