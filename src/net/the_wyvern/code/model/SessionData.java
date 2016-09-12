package net.the_wyvern.code.model;

import java.io.Serializable;

public class SessionData implements Serializable
{
    public static final long serialVersionUID = 1L;

    private String processedBy;
    private String value;

    public SessionData()
    {
        this.processedBy = "none";
        this.value = "default value";
    }

    public String getProcessedBy()
    {
        return processedBy;
    }

    public void setProcessedBy(String processedBy)
    {
        this.processedBy = processedBy;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
