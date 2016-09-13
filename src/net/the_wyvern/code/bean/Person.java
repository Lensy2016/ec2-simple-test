package net.the_wyvern.code.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable
{
    public static final long serialVersionUID = 1L;
    
    private String firstName;  
    private String lastName;
    private Integer age;  
    private Integer shoeSize;
    private boolean sessionBased = false;
    private boolean generateLoad;
    


	private ArrayList<String> hosts;
        
    public Person()
    {
        this.hosts = new ArrayList<String>(); 
    }
    /*
        this.firstName="unset";
        this.lastName="unset";
        this.age = 0;
        this.shoeSize = 0;       
    }*/
    
    public String getFirstName() {  
        return firstName;  
    }  
      
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    }  
      
    public Integer getAge() {  
        return age;  
    }  
      
    public void setAge(Integer age) {  
        this.age = age;  
    }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getShoeSize() {
		return shoeSize;
	}

	public void setShoeSize(Integer shoeSize) {
		this.shoeSize = shoeSize;
	}  
	
    public boolean isGenerateLoad() {
		return generateLoad;
	}

	public void setGenerateLoad(boolean generateLoad) {
		this.generateLoad = generateLoad;
	}	
	public String toString() {
		return "[" + firstName + " " + lastName + " / " + age + " / " + shoeSize + "]";
	}
	
    
    /////////////////////////
    public String getHosts() {
    	StringBuffer buff = new StringBuffer();
    	buff.append("[ ");
    	for (int i = 0 ; i < hosts.size(); i++ ) {
    		
    		buff.append(hosts.get(i));
    		if ( (i+1) != hosts.size()) {
    			buff.append(", ");
    		}
    		
    	}
    	buff.append("]");
    	return buff.toString();
    }
    
    public void addHostToList(String s) {
    	hosts.add(s);
    }
    /////////////////////////

    public boolean isSessionBased() {
		return sessionBased;
	}

	public void setSessionBased(boolean b) {
		this.sessionBased= b;
	}	
}
