package com.yzh.ssm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 
 * motorhome
 *
 * @mbg.generated 2018-11-23 09:33:01
 */

@ApiModel(value="MotorHome",description="MotorHome实体")//对类进行swagger注解
public class MotorHome {
    /**
     * 自增ID
     *
     * motorhome.Id
     *
     * @mbg.generated 2018-11-23 09:33:01
     */

    @ApiModelProperty(value="主键",name="id")//对类的字段属性进行swagger注解
    private Integer id;

    /**
     * 分享人id
     *
     * motorhome.ShareUID
     *
     * @mbg.generated 2018-11-23 09:33:01
     */

    @ApiModelProperty(value="分享id",name="shareuid")//对类的字段属性进行swagger注解
    private Integer shareuid;

    /**
     * 访问者ID
     *
     * motorhome.ReadUID
     *
     * @mbg.generated 2018-11-23 09:33:01
     */

    @ApiModelProperty(value="访问者id",name="readuid")//对类的字段属性进行swagger注解
    private Integer readuid;

    /**
     * 访问者IP
     *
     * motorhome.IP
     *
     * @mbg.generated 2018-11-23 09:33:01
     */

    @ApiModelProperty(value="访问ip",name="ip")//对类的字段属性进行swagger注解
    private String ip;

    /**
     * 时间
     *
     * motorhome.ReadDate
     *
     * @mbg.generated 2018-11-23 09:33:01
     */

    @ApiModelProperty(value="访问时间",name="readdate")//对类的字段属性进行swagger注解
    private Date readdate;

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public Integer getId() {
        return id;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public Integer getShareuid() {
        return shareuid;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public void setShareuid(Integer shareuid) {
        this.shareuid = shareuid;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public Integer getReaduid() {
        return readuid;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public void setReaduid(Integer readuid) {
        this.readuid = readuid;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public String getIp() {
        return ip;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public Date getReaddate() {
        return readdate;
    }

    /**
     * @mbg.generated 2018-11-23 09:33:01
     */
    public void setReaddate(Date readdate) {
        this.readdate = readdate;
    }
}