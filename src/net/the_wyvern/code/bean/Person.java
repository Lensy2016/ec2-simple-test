package net.the_wyvern.code.bean;

import java.io.Serializable;

public class Person implements Serializable
{
    public static final long serialVersionUID = 1L;
    
    private String firstName;  
    private String lastName;
    private Integer age;  
    private Integer shoeSize;
    private String processedBy;
/*    
    public Person()
    {
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
	
	public String toString() {
		return "[" + firstName + " " + lastName + " / " + age + " / " + shoeSize + "]";
	}
	
	/////////////////////////
	
    public String getProcessedBy()
    {
        return processedBy;
    }

    public void setProcessedBy(String processedBy)
    {
        this.processedBy = processedBy;
    }
    
}
