package com.harsh.student.RestAPIStudentDemo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name="STUDENT_TBL")
@Table(name="STUDENT_TBL")
/*
 * 1.You have to make object field name with samllters then upper leters
 * 2.in one to many you have to set B enity in Aotherwise foreign ky colu,n is not fill in enity B using foreign key mapping satergy or Manytoone
 * 3.Use cascade an insertable updatble nullable for save enitity simulatneouly depending on conditions
 * 4.@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "StudentId") for serialization in biderational
 * 
 * */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "StudentId")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
//by default jackson go for getter method of field to and from convert json to pojo if u specify on field then it will genretae two propeerties for it
	private long StudentId;
	
	private long version;
		
	private String StudentName;
		
	private Date DateOfBirth;
		
	private String MobileNo;
		
	private String RollNo;
	
	private Date RowInsertionDateTime; 
	
	private Date RowUpdationDateTime; 
	
	private String DummyColumn;
	
	
	
	
	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	 @JsonProperty("StudentId")
	
	public long getStudentId() {
		return StudentId;
	}

	public void setStudentId(long studentId) {
		StudentId = studentId;
	}
	
	
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	@NotBlank
	@Column(name="STUDENT_NAME",nullable=false,unique=true,updatable=true,insertable=true)
	 @JsonProperty("StudentName")
	public String getStudentName() {
		return StudentName;
	}

	@Column(name="MOBILE_NO",nullable=true,unique=false,updatable=true,insertable=true)
	 @JsonProperty("MobileNo")
	public String getMobileNo() {
		return MobileNo;
	}
	
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	
	@Column(name="DOB",nullable=false,insertable=true)
	@JsonFormat(pattern="dd-MM-yyyy")
	 @JsonProperty("DateOfBirth")
	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	
	
	@Column(name="ROLL_NO",nullable=true,unique=true,updatable=false,insertable=true)
	 @JsonProperty("RollNo")
	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ROW_INSERTION_DATE_TIME", nullable = false,updatable=false,insertable=true)
	@CreationTimestamp
	 @JsonProperty("RowInsertionDateTime")
	@JsonFormat(pattern="dd-MM-yyyy")
	public Date getRowInsertionDateTime() {
		return RowInsertionDateTime;
	}

	public void setRowInsertionDateTime(Date rowInsertionDateTime) {
		RowInsertionDateTime = rowInsertionDateTime;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ROW_UPDATION_DATE_TIME", nullable = false,updatable=true,insertable=true)
	@UpdateTimestamp
	 @JsonProperty("RowUpdationDateTime")
	@JsonFormat(pattern="dd-MM-yyyy")
	public Date getRowUpdationDateTime() {
		return RowUpdationDateTime;
	}

	
	public void setRowUpdationDateTime(Date rowUpdationDateTime) {
		RowUpdationDateTime = rowUpdationDateTime;
	}
	
	@Column(name = "DUMMY_COLUMN", nullable = true,updatable=true,insertable=true)
	 @JsonProperty("DummyColumn")///for json field matching by default jackson check getter name 
	public String getDummyColumn() {
		return DummyColumn;
	}

	public void setDummyColumn(String dummyColumn) {
		DummyColumn = dummyColumn;
	}
	
	private String dummyColumn1;
	@Column(name = "DUMMYCOLUMN1", nullable = true,updatable=true,insertable=true)
	public String getDummyColumn1() {
		return dummyColumn1;
	}

	public void setDummyColumn1(String dummyColumn1) {
		this.dummyColumn1 = dummyColumn1;
	}
	//-------------------------------------------------------------
	//ONE TO ONE
	//In these one to one if primary key of table B is in table A as foreign key then first it insert it table B then in table A  
	/*private StudentDetails studentdetails;
	@OneToOne(cascade=CascadeType.ALL,optional=true,fetch=FetchType.EAGER,orphanRemoval=false) 
	public StudentDetails getStudentdetails() {
		return studentdetails;
	}

	public void setStudentdetails(StudentDetails studentdetails) {
		this.studentdetails = studentdetails;
	}
	*/
	//
	
	//-------------------------------------------------------------
	//cascade=CascadeType.ALL,optional=true,fetch=FetchType.EAGER,orphanRemoval=false,
		// bidrectional ONE TO ONE
	// If u not follow basic one to one and make primary key of table A as foreign key Of table B like many to one then FK tbale of B 
	//then you have to set B in A otherwise it will fill empty
	/*	private StudentDetails2 studentDetails2;
		@OneToOne(mappedBy="objStudent2",cascade=CascadeType.ALL)
		public StudentDetails2 getStudentDetails2() {
			return studentDetails2;
		}

		public void setStudentDetails2(StudentDetails2 studentDetails2) {
			this.studentDetails2 = studentDetails2;
		}
		*/
	//----------------------------------------------------------------///
	//ONE TO MANY
	//if we take list instead of set then it will not create both foreign key as primary key in join table this so use set		
    private Set<PhoneNumber>lsPhoneNumber;
    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="STUDENT_PHONE_NUMBER_MAPPING_TBL",joinColumns={@JoinColumn(name="STUDENT_ID", nullable=true)},
	inverseJoinColumns={@JoinColumn(name="PHONE_NO_ID")})
    @JsonProperty("PhoneNumber")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	public Set<PhoneNumber> getLsPhoneNumber() {
		return lsPhoneNumber;
	}

	public void setLsPhoneNumber(Set<PhoneNumber> lsPhoneNumber) {
		this.lsPhoneNumber = lsPhoneNumber;
	}

	

/*   private PhoneNumber toCheckHowOneToManySqlWorks;*/

//You can't map onetomany without collection.
/*   @OneToMany(cascade=CascadeType.ALL,mappedBy="objStudent")
public PhoneNumber getToCheckHowOneToManySqlWorks() {
	return toCheckHowOneToManySqlWorks;
}

public void setToCheckHowOneToManySqlWorks(PhoneNumber toCheckHowOneToManySqlWorks) {
	this.toCheckHowOneToManySqlWorks = toCheckHowOneToManySqlWorks;
}*/
	
	  private List<PhoneNumbers> toCheckHowOneToManySqlWorks;

	//You can't map onetomany without collection.
	 // @JsonIgnore
	   @OneToMany(cascade=CascadeType.ALL,mappedBy="objStudent",fetch = FetchType.EAGER)
	public List<PhoneNumbers> getToCheckHowOneToManySqlWorks() {
		return toCheckHowOneToManySqlWorks;
	}

	public void setToCheckHowOneToManySqlWorks(List<PhoneNumbers> toCheckHowOneToManySqlWorks) {
		this.toCheckHowOneToManySqlWorks = toCheckHowOneToManySqlWorks;
	}
	
	public void addPhoneNumbers(PhoneNumbers ObjPhoneNumbers)
	{
			if(toCheckHowOneToManySqlWorks==null)
			{
				//but use hashset it just for practice
				//toCheckHowOneToManySqlWorks=new HashSet<PhoneNumbers>();
				toCheckHowOneToManySqlWorks=new ArrayList<PhoneNumbers>();
			}
			ObjPhoneNumbers.setObjStudent(this);
			toCheckHowOneToManySqlWorks.add(ObjPhoneNumbers);
	}

	
		
	

	

}
