package com.example.android.genderanddevelopmentsurvey;

public class Person {

    //    unique identifier
    private int _id;

    //    Demography variables
    private String _name;
    private int _age;
    private int _housing;
    private int _bldg;
    private int _total_household;
    private String _gender;
    private String _barangay;
    private String _name_of_enumerator;
    private String _name_of_respondent;
    private String _address;
    private String _time_started;
    private String _relation;
    private String _registered_birth;
    private String _marital_status;
    private String _religious_affiliation;


    private boolean _indigenous_tribe;
    private char _date_of_birth;

    //    Education and Literacy
    private String _education;
    private String _school;
    private String _not_in_school;
    private boolean _literate;
    private boolean _attending_school;



             /*CONSTRUCTORS*/

    //    default constructor
    public Person() {
    }

    //    constructor for name
    public Person(String _name) {
        this._name = _name;
    }

    //    constructor for intro activity
    public Person(int housingNo, int bldg_no, int total_household, String name_of_enumerator,
                  String name_of_respondent, String address, String time_started) {
        this._housing = housingNo;
        this._bldg = bldg_no;
        this._total_household = total_household;
        this._name_of_enumerator = name_of_enumerator;
        this._name_of_respondent = name_of_respondent;
        this._address = address;
        this._time_started = time_started;
    }

    /*GETTERS AND SETTERS*/

    public String get_name() {
        return _name;
    }   //    getter for name

    public void set_name(String name) {
        this._name = name;
    }   //    setter for name

    public String get_gender() {
        return _gender;
    }   //    getter for gender

    public void set_gender(String gender) {
        this._gender = gender;
    }   //    setter for gender

    public int get_age() {
        return _age;
    }   //    getter for age

    public void set_age(int age) {
        this._age = age;
    }   //    setter for age

    public String get_barangay() {
        return _barangay;
    }    //    getter for barangay

    public void set_barangay(String _barangay) {
        this._barangay = _barangay;
    }   //    setter for barangay

    public String get_address() {
        return _address;
    }   //    getter for address

    public void set_address(String _address) {
        this._address = _address;
    } // setter for households address

    public int get_housing() {
        return _housing;
    } //  getter for housing no

    public void set_housing(int _housing) {
        this._housing = _housing;
    } // setter for housing no.

    public int get_bldg() {
        return _bldg;
    } //    getter for building no

    public void set_bldg(int _bldg) {
        this._bldg = _bldg;
    } // setter for building no.

    public int get_total_household() {
        return _total_household;
    } // getter for total household no

    public void set_total_household(int _total_household) {
        this._total_household = _total_household;
    } // setter for total number of household

    public String get_name_of_enumerator() {
        return _name_of_enumerator;
    } // getter for the enumerator

    public void set_name_of_enumerator(String _name_of_enumerator) {
        this._name_of_enumerator = _name_of_enumerator;
    } // setter for the name of the enumerator

    public String get_name_of_respondent() {
        return _name_of_respondent;
    } // getter for the respondent

    public void set_name_of_respondent(String _name_of_respondent) {
        this._name_of_respondent = _name_of_respondent;
    } // setter for the name of the respondent

    public String get_time_started() {
        return _time_started;
    } // getter for time started

    public void set_time_started(String _time_started) {
        this._time_started = _time_started;
    } // setter for time started

    public void set_marital_status(String _marital_status) {
        this._marital_status = _marital_status;
    } // setter for marital status

    public void set_religious_affiliation(String _religious_affiliation) {
        this._religious_affiliation = _religious_affiliation;
    } // setter for religious affiliation

    public void set_indigenous_tribe(boolean _indigenous_tribe) {
        this._indigenous_tribe = _indigenous_tribe;
    } // setter for indigenous tribe

    public void set_date_of_birth(char _date_of_birth) {
        this._date_of_birth = _date_of_birth;
    } // setter for birth date

    public void set_education(String _education) {
        this._education = _education;
    } // setter for educational attainment

    public void set_school(String _school) {
        this._school = _school;
    } // setter for school

    public void set_not_in_school(String _not_in_school) {
        this._not_in_school = _not_in_school;
    } // setter for if not in school

    public void set_literate(boolean _literate) {
        this._literate = _literate;
    } // setter for literacy

    public void set_attending_school(boolean _attending_school) {
        this._attending_school = _attending_school;
    } // setter for if attending school

    public String get_relation() {
        return _relation;
    }

    public void set_relation(String _relation) {
        this._relation = _relation;
    }

    public String get_registered_birth() {
        return _registered_birth;
    }

    public void set_registered_birth(String _registered_birth) {
        this._registered_birth = _registered_birth;
    } // setter for birth registration
}
