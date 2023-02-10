package com.mouritech.lp.cppc.gateway.DTO;

public class PdfLocation
{
    private String name;

    private String locationID;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLocationID ()
    {
        return locationID;
    }

    public void setLocationID (String locationID)
    {
        this.locationID = locationID;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", locationID = "+locationID+"]";
    }
}