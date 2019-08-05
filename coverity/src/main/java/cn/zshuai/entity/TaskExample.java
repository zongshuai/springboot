package cn.zshuai.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andBnameIsNull() {
            addCriterion("bname is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bname is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bname =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bname <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bname >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bname >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bname <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bname <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bname like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bname not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bname in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bname not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bname between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bname not between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andQnameIsNull() {
            addCriterion("qname is null");
            return (Criteria) this;
        }

        public Criteria andQnameIsNotNull() {
            addCriterion("qname is not null");
            return (Criteria) this;
        }

        public Criteria andQnameEqualTo(String value) {
            addCriterion("qname =", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameNotEqualTo(String value) {
            addCriterion("qname <>", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameGreaterThan(String value) {
            addCriterion("qname >", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameGreaterThanOrEqualTo(String value) {
            addCriterion("qname >=", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameLessThan(String value) {
            addCriterion("qname <", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameLessThanOrEqualTo(String value) {
            addCriterion("qname <=", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameLike(String value) {
            addCriterion("qname like", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameNotLike(String value) {
            addCriterion("qname not like", value, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameIn(List<String> values) {
            addCriterion("qname in", values, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameNotIn(List<String> values) {
            addCriterion("qname not in", values, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameBetween(String value1, String value2) {
            addCriterion("qname between", value1, value2, "qname");
            return (Criteria) this;
        }

        public Criteria andQnameNotBetween(String value1, String value2) {
            addCriterion("qname not between", value1, value2, "qname");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andHnameIsNull() {
            addCriterion("hname is null");
            return (Criteria) this;
        }

        public Criteria andHnameIsNotNull() {
            addCriterion("hname is not null");
            return (Criteria) this;
        }

        public Criteria andHnameEqualTo(String value) {
            addCriterion("hname =", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameNotEqualTo(String value) {
            addCriterion("hname <>", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameGreaterThan(String value) {
            addCriterion("hname >", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameGreaterThanOrEqualTo(String value) {
            addCriterion("hname >=", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameLessThan(String value) {
            addCriterion("hname <", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameLessThanOrEqualTo(String value) {
            addCriterion("hname <=", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameLike(String value) {
            addCriterion("hname like", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameNotLike(String value) {
            addCriterion("hname not like", value, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameIn(List<String> values) {
            addCriterion("hname in", values, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameNotIn(List<String> values) {
            addCriterion("hname not in", values, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameBetween(String value1, String value2) {
            addCriterion("hname between", value1, value2, "hname");
            return (Criteria) this;
        }

        public Criteria andHnameNotBetween(String value1, String value2) {
            addCriterion("hname not between", value1, value2, "hname");
            return (Criteria) this;
        }

        public Criteria andQsidIsNull() {
            addCriterion("qsid is null");
            return (Criteria) this;
        }

        public Criteria andQsidIsNotNull() {
            addCriterion("qsid is not null");
            return (Criteria) this;
        }

        public Criteria andQsidEqualTo(Integer value) {
            addCriterion("qsid =", value, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidNotEqualTo(Integer value) {
            addCriterion("qsid <>", value, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidGreaterThan(Integer value) {
            addCriterion("qsid >", value, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("qsid >=", value, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidLessThan(Integer value) {
            addCriterion("qsid <", value, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidLessThanOrEqualTo(Integer value) {
            addCriterion("qsid <=", value, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidIn(List<Integer> values) {
            addCriterion("qsid in", values, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidNotIn(List<Integer> values) {
            addCriterion("qsid not in", values, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidBetween(Integer value1, Integer value2) {
            addCriterion("qsid between", value1, value2, "qsid");
            return (Criteria) this;
        }

        public Criteria andQsidNotBetween(Integer value1, Integer value2) {
            addCriterion("qsid not between", value1, value2, "qsid");
            return (Criteria) this;
        }

        public Criteria andHsidIsNull() {
            addCriterion("hsid is null");
            return (Criteria) this;
        }

        public Criteria andHsidIsNotNull() {
            addCriterion("hsid is not null");
            return (Criteria) this;
        }

        public Criteria andHsidEqualTo(Integer value) {
            addCriterion("hsid =", value, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidNotEqualTo(Integer value) {
            addCriterion("hsid <>", value, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidGreaterThan(Integer value) {
            addCriterion("hsid >", value, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hsid >=", value, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidLessThan(Integer value) {
            addCriterion("hsid <", value, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidLessThanOrEqualTo(Integer value) {
            addCriterion("hsid <=", value, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidIn(List<Integer> values) {
            addCriterion("hsid in", values, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidNotIn(List<Integer> values) {
            addCriterion("hsid not in", values, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidBetween(Integer value1, Integer value2) {
            addCriterion("hsid between", value1, value2, "hsid");
            return (Criteria) this;
        }

        public Criteria andHsidNotBetween(Integer value1, Integer value2) {
            addCriterion("hsid not between", value1, value2, "hsid");
            return (Criteria) this;
        }

        public Criteria andRsidIsNull() {
            addCriterion("rsid is null");
            return (Criteria) this;
        }

        public Criteria andRsidIsNotNull() {
            addCriterion("rsid is not null");
            return (Criteria) this;
        }

        public Criteria andRsidEqualTo(Integer value) {
            addCriterion("rsid =", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidNotEqualTo(Integer value) {
            addCriterion("rsid <>", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidGreaterThan(Integer value) {
            addCriterion("rsid >", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rsid >=", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidLessThan(Integer value) {
            addCriterion("rsid <", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidLessThanOrEqualTo(Integer value) {
            addCriterion("rsid <=", value, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidIn(List<Integer> values) {
            addCriterion("rsid in", values, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidNotIn(List<Integer> values) {
            addCriterion("rsid not in", values, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidBetween(Integer value1, Integer value2) {
            addCriterion("rsid between", value1, value2, "rsid");
            return (Criteria) this;
        }

        public Criteria andRsidNotBetween(Integer value1, Integer value2) {
            addCriterion("rsid not between", value1, value2, "rsid");
            return (Criteria) this;
        }

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andAstatusIsNull() {
            addCriterion("astatus is null");
            return (Criteria) this;
        }

        public Criteria andAstatusIsNotNull() {
            addCriterion("astatus is not null");
            return (Criteria) this;
        }

        public Criteria andAstatusEqualTo(Integer value) {
            addCriterion("astatus =", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusNotEqualTo(Integer value) {
            addCriterion("astatus <>", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusGreaterThan(Integer value) {
            addCriterion("astatus >", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("astatus >=", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusLessThan(Integer value) {
            addCriterion("astatus <", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusLessThanOrEqualTo(Integer value) {
            addCriterion("astatus <=", value, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusIn(List<Integer> values) {
            addCriterion("astatus in", values, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusNotIn(List<Integer> values) {
            addCriterion("astatus not in", values, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusBetween(Integer value1, Integer value2) {
            addCriterion("astatus between", value1, value2, "astatus");
            return (Criteria) this;
        }

        public Criteria andAstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("astatus not between", value1, value2, "astatus");
            return (Criteria) this;
        }

        public Criteria andBstatusIsNull() {
            addCriterion("bstatus is null");
            return (Criteria) this;
        }

        public Criteria andBstatusIsNotNull() {
            addCriterion("bstatus is not null");
            return (Criteria) this;
        }

        public Criteria andBstatusEqualTo(Integer value) {
            addCriterion("bstatus =", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotEqualTo(Integer value) {
            addCriterion("bstatus <>", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusGreaterThan(Integer value) {
            addCriterion("bstatus >", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bstatus >=", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusLessThan(Integer value) {
            addCriterion("bstatus <", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusLessThanOrEqualTo(Integer value) {
            addCriterion("bstatus <=", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusIn(List<Integer> values) {
            addCriterion("bstatus in", values, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotIn(List<Integer> values) {
            addCriterion("bstatus not in", values, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusBetween(Integer value1, Integer value2) {
            addCriterion("bstatus between", value1, value2, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bstatus not between", value1, value2, "bstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusIsNull() {
            addCriterion("cstatus is null");
            return (Criteria) this;
        }

        public Criteria andCstatusIsNotNull() {
            addCriterion("cstatus is not null");
            return (Criteria) this;
        }

        public Criteria andCstatusEqualTo(Integer value) {
            addCriterion("cstatus =", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusNotEqualTo(Integer value) {
            addCriterion("cstatus <>", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusGreaterThan(Integer value) {
            addCriterion("cstatus >", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cstatus >=", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusLessThan(Integer value) {
            addCriterion("cstatus <", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusLessThanOrEqualTo(Integer value) {
            addCriterion("cstatus <=", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusIn(List<Integer> values) {
            addCriterion("cstatus in", values, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusNotIn(List<Integer> values) {
            addCriterion("cstatus not in", values, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusBetween(Integer value1, Integer value2) {
            addCriterion("cstatus between", value1, value2, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("cstatus not between", value1, value2, "cstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusIsNull() {
            addCriterion("dstatus is null");
            return (Criteria) this;
        }

        public Criteria andDstatusIsNotNull() {
            addCriterion("dstatus is not null");
            return (Criteria) this;
        }

        public Criteria andDstatusEqualTo(Integer value) {
            addCriterion("dstatus =", value, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusNotEqualTo(Integer value) {
            addCriterion("dstatus <>", value, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusGreaterThan(Integer value) {
            addCriterion("dstatus >", value, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("dstatus >=", value, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusLessThan(Integer value) {
            addCriterion("dstatus <", value, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusLessThanOrEqualTo(Integer value) {
            addCriterion("dstatus <=", value, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusIn(List<Integer> values) {
            addCriterion("dstatus in", values, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusNotIn(List<Integer> values) {
            addCriterion("dstatus not in", values, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusBetween(Integer value1, Integer value2) {
            addCriterion("dstatus between", value1, value2, "dstatus");
            return (Criteria) this;
        }

        public Criteria andDstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("dstatus not between", value1, value2, "dstatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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