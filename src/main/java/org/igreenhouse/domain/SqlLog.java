package org.igreenhouse.domain;

import java.sql.Timestamp;

/**
 * Created by AllenKO on 2015/12/2.
 */
public class SqlLog {
    private int uid;
    private String sqlstatement;
    private String parameters;
    private Timestamp timestamp;
    private int status;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSqlstatement() {
        return sqlstatement;
    }

    public void setSqlstatement(String sqlstatement) {
        this.sqlstatement = sqlstatement;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
