package cn.zshuai.entity;

public class CovJson {
    private Integer id;

    private Integer cid;

    private String checker;

    private String file;

    private String fun;

    private String category;

    private String eln;

    private String edn;

    private String comName;

    private Integer tid;

    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun == null ? null : fun.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getEln() {
        return eln;
    }

    public void setEln(String eln) {
        this.eln = eln == null ? null : eln.trim();
    }

    public String getEdn() {
        return edn;
    }

    public void setEdn(String edn) {
        this.edn = edn == null ? null : edn.trim();
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

	@Override
	public String toString() {
		return "CovJson [id=" + id + ", cid=" + cid + ", checker=" + checker + ", file=" + file + ", fun=" + fun
				+ ", category=" + category + ", eln=" + eln + ", edn=" + edn + ", comName=" + comName + ", tid=" + tid
				+ ", tag=" + tag + "]";
	}
    
    
}