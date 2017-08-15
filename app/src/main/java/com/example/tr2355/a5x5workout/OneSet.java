package com.example.tr2355.a5x5workout;

import com.orm.SugarRecord;

/**
 * Created by tr2355 on 8/14/2017.
 */

public class OneSet extends SugarRecord {

    double record;

    public OneSet() {
    }

    public OneSet(double record) {

        this.record = record;
    }
}
