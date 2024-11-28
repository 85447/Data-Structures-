import java.util.*;
public class hashmapCode{
    static class HashMap<K, V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked");
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i <4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key){

        }
        public void put(K key, V value){
            int bi = hashFunction(key);
            int di=searchInLL(key,bi);
            if(di== -1){
                buckets[bi].add(new Node(key,value));
                n++;
            }else{
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambda =(double)n/N;
            if(lambda > 2.0){
                
            }
        }
        public boolean containsKey(K key){
            return false;
        }
        public V remove(K key){
            return null;
        }
        public V get(K key){

        }
        public ArrayList<K> keySet(){

        }
        public boolean
    }
}