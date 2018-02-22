package com.happygo.configserver.spring.schema;

/**
 * ClassName: LikabConfig <br/>
 * Description: LikabConfig <br/>
 * Date: 2017/12/21 16:06 <br/>
 *
 * @version 1.0 <br/>
 */
public class LikabConfig {

    /**
     * The Id.
     */
    private String id;

    /**
     * The Interface name.
     */
    private String interfaceName;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     * @return the id
     */
    public LikabConfig setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets interface name.
     *
     * @return the interface name
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * Sets interface name.
     *
     * @param interfaceName the interface name
     * @return the interface name
     */
    public LikabConfig setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
        return this;
    }
}