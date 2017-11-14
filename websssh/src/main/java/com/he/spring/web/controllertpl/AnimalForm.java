package com.he.spring.web.controllertpl;

/**
 * Created by heyanjing on 2017/11/14 11:30.
 */
public class AnimalForm {

    private long id;

    private String oname;

    private int ocount;

    private String memo;

    public AnimalForm() {
    }

    public AnimalForm(long id, String oname, int ocount, String memo) {
        this.id = id;
        this.oname = oname;
        this.ocount = ocount;
        this.memo = memo;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the oname
     */
    public String getOname() {
        return oname;
    }

    /**
     * @param oname the oname to set
     */
    public void setOname(String oname) {
        this.oname = oname;
    }

    /**
     * @return the ocount
     */
    public int getOcount() {
        return ocount;
    }

    /**
     * @param ocount the ocount to set
     */
    public void setOcount(int ocount) {
        this.ocount = ocount;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }


}