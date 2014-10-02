package com.tojaoomy.jupiter.common.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 地理位置消息
 * 
 * @author 何剑
 * @date 2014-09-19
 */
@XStreamAlias("xml")
public class LocationMessageRequest extends BaseMessageRequest {
    // 地理位置纬度
    @XStreamAlias("Location_X")
    private String location_X;
    
    // 地理位置经度
    @XStreamAlias("Location_Y")
    private String location_Y;

    // 地图缩放大小
    @XStreamAlias("Scale")
    private String scale;

    //地理位置信息
    @XStreamAlias("Label")
    private String label;

    /**
     *
     *	Get the location_X
     *
     * @return the location_X
     */
    public String getLocation_X() {
        return location_X;
    }

    /**
     *
     *	Set the location_X
     *
     * @param location_X the location_X to set
     */
    public void setLocation_X(String location_X) {
        this.location_X = location_X;
    }

    /**
     *
     *	Get the location_Y
     *
     * @return the location_Y
     */
    public String getLocation_Y() {
        return location_Y;
    }

    /**
     *
     *	Set the location_Y
     *
     * @param location_Y the location_Y to set
     */
    public void setLocation_Y(String location_Y) {
        this.location_Y = location_Y;
    }

    /**
     *
     *	Get the scale
     *
     * @return the scale
     */
    public String getScale() {
        return scale;
    }

    /**
     *
     *	Set the scale
     *
     * @param scale the scale to set
     */
    public void setScale(String scale) {
        this.scale = scale;
    }

    /**
     *
     *	Get the label
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     *	Set the label
     *
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

}
