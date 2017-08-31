package com.example.android.genderanddevelopmentsurvey;

public class Person {

    //    unique identifier
    private int _id;

    //    Demography variables
    private String _name;
    private int _age;
    private int _housingNo;
    private int _bldg_no;
    private int _total_household;
    private String _gender;
    private String _barangay;
    private String _name_of_enumerator;
    private String _name_of_respondent;
    private String _address;
    private char _time_started;
    private String _relation_to_head;
    private String _marital_status;
    private String _religious_affiliation;
    private boolean _registered_birth;
    private boolean _indigenous_tribe;
    private char _date_of_birth;

    //    Education and Literacy
    private String _education;
    private String _school;
    private String _not_in_school;
    private boolean _literate;
    private boolean _attending_school;

    ///////////////////////////////////////
    //           CONSTRUCTORS           //
    /////////////////////////////////////

    //    default constructor
    public Person() {
    }

    //    constructor for name
    public Person(String _name) {
        this._name = _name;
        this._gender = null;
        this._age = 0;
        this._address = null;
        this._barangay = null;
    }

    //    constructor for name, age, gender, barangay
    public Person(String _name, int _age, String _gender, String _barangay) {
        this._name = _name;
        this._age = _age;
        this._gender = _gender;
        this._barangay = _barangay;
    }

    //    constructor for intro activity
    public Person(int housingNo, int bldg_no, int total_household, String name_of_enumerator, String name_of_respondent, String address, char time_started) {
        this._housingNo = housingNo;
        this._bldg_no = bldg_no;
        this._total_household = total_household;
        this._name_of_enumerator = name_of_enumerator;
        this._name_of_respondent = name_of_respondent;
        this._address = address;
        this._time_started = time_started;
    }

    ///////////////////////////////////////
    //           SETTERS                //
    /////////////////////////////////////

    //    getter for id
    public int get_id() {
        return _id;
    }

    //    setter for id
    public void set_id(int _id) {
        this._id = _id;
    }

    //    getter for name
    public String get_name() {
        return _name;
    }

    //    setter for name
    public void set_name(String name) {
        this._name = name;
    }

    //    getter for age
    public int get_age() {
        return _age;
    }

    ///////////////////////////////////////
    //           GETTERS                //
    /////////////////////////////////////

    //    setter for age
    public void set_age(int age) {
        this._age = age;
    }

    //    getter for gender
    public String get_gender() {
        return _gender;
    }

    //    setter for gender
    public void set_gender(String gender) {
        this._gender = gender;
    }

    //    getter for barangay
    public String get_barangay() {
        return _barangay;
    }

    //    setter for barangay
    public void set_barangay(String _barangay) {
        this._barangay = _barangay;
    }

//    getter for address

    public String get_address() {
        return _address;
    }
}
