/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.sistemas.software.parcial2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rodrigo
 */
@Entity
@Table(name = "t2_student")
@NamedQueries({
    @NamedQuery(name = "T2Student.findAll", query = "SELECT t FROM T2Student t")})
public class T2Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_student")
    private Integer idStudent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "surname")
    private String surname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "student_id")
    private String studentId;
    @Size(max = 30)
    @Column(name = "phone1")
    private String phone1;
    @Size(max = 30)
    @Column(name = "phone2")
    private String phone2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address2")
    private String address2;
     @JsonIgnore
    @JoinTable(name = "t2_student_rel_course", joinColumns = {
        @JoinColumn(name = "id_student", referencedColumnName = "id_student")}, inverseJoinColumns = {
        @JoinColumn(name = "id_course", referencedColumnName = "id_course")})
    @ManyToMany
    private List<T2Course> t2CourseList;

    public T2Student() {
    }

    public T2Student(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public T2Student(Integer idStudent, String name, String surname, String email, Date birthdate, String studentId, String address1, String address2) {
        this.idStudent = idStudent;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.studentId = studentId;
        this.address1 = address1;
        this.address2 = address2;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public List<T2Course> getT2CourseList() {
        return t2CourseList;
    }

    public void setT2CourseList(List<T2Course> t2CourseList) {
        this.t2CourseList = t2CourseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof T2Student)) {
            return false;
        }
        T2Student other = (T2Student) object;
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.umg.ingenieria.sistemas.software.parcial2.entity.T2Student[ idStudent=" + idStudent + " ]";
    }
    
}
