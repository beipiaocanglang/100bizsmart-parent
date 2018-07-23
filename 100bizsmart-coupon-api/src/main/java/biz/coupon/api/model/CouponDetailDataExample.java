package biz.coupon.api.model;

import java.util.ArrayList;
import java.util.List;

public class CouponDetailDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponDetailDataExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("mid is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mid is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mid =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mid <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mid >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mid >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mid <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mid <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mid in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mid not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mid between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mid not between", value1, value2, "mid");
            return (Criteria) this;
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

        public Criteria andCreateOnIsNull() {
            addCriterion("create_on is null");
            return (Criteria) this;
        }

        public Criteria andCreateOnIsNotNull() {
            addCriterion("create_on is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOnEqualTo(String value) {
            addCriterion("create_on =", value, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnNotEqualTo(String value) {
            addCriterion("create_on <>", value, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnGreaterThan(String value) {
            addCriterion("create_on >", value, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnGreaterThanOrEqualTo(String value) {
            addCriterion("create_on >=", value, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnLessThan(String value) {
            addCriterion("create_on <", value, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnLessThanOrEqualTo(String value) {
            addCriterion("create_on <=", value, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnLike(String value) {
            addCriterion("create_on like", value, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnNotLike(String value) {
            addCriterion("create_on not like", value, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnIn(List<String> values) {
            addCriterion("create_on in", values, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnNotIn(List<String> values) {
            addCriterion("create_on not in", values, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnBetween(String value1, String value2) {
            addCriterion("create_on between", value1, value2, "createOn");
            return (Criteria) this;
        }

        public Criteria andCreateOnNotBetween(String value1, String value2) {
            addCriterion("create_on not between", value1, value2, "createOn");
            return (Criteria) this;
        }

        public Criteria andPayOnIsNull() {
            addCriterion("pay_on is null");
            return (Criteria) this;
        }

        public Criteria andPayOnIsNotNull() {
            addCriterion("pay_on is not null");
            return (Criteria) this;
        }

        public Criteria andPayOnEqualTo(String value) {
            addCriterion("pay_on =", value, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnNotEqualTo(String value) {
            addCriterion("pay_on <>", value, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnGreaterThan(String value) {
            addCriterion("pay_on >", value, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnGreaterThanOrEqualTo(String value) {
            addCriterion("pay_on >=", value, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnLessThan(String value) {
            addCriterion("pay_on <", value, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnLessThanOrEqualTo(String value) {
            addCriterion("pay_on <=", value, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnLike(String value) {
            addCriterion("pay_on like", value, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnNotLike(String value) {
            addCriterion("pay_on not like", value, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnIn(List<String> values) {
            addCriterion("pay_on in", values, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnNotIn(List<String> values) {
            addCriterion("pay_on not in", values, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnBetween(String value1, String value2) {
            addCriterion("pay_on between", value1, value2, "payOn");
            return (Criteria) this;
        }

        public Criteria andPayOnNotBetween(String value1, String value2) {
            addCriterion("pay_on not between", value1, value2, "payOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnIsNull() {
            addCriterion("cancel_on is null");
            return (Criteria) this;
        }

        public Criteria andCancelOnIsNotNull() {
            addCriterion("cancel_on is not null");
            return (Criteria) this;
        }

        public Criteria andCancelOnEqualTo(String value) {
            addCriterion("cancel_on =", value, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnNotEqualTo(String value) {
            addCriterion("cancel_on <>", value, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnGreaterThan(String value) {
            addCriterion("cancel_on >", value, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_on >=", value, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnLessThan(String value) {
            addCriterion("cancel_on <", value, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnLessThanOrEqualTo(String value) {
            addCriterion("cancel_on <=", value, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnLike(String value) {
            addCriterion("cancel_on like", value, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnNotLike(String value) {
            addCriterion("cancel_on not like", value, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnIn(List<String> values) {
            addCriterion("cancel_on in", values, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnNotIn(List<String> values) {
            addCriterion("cancel_on not in", values, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnBetween(String value1, String value2) {
            addCriterion("cancel_on between", value1, value2, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andCancelOnNotBetween(String value1, String value2) {
            addCriterion("cancel_on not between", value1, value2, "cancelOn");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCancelByIsNull() {
            addCriterion("cancel_by is null");
            return (Criteria) this;
        }

        public Criteria andCancelByIsNotNull() {
            addCriterion("cancel_by is not null");
            return (Criteria) this;
        }

        public Criteria andCancelByEqualTo(String value) {
            addCriterion("cancel_by =", value, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByNotEqualTo(String value) {
            addCriterion("cancel_by <>", value, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByGreaterThan(String value) {
            addCriterion("cancel_by >", value, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_by >=", value, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByLessThan(String value) {
            addCriterion("cancel_by <", value, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByLessThanOrEqualTo(String value) {
            addCriterion("cancel_by <=", value, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByLike(String value) {
            addCriterion("cancel_by like", value, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByNotLike(String value) {
            addCriterion("cancel_by not like", value, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByIn(List<String> values) {
            addCriterion("cancel_by in", values, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByNotIn(List<String> values) {
            addCriterion("cancel_by not in", values, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByBetween(String value1, String value2) {
            addCriterion("cancel_by between", value1, value2, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andCancelByNotBetween(String value1, String value2) {
            addCriterion("cancel_by not between", value1, value2, "cancelBy");
            return (Criteria) this;
        }

        public Criteria andPayByIsNull() {
            addCriterion("pay_by is null");
            return (Criteria) this;
        }

        public Criteria andPayByIsNotNull() {
            addCriterion("pay_by is not null");
            return (Criteria) this;
        }

        public Criteria andPayByEqualTo(String value) {
            addCriterion("pay_by =", value, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByNotEqualTo(String value) {
            addCriterion("pay_by <>", value, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByGreaterThan(String value) {
            addCriterion("pay_by >", value, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByGreaterThanOrEqualTo(String value) {
            addCriterion("pay_by >=", value, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByLessThan(String value) {
            addCriterion("pay_by <", value, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByLessThanOrEqualTo(String value) {
            addCriterion("pay_by <=", value, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByLike(String value) {
            addCriterion("pay_by like", value, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByNotLike(String value) {
            addCriterion("pay_by not like", value, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByIn(List<String> values) {
            addCriterion("pay_by in", values, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByNotIn(List<String> values) {
            addCriterion("pay_by not in", values, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByBetween(String value1, String value2) {
            addCriterion("pay_by between", value1, value2, "payBy");
            return (Criteria) this;
        }

        public Criteria andPayByNotBetween(String value1, String value2) {
            addCriterion("pay_by not between", value1, value2, "payBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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