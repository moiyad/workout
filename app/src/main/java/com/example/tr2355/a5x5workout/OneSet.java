package com.example.tr2355.a5x5workout;

import com.orm.SugarRecord;

/**
 * Created by tr2355 on 8/14/2017.
 */

public class OneSet extends SugarRecord {

    int record;

    public OneSet() {
    }

    public int getRecord() {

        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public OneSet(int record) {

        this.record = record;
    }
}
