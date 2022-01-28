package Chapter09;

public class Hash01 {
    public static void main(String[] args){
        String key = "hyungi";
        
        myHash hash = new myHash(20);
        hash.saveData("hyungi", "01000000000");
        hash.saveData("hyun", "01011111111");
        
        System.out.println("hyungi : " + hash.getData("hyungi"));
        System.out.println("hyun : " + hash.getData("hyun"));
    }
    
    public class myHash{
        public Slot[] hashTable;
        
        public myHash(Integer size){
            hashTable = new Slot[size];
        }
        
        public class Slot{
            String value;
            
            Slot(String value){
                this.value = value;
            }
        }
        
        public int hashFunc(String input){
            int address = ((int) key.charAt(0)) % 20;
            return address;
        }
        
        public boolean saveData(String key, String value){
            int address = hashFunc(key);
            if(this.hashTable[address] != null){
                this.hashTable[address].value = value;
            }else{
                this.hashTable[address] = new Slot(value);
            }
            
            return true;
        }
        
        public String getData(String key){
            int address = hashFunc(key);
            return hashTable[address].value;
        }
    }
}
