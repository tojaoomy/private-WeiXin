package com.tojaoomy.jupiter.common.enumeration;

/**
 * @author hejian
 * 
 */
public enum ButtonType {
    CLICK("click"), VIEW("view");

    private String code;

    private ButtonType(String code) {
        this.code = code;
    }

    /**
     * 
     * Get the code
     * 
     * @return the code
     */
    public String code() {
        return code;
    }

    /**
     * 
     * Set the code
     * 
     * @param code
     *            the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.code;
    }

}
