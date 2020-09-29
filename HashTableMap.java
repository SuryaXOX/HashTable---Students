
// --== CS400 File Header Information ==--
// Name: Surya Santhan Thenarasu
// Email: thenarasu@wisc.edu
// Team: BG
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: N/A

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

    private LinkedList<ListNode>[] Hash_Table;
    private int capacity;
    private int size;

    class ListNode {
      private KeyType key;
      private ValueType value;


      public ListNode(KeyType key, ValueType value) {
          this.key = key;
          this.value = value;

      }

      public KeyType getKey() {
          return this.key;
      }

      public ValueType getValue() {
          return this.value;
      }


      public void setValue(ValueType value) {
          this.value = value;
      }

      public void setKey(KeyType key) {
          this.key = key;
      }

  }



    @SuppressWarnings("unchecked")
    public HashTableMap(int capacity) {
      
      this.capacity = capacity;
        Hash_Table = new LinkedList[this.capacity];
    }

    @SuppressWarnings("unchecked")
    public HashTableMap() {
       
      this.capacity = 10;
        Hash_Table = new LinkedList[this.capacity];
    }


    @Override
    public ValueType get(KeyType key) throws NoSuchElementException {
        
      ValueType Val = null;
        if (!containsKey(key)) {
           
          throw new NoSuchElementException();
        }
        for (int i = 0; i < capacity; ++i) {
          
          if (this.Hash_Table[i] != null) {
                for (int j = 0; j < Hash_Table[i].size(); ++j) {
                   
                  ListNode node = (ListNode) Hash_Table[i].get(j);
                   
                  if (node.getKey() == key) {
                       
                      if (node.getValue() != null) {
                            Val = node.getValue();
                        }
                    }
                }
            }
        }
        return Val;
    }

    
    @Override
    public boolean put(KeyType key, ValueType value) {
      this.size++;
      double loadFraction = (double) 1.0 * this.size / this.capacity;
        if (loadFraction >= 0.8) {
            rehash();
        }
        ListNode Node = new ListNode(key, value);
        int Hash_key = 0;
        for (int i = 0; i < capacity; ++i) {
            if (Hash_Table[i] != null) {
                for (int j = 0; j < Hash_Table[i].size(); ++j) {
                    if (key.equals(Hash_Table[i].get(j).getKey())) {
                        return false;
                    }
                }
            }
        }
        Hash_key = Math.abs(key.hashCode() % this.capacity);
       
        if (Hash_Table[Hash_key] == null) {
            
          Hash_Table[Hash_key] = new LinkedList<ListNode>();
          
          Hash_Table[Hash_key].add(Node);

        } else {
            Hash_Table[Hash_key].add(Node);
        }
       
       
        return true;
    }

   

    @Override
    public boolean containsKey(KeyType key) {
        boolean flag = false;
       
        for (int i = 0; i < capacity; ++i) {
            if (Hash_Table[i] != null) {
              
              for (int j = 0; j < Hash_Table[i].size(); ++j) {
                   
                ListNode node = (ListNode) Hash_Table[i].get(j);
                    if (node.getKey() == key) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public void clear() {
        for (int x = 0; x < capacity; x++) {
            
          if (Hash_Table[x] != null) {
                
            Hash_Table[x] = null;
            }
        }
size=0;
    }
    
    @Override
    public ValueType remove(KeyType key) {
        if (!containsKey(key)) {
            return null;
        }
        ValueType value = null;
        for (int x = 0; x < capacity; ++x) {
            if (Hash_Table[x] != null) {
                for (int y = 0; y < Hash_Table[x].size(); ++y) {
                    ListNode node = (ListNode) Hash_Table[x].get(y);
                    if (node.getKey() == key) {
                        if (node.getValue() != null) {
                            value = node.getValue();
                            node.setValue(null);
                            node.setKey(null);
                        }
                    }
                }
            }
        }
        return value;
    }

   

    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<ListNode>[] Old_Table = this.Hash_Table;
        LinkedList<ListNode>[] Doubled_Hashtable = new LinkedList[this.capacity * 2];
       
        this.capacity *= 2;
       
        this.Hash_Table = Doubled_Hashtable;
       
        this.size = 0;
       
        for (int x = 0; x < Old_Table.length; ++x) {
            if (Old_Table[x] != null) {
                for (int y = 0; y < Old_Table[x].size(); ++y) {
                    if (Old_Table[x].get(y) != null) {
                        KeyType key = Old_Table[x].get(y).getKey();
                        ValueType value = Old_Table[x].get(y).getValue();
                        put(key, value);
                    }
                }
            }
        }
    }

}   