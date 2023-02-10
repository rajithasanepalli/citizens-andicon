package com.mouritech.lp.cppc.gateway.DTO;

public class PdfVariance
{
    private Double budget;

    private boolean isNetTotal;

    private String glDesc;

    private String glCategory;

    private String explanation;

    private String month;

    private Double actual;

    private String glGroup;

    private Double variance;
    
    private Double variancePercentage;

    private boolean isGlGroupTotal;

    private boolean isGlDescTotal;

    private boolean isGlCatTotal;

    public Double getBudget ()
    {
        return budget;
    }

    public void setBudget (Double budget)
    {
        this.budget = budget;
    }

    public boolean getIsNetTotal ()
    {
        return isNetTotal;
    }

    public void setIsNetTotal (boolean isNetTotal)
    {
        this.isNetTotal = isNetTotal;
    }

    public String getGlDesc ()
    {
        return glDesc;
    }

    public void setGlDesc (String glDesc)
    {
        this.glDesc = glDesc;
    }

    public String getGlCategory ()
    {
        return glCategory;
    }

    public void setGlCategory (String glCategory)
    {
        this.glCategory = glCategory;
    }

    public String getExplanation ()
    {
        return explanation;
    }

    public void setExplanation (String explanation)
    {
        this.explanation = explanation;
    }

    public String getMonth ()
    {
        return month;
    }

    public void setMonth (String month)
    {
        this.month = month;
    }

    public Double getActual ()
    {
        return actual;
    }

    public void setActual (Double actual)
    {
        this.actual = actual;
    }

    public String getGlGroup ()
    {
        return glGroup;
    }

    public void setGlGroup (String glGroup)
    {
        this.glGroup = glGroup;
    }

    public Double getVariance ()
    {
        return variance;
    }

    public void setVariance (Double variance)
    {
        this.variance = variance;
    }

    public boolean getIsGlGroupTotal ()
    {
        return isGlGroupTotal;
    }

    public void setIsGlGroupTotal (boolean isGlGroupTotal)
    {
        this.isGlGroupTotal = isGlGroupTotal;
    }

    public boolean getIsGlDescTotal ()
    {
        return isGlDescTotal;
    }

    public void setIsGlDescTotal (boolean isGlDescTotal)
    {
        this.isGlDescTotal = isGlDescTotal;
    }

    public boolean getIsGlCatTotal ()
    {
        return isGlCatTotal;
    }

    public void setIsGlCatTotal (boolean isGlCatTotal)
    {
        this.isGlCatTotal = isGlCatTotal;
    }

    public Double getVariancePercentage() {
		return variancePercentage;
	}

	public void setVariancePercentage(Double variancePercentage) {
		this.variancePercentage = variancePercentage;
	}

	@Override
	public String toString() {
		return "ClassPojo [budget = " + budget + ", isNetTotal = " + isNetTotal
				+ ", glDesc = " + glDesc + ", glCategory = " + glCategory
				+ ", explanation = " + explanation + ", month = " + month
				+ ", actual = " + actual + ", glGroup = " + glGroup
				+ ", variance = " + variance + ", variancePercentage = "
				+ variancePercentage + ", isGlGroupTotal = " + isGlGroupTotal
				+ ", isGlDescTotal = " + isGlDescTotal + ", isGlCatTotal = "
				+ isGlCatTotal + "]";
	}
}
