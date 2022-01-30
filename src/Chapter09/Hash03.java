package Chapter09;

//Linear Probing 기법
public class Hash03 {
    public static void main(String[] args){
        MyHash hash = new MyHash(20);
        
        hash.saveData("gim","1111");
        hash.saveData("gi","2222");
        hash.saveData("hyun","3333");
        hash.saveData("hyungi","4444");
        
        System.out.println("gim : " +  hash.getData("gim"));
        System.out.println("gi : " +  hash.getData("gi"));
        System.out.println("hyun : " +  hash.getData("hyun"));
        System.out.println("hyungi : " +  hash.getData("hyungi"));
    }
    
    static class MyHash{
        public Slot[] hashTable;
        
        public MyHash(Integer size){
            this.hashTable = new Slot[size];
        }
        
        public class Slot{
            String key;
            String value;
            
            Slot(String key, String value){
                this.key = key;
                this.value = value;
            }
        }
        
        public Integer hashFunc(String key){
            return (int)key.charAt(0) % this.hashTable.length;
        }
        
        public boolean saveData(String key, String value){
            Integer address = hashFunc(key);
            if(this.hashTable[address] != null){
                Slot this_slot = this.hashTable[address];
                if(this_slot.key == key){
                    this_slot.value = value;
                }else{
                    address++;
                    while(this.hashTable[address] != null){
                        this_slot = this.hashTable[address];
                        if(this_slot.key == key){
                            this_slot.value = value;
                            return true;
                        }else{
                            address++;
                            if(address >= this.hashTable.length){
                                return false;
                            }
                        }
                    }
                    this.hashTable[address] = new Slot(key, value);   
                }
            }else{
                this.hashTable[address] = new Slot(key, value);
            }
            return true;
        }
        
        public String getData(String key){
            Integer address = hashFunc(key);
            if(this.hashTable[address] != null){
                Slot this_slot = this.hashTable[address];
                if(this_slot.key == key){
                    return this_slot.value;
                }else{
                    address++;
                    while(this.hashTable[address] != null){
                        this_slot = this.hashTable[address];
                        if(this_slot.key == key){
                            return this_slot.value;
                        }else{
                            address++;
                            if(address >= this.hashTable.length){
                                return null;
                            }
                        }
                    }
                    return null;
                }
            }else{
                return null;
            }
        }
    }
}
