package com.egis.background.domain;

public class Results {
	
	public String Time;
	public String Message;
	public int TotalRecords;
	public Inputs Inputs;
	public String Product;
	public Records[] Records;

}




class Inputs{
    public String Account;
    public String  FirstName;
    public String  MiddleName;
    public String  LastName;
    public String  DOB;
    public String AgeMin;
    public String AgeMax;
    public String Address;
    public String  City;
    public String  State;
    public String County;
    public String  Zip;
    public String  ExactMatch;
    public String Limit;
    public String  OnlyPhotos;
}

class Records{
	
	public String Score;
	public String RecordId;
	public String Category;
	public String SourceorJurisdiction;
	public String State;
	public String FullName;
	public String FirstName;
	public String MiddleName;
	public String LastName;
	public String DOB;
	public String Age;
	public Address []Addresses;
	public Offense []Offenses;
}
class Address{
	public String Address;
	public String City;
	public String State;
	public String Zip;
	
	
}
class Offense{
	
	public String Description;
	public String CaseNumber;
	public String DateOfCrime;
	public String Jurisdiction;
	public String Disposition;
		
}
	


