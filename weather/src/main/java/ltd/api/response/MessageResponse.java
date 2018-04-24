package ltd.api.response;

import java.util.Date;

/*
 * 短信
 *
 * songshu 2017/11/28 10:28
 */
public class MessageResponse {

    /**
     * 用户名
     */
    private String customerName;

    /**
     * 电话
     */
    private String customerPhone;

    /**
     * 发送时间
     */
    private Date sendDate;

    /**
     * 发送内容
     */
    private String content;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
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
