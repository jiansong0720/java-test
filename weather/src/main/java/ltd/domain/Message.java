package ltd.domain;

import ltd.domain.base.BaseDomain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Message extends BaseDomain {

    /**
     * 用户
     */
    @ManyToOne(optional = false)
    private Customer customer;

    /**
     * 发送时间
     */
    private Date sendDate;

    /**
     * 发送内容
     */
    private String content;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
