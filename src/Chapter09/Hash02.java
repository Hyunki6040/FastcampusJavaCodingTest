package Chapter09;

//개방 해싱, open hashing 기법 중 Chaining기법을 사용한 충돌해결
public class Hash02 {
    public static void main(String[] args){
        myHash hash = new myHash(20);
        
        hash.saveData("gim","1111");
        hash.saveData("gi","2222");
        hash.saveData("hyun","3333");
        hash.saveData("hyungi","4444");
        
        System.out.println("gim : " +  hash.getData("gim"));
        System.out.println("gi : " +  hash.getData("gi"));
        System.out.println("hyun : " +  hash.getData("hyun"));
        System.out.println("hyungi : " +  hash.getData("hyungi"));
    }
    
    static class myHash{
        public Slot[] hashTable;
        
        public myHash(Integer size){
            this.hashTable = new Slot[size];
        }
        
        public class Slot{
            String key;
            String value;
            Slot nextSlot;
            
            Slot(String key, String value){
                this.value = value;
                this.key = key;
                this.nextSlot = null;
            }
        }
    
        public int hashFunc(String key){
            return (int) (key.charAt(0)) % this.hashTable.length;
        }
        
        public boolean saveData(String key, String value){
            int address = hashFunc(key);
            
            if(this.hashTable[address] == null){
                this.hashTable[address] = new Slot(key, value);
                return true;
            }else{
                Slot prev_slot = this.hashTable[address];
                Slot this_slot = this.hashTable[address];
                
                while(this_slot != null){
                    if(this_slot.key == key){
                        this_slot.value = value;
                        return true;
                    }else{
                        this_slot = prev_slot.nextSlot;
                    }    
                }
                prev_slot.nextSlot = new Slot(key, value);
                return true;
            }
        }
        
        public String getData(String key){
            int address = hashFunc(key);
            Slot this_slot = this.hashTable[address];
            
            while(this_slot != null){
                if(this_slot.key == key){
                    return this_slot.value;
                }else{
                    this_slot = this_slot.nextSlot;
                }
            }
            return null;
            
        }
    }
    
}

