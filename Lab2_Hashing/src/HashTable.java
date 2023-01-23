public class HashTable {
    int[] H;
    int hsize;
    String hfunction;
    String openAddrType;

    
    
    HashTable(int hsize, String hfunction, String openAddrType) {
        this.hsize = hsize;
        H = new int[hsize];
        this.hfunction = hfunction;
        this.openAddrType=openAddrType;
    }
    

    /*----hash functions -------*/
void fillHashTable(int key) {
        int addr=0;
        if(hfunction=="Division")
        { //Ex1a find the address (addr) of the key using Division hash function
        	addr = key%hsize;    
        }
        else if(hfunction=="Folding")
        {  int C=100;
           //Ex1b find the address (addr) of the key using Folding hash function
        	addr = ((key/C) + key%C)%hsize; 
        }

        if (openAddrType== "Linear")
            linearProbe(key, addr);
        else if (openAddrType == "Quadratic") {
            quadraticProbe(key, addr);
        }
    } 
     
    /*------- Handle collision --------------*/
    void linearProbe(int key, int addr) {
     /* Ex2 when there is a collision, solve this by using open address-linear probling */
    	for(int i = 0;i<hsize;i++) {
    		if (H[(addr+i)%hsize] == 0){
    			H[(addr+i)%hsize] = key;
    			break;
    		}
    	}


    }
    
    void quadraticProbe(int key, int addr) { 

     /* Ex3 when there is a collision, solve this by using open address-quadratic probling */
    	for(int i = 0;i<hsize;i++) {
    		if (H[(addr+(i*i))%hsize] == 0){
    			H[(addr+(i*i))%hsize] = key;
    			break;
    		}
    		
    		
    	}




    }
    
    // Search for a key
    int search(int key) {
   
        int addr=0;
        if(hfunction=="Division")
        { //Ex4a find the address using Division hash function
        	addr = key%hsize;

        }
        else if(hfunction=="Folding")
        {   int C=100;
         //Ex4b find the address using Folding hash function
        	addr = ((key/C) + key%C)%hsize;
        }

        if(openAddrType=="Linear")
        {
        /*Ex5a if the key is not at the computed address, check neighbour addresses using linear probling */
        	for(int i = 0; i< hsize; i++) {
        		addr = ((addr)+i)%hsize;
        		if(H[addr] == key) {
        			break;
        		}
        	}
        	
            
        } 
        else  if(openAddrType=="Quadratic")
        {
            
        /*Ex5b if the key is not at the computed address, check neighbour addresses using quadratic probling */
        	for(int i = 0; i< hsize; i++) {
        		addr = ((addr)+(i*i))%hsize;
        		if(H[addr] == key) {
        			break;
        		}
        	}

        }
        return addr;
    } 
    
}