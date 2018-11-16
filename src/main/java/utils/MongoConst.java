package utils;
/**
 * @author pyt
 * @createTime 2018年10月17日下午1:39:49
 */
public enum MongoConst {
	GT("$gt"),
    LT("$lt"),
    GTE("$gte"),
    LTE("$lte"),
    AND("and"),
    OR("or"),
    NOT("not");
    private String compareIdentify;
 
    MongoConst(String compareIdentify) {
        this.compareIdentify = compareIdentify;
    }
    public String getCompareIdentify() {
        return compareIdentify;
    }
}

