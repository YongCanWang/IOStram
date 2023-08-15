package com.trans.iostram.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Tom灿
 * @description:
 * @date :2023/8/11 12:55
 */
public class DataBean01 {


    @SerializedName("TPM")
    private TPMBean tPM;

    public TPMBean getTPM() {
        return tPM;
    }

    public void setTPM(TPMBean tPM) {
        this.tPM = tPM;
    }

    public static class TPMBean {
        private String utcTime;
        private PosBean pos;
        private double speed;
        private double heading;

        public String getUtcTime() {
            return utcTime;
        }

        public void setUtcTime(String utcTime) {
            this.utcTime = utcTime;
        }

        public PosBean getPos() {
            return pos;
        }

        public void setPos(PosBean pos) {
            this.pos = pos;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public double getHeading() {
            return heading;
        }

        public void setHeading(double heading) {
            this.heading = heading;
        }

        public static class PosBean {
            private double lat;
            @SerializedName("long")
            private double longX;
            private double elevation;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLongX() {
                return longX;
            }

            public void setLongX(double longX) {
                this.longX = longX;
            }

            public double getElevation() {
                return elevation;
            }

            public void setElevation(double elevation) {
                this.elevation = elevation;
            }
        }
    }
}
