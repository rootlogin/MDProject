/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:6:20
 */

package com.gohon.material.POJO;

import java.util.List;

/**
 * Created by liuyonglong on 16/3/31.
 */
public class Test {
    /**
     * state : 200
     * msg : success
     * timestamp : 1459404298882
     */

    private HeadEntity head;
    private BodyEntity body;

    public HeadEntity getHead() {
        return head;
    }

    public void setHead(HeadEntity head) {
        this.head = head;
    }

    public BodyEntity getBody() {
        return body;
    }

    public void setBody(BodyEntity body) {
        this.body = body;
    }

    public static class HeadEntity {
        private String state;
        private String msg;
        private long timestamp;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static class BodyEntity {
        /**
         * hospitalId : 1
         * name : 301医院
         */

        private List<HospitalEntity> hospital;

        public List<HospitalEntity> getHospital() {
            return hospital;
        }

        public void setHospital(List<HospitalEntity> hospital) {
            this.hospital = hospital;
        }

        public static class HospitalEntity {
            private int hospitalId;
            private String name;

            public int getHospitalId() {
                return hospitalId;
            }

            public void setHospitalId(int hospitalId) {
                this.hospitalId = hospitalId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
