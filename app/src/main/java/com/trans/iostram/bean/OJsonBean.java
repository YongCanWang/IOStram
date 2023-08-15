package com.trans.iostram.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Tom灿
 * @description:
 * @date :2023/8/14 17:06
 */
public class OJsonBean {

    @SerializedName("ObjItems")
    private List<ObjItemsBean> objItems;
    @SerializedName("Type")
    private int type;
    @SerializedName("Version")
    private String version;

    public List<ObjItemsBean> getObjItems() {
        return objItems;
    }

    public void setObjItems(List<ObjItemsBean> objItems) {
        this.objItems = objItems;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static class ObjItemsBean {
        @SerializedName("ObjID")
        private int objID;
        @SerializedName("Object")
        private ObjectBean object;
        @SerializedName("ParentID")
        private int parentID;
        @SerializedName("Type")
        private int type;
        private String tmModify;

        public int getObjID() {
            return objID;
        }

        public void setObjID(int objID) {
            this.objID = objID;
        }

        public ObjectBean getObject() {
            return object;
        }

        public void setObject(ObjectBean object) {
            this.object = object;
        }

        public int getParentID() {
            return parentID;
        }

        public void setParentID(int parentID) {
            this.parentID = parentID;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTmModify() {
            return tmModify;
        }

        public void setTmModify(String tmModify) {
            this.tmModify = tmModify;
        }

        public static class ObjectBean {
            @SerializedName("Comment")
            private String comment;
            @SerializedName("Name")
            private String name;
            @SerializedName("ObjectDetail")
            private ObjectDetailBean objectDetail;
            @SerializedName("Type")
            private int type;

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public ObjectDetailBean getObjectDetail() {
                return objectDetail;
            }

            public void setObjectDetail(ObjectDetailBean objectDetail) {
                this.objectDetail = objectDetail;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public static class ObjectDetailBean {
                @SerializedName("AltitudeColor")
                private int altitudeColor;
                @SerializedName("Edit")
                private int edit;
                @SerializedName("Gcj02")
                private int gcj02;
                @SerializedName("Latlng")
                private List<Double> latlng;
                @SerializedName("Mtp")
                private int mtp;
                @SerializedName("OverlayIdx")
                private int overlayIdx;
                @SerializedName("ShowLevel")
                private int showLevel;
                @SerializedName("ShowLevelMax")
                private int showLevelMax;
                @SerializedName("ShowName")
                private int showName;
                @SerializedName("TrackDraw")
                private TrackDrawBean trackDraw;
                @SerializedName("TrackType")
                private int trackType;

                public int getAltitudeColor() {
                    return altitudeColor;
                }

                public void setAltitudeColor(int altitudeColor) {
                    this.altitudeColor = altitudeColor;
                }

                public int getEdit() {
                    return edit;
                }

                public void setEdit(int edit) {
                    this.edit = edit;
                }

                public int getGcj02() {
                    return gcj02;
                }

                public void setGcj02(int gcj02) {
                    this.gcj02 = gcj02;
                }

                public List<Double> getLatlng() {
                    return latlng;
                }

                public void setLatlng(List<Double> latlng) {
                    this.latlng = latlng;
                }

                public int getMtp() {
                    return mtp;
                }

                public void setMtp(int mtp) {
                    this.mtp = mtp;
                }

                public int getOverlayIdx() {
                    return overlayIdx;
                }

                public void setOverlayIdx(int overlayIdx) {
                    this.overlayIdx = overlayIdx;
                }

                public int getShowLevel() {
                    return showLevel;
                }

                public void setShowLevel(int showLevel) {
                    this.showLevel = showLevel;
                }

                public int getShowLevelMax() {
                    return showLevelMax;
                }

                public void setShowLevelMax(int showLevelMax) {
                    this.showLevelMax = showLevelMax;
                }

                public int getShowName() {
                    return showName;
                }

                public void setShowName(int showName) {
                    this.showName = showName;
                }

                public TrackDrawBean getTrackDraw() {
                    return trackDraw;
                }

                public void setTrackDraw(TrackDrawBean trackDraw) {
                    this.trackDraw = trackDraw;
                }

                public int getTrackType() {
                    return trackType;
                }

                public void setTrackType(int trackType) {
                    this.trackType = trackType;
                }

                public static class TrackDrawBean {
                    @SerializedName("CadLineShowWid")
                    private int cadLineShowWid;
                    @SerializedName("CircleClr")
                    private int circleClr;
                    @SerializedName("CircleWidth")
                    private int circleWidth;
                    @SerializedName("Close")
                    private int close;
                    @SerializedName("LineAlpha")
                    private int lineAlpha;
                    @SerializedName("LineClr")
                    private int lineClr;
                    @SerializedName("LineType")
                    private int lineType;
                    @SerializedName("LineTypeCustom")
                    private int lineTypeCustom;
                    @SerializedName("LineTypeScale")
                    private int lineTypeScale;
                    @SerializedName("LineWidth")
                    private int lineWidth;
                    @SerializedName("NeedDrawDetail")
                    private int needDrawDetail;
                    @SerializedName("ShowType")
                    private int showType;
                    @SerializedName("SplineDegree")
                    private int splineDegree;

                    public int getCadLineShowWid() {
                        return cadLineShowWid;
                    }

                    public void setCadLineShowWid(int cadLineShowWid) {
                        this.cadLineShowWid = cadLineShowWid;
                    }

                    public int getCircleClr() {
                        return circleClr;
                    }

                    public void setCircleClr(int circleClr) {
                        this.circleClr = circleClr;
                    }

                    public int getCircleWidth() {
                        return circleWidth;
                    }

                    public void setCircleWidth(int circleWidth) {
                        this.circleWidth = circleWidth;
                    }

                    public int getClose() {
                        return close;
                    }

                    public void setClose(int close) {
                        this.close = close;
                    }

                    public int getLineAlpha() {
                        return lineAlpha;
                    }

                    public void setLineAlpha(int lineAlpha) {
                        this.lineAlpha = lineAlpha;
                    }

                    public int getLineClr() {
                        return lineClr;
                    }

                    public void setLineClr(int lineClr) {
                        this.lineClr = lineClr;
                    }

                    public int getLineType() {
                        return lineType;
                    }

                    public void setLineType(int lineType) {
                        this.lineType = lineType;
                    }

                    public int getLineTypeCustom() {
                        return lineTypeCustom;
                    }

                    public void setLineTypeCustom(int lineTypeCustom) {
                        this.lineTypeCustom = lineTypeCustom;
                    }

                    public int getLineTypeScale() {
                        return lineTypeScale;
                    }

                    public void setLineTypeScale(int lineTypeScale) {
                        this.lineTypeScale = lineTypeScale;
                    }

                    public int getLineWidth() {
                        return lineWidth;
                    }

                    public void setLineWidth(int lineWidth) {
                        this.lineWidth = lineWidth;
                    }

                    public int getNeedDrawDetail() {
                        return needDrawDetail;
                    }

                    public void setNeedDrawDetail(int needDrawDetail) {
                        this.needDrawDetail = needDrawDetail;
                    }

                    public int getShowType() {
                        return showType;
                    }

                    public void setShowType(int showType) {
                        this.showType = showType;
                    }

                    public int getSplineDegree() {
                        return splineDegree;
                    }

                    public void setSplineDegree(int splineDegree) {
                        this.splineDegree = splineDegree;
                    }
                }
            }
        }
    }
}
