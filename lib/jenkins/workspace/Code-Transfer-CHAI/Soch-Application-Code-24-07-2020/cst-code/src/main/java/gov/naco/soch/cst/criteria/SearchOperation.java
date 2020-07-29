package gov.naco.soch.cst.criteria;

public enum SearchOperation {
    EQUALITY,LIKE;

    public static final String[] SIMPLE_OPERATION_SET = { "!","~" };

    public static final String OR_PREDICATE_FLAG = "^";

    public static SearchOperation getSimpleOperation(final char input) {
        switch (input) {
        case '~':
            return EQUALITY;
        case '!':
            return LIKE;
        default:
            return null;
        }
    }
}
