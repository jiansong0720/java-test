package ltd.domain;

import ltd.domain.base.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/*
 * 用户实体
 *
 * songshu 2017/11/23 15:19
 */
@Entity
public class Customer extends BaseDomain {

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 查询地点
     */
    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "customer")
    private List<Message> list;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Message> getList() {
        return list;
    }

    public void setList(List<Message> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
