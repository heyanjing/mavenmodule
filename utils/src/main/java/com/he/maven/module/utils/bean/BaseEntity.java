package com.he.maven.module.utils.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class BaseEntity<ID extends Serializable> extends BaseBean {
    public abstract ID getId();

    public abstract void setId(ID id);
}
