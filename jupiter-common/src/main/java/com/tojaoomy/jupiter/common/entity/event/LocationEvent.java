package com.tojaoomy.jupiter.common.entity.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 上报地理位置事件
 * 
 * @author hejian
 * 
 */
@XStreamAlias("xml")
public class LocationEvent extends BaseEvent {
    /** 地理位置纬度 */
    @XStreamAlias("Latitude")
    private String latitude;
    
    /** 地理位置经度 */
    @XStreamAlias("Longitude")
    private String longitude;
    
    /** 地理位置精度 */
    @XStreamAlias("Precision")
    private String precision;

    /**
     *
     *	Get the latitude
     *
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     *
     *	Set the latitude
     *
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     *
     *	Get the longitude
     *
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     *
     *	Set the longitude
     *
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     *
     *	Get the precision
     *
     * @return the precision
     */
    public String getPrecision() {
        return precision;
    }

    /**
     *
     *	Set the precision
     *
     * @param precision the precision to set
     */
    public void setPrecision(String precision) {
        this.precision = precision;
    }
    
}
