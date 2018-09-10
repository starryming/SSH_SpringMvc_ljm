package com.learn.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user", schema = "ordersystemssh")
public class UserEntity {
    private int uid;
    private String username;
    private String password;
    private String phonenum;
    private String email;
    private Timestamp createtime;

    private int leaveDay;
    private String reason;
    private UsercardEntity usercardEntity;
    private List<LeaveEntity> leaveEntityList;

    @Id
    @Column(name = "uid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 64)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phonenum", nullable = true, length = 12)
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 32)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (uid != that.uid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (phonenum != null ? !phonenum.equals(that.phonenum) : that.phonenum != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phonenum != null ? phonenum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "createtime", nullable = false)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    /** 配置单边一对一
     * @return
     */                                                   //cascade配置级联方式，有PERSIST、REMOVE、MERGE、REFRESH等几种取值，
    @OneToOne(optional = true,cascade = {CascadeType.ALL})// 分别表示在保存、删除、修改、刷新Student类时，会自动在数据库,中保存、删除、修改、刷新属于它的StudentCard对象，ALL则表示所有动作皆级联。即级联后可以通过操作Student类来操作StudentCard类。
    @JoinColumn(name = "usercard_id")//usercard_id作为外键字段，关联usercard表中的主键
    public UsercardEntity getUsercardEntity() {
        return usercardEntity;
    }

    public void setUsercardEntity(UsercardEntity usercardEntity) {
        this.usercardEntity = usercardEntity;
    }

    public int getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(int leaveDay) {
        this.leaveDay = leaveDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    public List<LeaveEntity> getLeaveEntityList() {
        return leaveEntityList;
    }

    public void setLeaveEntityList(List<LeaveEntity> leaveEntityList) {
        this.leaveEntityList = leaveEntityList;
    }
}
