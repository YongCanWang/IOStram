package com.trans.iostram.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Tom灿
 * @description:
 * @date :2023/8/11 12:56
 */
public class DataBean02 {


    @SerializedName("BSM")
    private BSMBean bSM;

    public BSMBean getBSM() {
        return bSM;
    }

    public void setBSM(BSMBean bSM) {
        this.bSM = bSM;
    }

    public static class BSMBean {
        private String abs;
        private AccelSetBean accelSet;
        private String angle;
        private String auxBrakes;
        private String brakeBoost;
        private BrakesBean brakes;
        private String ceateTime;
        private String emergencyExt;
        private String fuelType;
        private String gnssStatus;
        private double heading;
        private String id;
        private String lightbarInUse;
        private String lights;
        private String msgCnt;
        private OtherBean other;
        private String pcertEvent;
        private String plateNo;
        private PosBean pos;
        private double power;
        private double rangeMileage;
        private String responseType;
        private String safetyExt;
        private String scs;
        private String sirenInUse;
        private SizeBean size;
        private double speed;
        private String transmission;
        private String utcTime;
        private VehicleClassBean vehicleClass;

        public String getAbs() {
            return abs;
        }

        public void setAbs(String abs) {
            this.abs = abs;
        }

        public AccelSetBean getAccelSet() {
            return accelSet;
        }

        public void setAccelSet(AccelSetBean accelSet) {
            this.accelSet = accelSet;
        }

        public String getAngle() {
            return angle;
        }

        public void setAngle(String angle) {
            this.angle = angle;
        }

        public String getAuxBrakes() {
            return auxBrakes;
        }

        public void setAuxBrakes(String auxBrakes) {
            this.auxBrakes = auxBrakes;
        }

        public String getBrakeBoost() {
            return brakeBoost;
        }

        public void setBrakeBoost(String brakeBoost) {
            this.brakeBoost = brakeBoost;
        }

        public BrakesBean getBrakes() {
            return brakes;
        }

        public void setBrakes(BrakesBean brakes) {
            this.brakes = brakes;
        }

        public String getCeateTime() {
            return ceateTime;
        }

        public void setCeateTime(String ceateTime) {
            this.ceateTime = ceateTime;
        }

        public String getEmergencyExt() {
            return emergencyExt;
        }

        public void setEmergencyExt(String emergencyExt) {
            this.emergencyExt = emergencyExt;
        }

        public String getFuelType() {
            return fuelType;
        }

        public void setFuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public String getGnssStatus() {
            return gnssStatus;
        }

        public void setGnssStatus(String gnssStatus) {
            this.gnssStatus = gnssStatus;
        }

        public double getHeading() {
            return heading;
        }

        public void setHeading(double heading) {
            this.heading = heading;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLightbarInUse() {
            return lightbarInUse;
        }

        public void setLightbarInUse(String lightbarInUse) {
            this.lightbarInUse = lightbarInUse;
        }

        public String getLights() {
            return lights;
        }

        public void setLights(String lights) {
            this.lights = lights;
        }

        public String getMsgCnt() {
            return msgCnt;
        }

        public void setMsgCnt(String msgCnt) {
            this.msgCnt = msgCnt;
        }

        public OtherBean getOther() {
            return other;
        }

        public void setOther(OtherBean other) {
            this.other = other;
        }

        public String getPcertEvent() {
            return pcertEvent;
        }

        public void setPcertEvent(String pcertEvent) {
            this.pcertEvent = pcertEvent;
        }

        public String getPlateNo() {
            return plateNo;
        }

        public void setPlateNo(String plateNo) {
            this.plateNo = plateNo;
        }

        public PosBean getPos() {
            return pos;
        }

        public void setPos(PosBean pos) {
            this.pos = pos;
        }

        public double getPower() {
            return power;
        }

        public void setPower(double power) {
            this.power = power;
        }

        public double getRangeMileage() {
            return rangeMileage;
        }

        public void setRangeMileage(double rangeMileage) {
            this.rangeMileage = rangeMileage;
        }

        public String getResponseType() {
            return responseType;
        }

        public void setResponseType(String responseType) {
            this.responseType = responseType;
        }

        public String getSafetyExt() {
            return safetyExt;
        }

        public void setSafetyExt(String safetyExt) {
            this.safetyExt = safetyExt;
        }

        public String getScs() {
            return scs;
        }

        public void setScs(String scs) {
            this.scs = scs;
        }

        public String getSirenInUse() {
            return sirenInUse;
        }

        public void setSirenInUse(String sirenInUse) {
            this.sirenInUse = sirenInUse;
        }

        public SizeBean getSize() {
            return size;
        }

        public void setSize(SizeBean size) {
            this.size = size;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public String getTransmission() {
            return transmission;
        }

        public void setTransmission(String transmission) {
            this.transmission = transmission;
        }

        public String getUtcTime() {
            return utcTime;
        }

        public void setUtcTime(String utcTime) {
            this.utcTime = utcTime;
        }

        public VehicleClassBean getVehicleClass() {
            return vehicleClass;
        }

        public void setVehicleClass(VehicleClassBean vehicleClass) {
            this.vehicleClass = vehicleClass;
        }

        public static class AccelSetBean {
            private String lat;
            @SerializedName("long")
            private double longX;
            private String vert;
            private double yaw;

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public double getLongX() {
                return longX;
            }

            public void setLongX(double longX) {
                this.longX = longX;
            }

            public String getVert() {
                return vert;
            }

            public void setVert(String vert) {
                this.vert = vert;
            }

            public double getYaw() {
                return yaw;
            }

            public void setYaw(double yaw) {
                this.yaw = yaw;
            }
        }

        public static class BrakesBean {
            private String brakePadel;
            private String traction;
            private String wheelBrakes;

            public String getBrakePadel() {
                return brakePadel;
            }

            public void setBrakePadel(String brakePadel) {
                this.brakePadel = brakePadel;
            }

            public String getTraction() {
                return traction;
            }

            public void setTraction(String traction) {
                this.traction = traction;
            }

            public String getWheelBrakes() {
                return wheelBrakes;
            }

            public void setWheelBrakes(String wheelBrakes) {
                this.wheelBrakes = wheelBrakes;
            }
        }

        public static class OtherBean {
            private String drivingMode;
            private String throttleOpenDegree;
            private double totalMileage;
            private String wiperGearStatus;

            public String getDrivingMode() {
                return drivingMode;
            }

            public void setDrivingMode(String drivingMode) {
                this.drivingMode = drivingMode;
            }

            public String getThrottleOpenDegree() {
                return throttleOpenDegree;
            }

            public void setThrottleOpenDegree(String throttleOpenDegree) {
                this.throttleOpenDegree = throttleOpenDegree;
            }

            public double getTotalMileage() {
                return totalMileage;
            }

            public void setTotalMileage(double totalMileage) {
                this.totalMileage = totalMileage;
            }

            public String getWiperGearStatus() {
                return wiperGearStatus;
            }

            public void setWiperGearStatus(String wiperGearStatus) {
                this.wiperGearStatus = wiperGearStatus;
            }
        }

        public static class PosBean {
            private double elevation;
            private double lat;
            private double lon;

            public double getElevation() {
                return elevation;
            }

            public void setElevation(double elevation) {
                this.elevation = elevation;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }
        }

        public static class SizeBean {
            private String height;
            private String length;
            private String width;

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getLength() {
                return length;
            }

            public void setLength(String length) {
                this.length = length;
            }

            public String getWidth() {
                return width;
            }

            public void setWidth(String width) {
                this.width = width;
            }
        }

        public static class VehicleClassBean {
            private String classification;

            public String getClassification() {
                return classification;
            }

            public void setClassification(String classification) {
                this.classification = classification;
            }
        }
    }
}
