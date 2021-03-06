package cn.scau.pojo;

import java.util.ArrayList;
import java.util.List;

public class RateTypeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public RateTypeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPrepaidIsNull() {
            addCriterion("prepaid is null");
            return (Criteria) this;
        }

        public Criteria andPrepaidIsNotNull() {
            addCriterion("prepaid is not null");
            return (Criteria) this;
        }

        public Criteria andPrepaidEqualTo(Boolean value) {
            addCriterion("prepaid =", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidNotEqualTo(Boolean value) {
            addCriterion("prepaid <>", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidGreaterThan(Boolean value) {
            addCriterion("prepaid >", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("prepaid >=", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidLessThan(Boolean value) {
            addCriterion("prepaid <", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidLessThanOrEqualTo(Boolean value) {
            addCriterion("prepaid <=", value, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidIn(List<Boolean> values) {
            addCriterion("prepaid in", values, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidNotIn(List<Boolean> values) {
            addCriterion("prepaid not in", values, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidBetween(Boolean value1, Boolean value2) {
            addCriterion("prepaid between", value1, value2, "prepaid");
            return (Criteria) this;
        }

        public Criteria andPrepaidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("prepaid not between", value1, value2, "prepaid");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateIsNull() {
            addCriterion("freeCancelDate is null");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateIsNotNull() {
            addCriterion("freeCancelDate is not null");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateEqualTo(Integer value) {
            addCriterion("freeCancelDate =", value, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateNotEqualTo(Integer value) {
            addCriterion("freeCancelDate <>", value, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateGreaterThan(Integer value) {
            addCriterion("freeCancelDate >", value, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeCancelDate >=", value, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateLessThan(Integer value) {
            addCriterion("freeCancelDate <", value, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateLessThanOrEqualTo(Integer value) {
            addCriterion("freeCancelDate <=", value, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateIn(List<Integer> values) {
            addCriterion("freeCancelDate in", values, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateNotIn(List<Integer> values) {
            addCriterion("freeCancelDate not in", values, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateBetween(Integer value1, Integer value2) {
            addCriterion("freeCancelDate between", value1, value2, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andFreeCancelDateNotBetween(Integer value1, Integer value2) {
            addCriterion("freeCancelDate not between", value1, value2, "freeCancelDate");
            return (Criteria) this;
        }

        public Criteria andIsToAllIsNull() {
            addCriterion("isToAll is null");
            return (Criteria) this;
        }

        public Criteria andIsToAllIsNotNull() {
            addCriterion("isToAll is not null");
            return (Criteria) this;
        }

        public Criteria andIsToAllEqualTo(Boolean value) {
            addCriterion("isToAll =", value, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllNotEqualTo(Boolean value) {
            addCriterion("isToAll <>", value, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllGreaterThan(Boolean value) {
            addCriterion("isToAll >", value, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isToAll >=", value, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllLessThan(Boolean value) {
            addCriterion("isToAll <", value, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllLessThanOrEqualTo(Boolean value) {
            addCriterion("isToAll <=", value, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllIn(List<Boolean> values) {
            addCriterion("isToAll in", values, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllNotIn(List<Boolean> values) {
            addCriterion("isToAll not in", values, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllBetween(Boolean value1, Boolean value2) {
            addCriterion("isToAll between", value1, value2, "isToAll");
            return (Criteria) this;
        }

        public Criteria andIsToAllNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isToAll not between", value1, value2, "isToAll");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RateType
     *
     * @mbg.generated do_not_delete_during_merge Sat Aug 04 20:04:16 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}