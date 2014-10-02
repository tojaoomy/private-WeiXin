package com.tojaoomy.jupiter.common.enumeration;

/**
 * @author hejian
 * 
 */
public enum MessageType {
    TEXT("text"), IMAGE("image"), VOICE("voice"), VIDEO("video"), LOCATION(
            "location"), LINK("link");

    private String code;

    private MessageType(String code) {
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
