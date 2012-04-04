/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Org.MrReporting.Shamik.BeanClass;

import java.util.Date;

/**
 *
 * @author shamik
 groupName varchar2(50)
hqName varchar2(50)
stateName varchar2(50)
loginID varchar2(20)
loginPassword varchar2(20)
firstName varchar2(50)
lastName varchar2(50)
fatherName varchar2(50)
dob date
mailaddress varchar2(50)
parmamanetAddress varchar2(50)
phonenumber varchar2(50)
mobilenumber varchar2(50)
sex char('M'/'F')
maritalstatus boolean 'y'/'n'
doa date
doj date
basic number(15,2)
hra number(15,2)
eallowance (15,2)
communication number(15,2)
vma number(15,2)
cca number(15,2)
userStatus char ('A'/'D') A-Active
D � DeActive (cannot be logged in )

 */
public class Mr {
    private String groupName,hqName,stateName,loginId,loginPassword,firstName,lastName,fatherName,mailAdress,permanentAddress,phoneNumber,mobileNumber;
	private char sex,userStatus;
	private Date doa,doj,dob;
	private float basic,hra,eallowance,communicationNumber,vma,cca;

    public void setDoa(Date doa) {
        this.doa = doa;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public void setUserStatus(char userStatus) {
        this.userStatus = userStatus;
    }
	

    public void setGroupName(String name){

        this.groupName=name;
    }    
public void setLoginId(String name){

        this.loginId=name;
    }

    public void setBasic(float basic) {
        this.basic = basic;
    }

    public void setCca(float cca) {
        this.cca = cca;
    }

    public void setCommunicationNumber(float communicationNumber) {
        this.communicationNumber = communicationNumber;
    }

    public void setEallowance(float eallowance) {
        this.eallowance = eallowance;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setHqName(String hqName) {
        this.hqName = hqName;
    }

    public void setHra(float hra) {
        this.hra = hra;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setVma(float vma) {
        this.vma = vma;
    }

    public float getBasic() {
        return basic;
    }

    public float getCca() {
        return cca;
    }

    public float getCommunicationNumber() {
        return communicationNumber;
    }

    public Date getDoa() {
        return doa;
    }

    public Date getDob() {
        return dob;
    }

    public Date getDoj() {
        return doj;
    }

    public float getEallowance() {
        return eallowance;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getHqName() {
        return hqName;
    }

    public float getHra() {
        return hra;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public char getSex() {
        return sex;
    }

    public String getStateName() {
        return stateName;
    }

    public char getUserStatus() {
        return userStatus;
    }

    public float getVma() {
        return vma;
    }
	public void setFirstName(String name){

        this.firstName=name;
    }
	public void setLastName(String name){

        this.lastName=name;
    }


        public String getLoginId(){

            return loginId;
        }
  


}
