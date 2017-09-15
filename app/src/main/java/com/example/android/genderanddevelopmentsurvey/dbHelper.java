package com.example.android.genderanddevelopmentsurvey;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "gad.db";
    private static final String TABLE_NAME = "records";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_GENDER = "Gender";
    private static final String COLUMN_ADDRESS = "Address";
    private static final String COLUMN_BARANGAY = "Barangay";
    private static final String COLUMN_HOUSING = "Housing_Unit";
    private static final String COLUMN_BUILDING = "Building";
    private static final String COLUMN_TOTALHOUSEHOLD = "Total_Household";
    private static final String COLUMN_ENUMERATOR = "Enumerator";
    private static final String COLUMN_RESPONDENT = "Respondent";
    private static final String COLUMN_TIMESTARTED = "Time_started";
    private static final String COLUMN_RELATION = "Relation";
    private static final String COLUMN_BIRTH_REGISTRATION = "Birth_Registration";
    private static final String COLUMN_MARITAL_STATUS = "Marital_Status";
    private static final String COLUMN_RELIGION = "Religion";
    private static final String COLUMN_TRIBE = "Tribe";
    private static final String COLUMN_LITERACY = "Literacy";
    private static final String COLUMN_EDUCATION = "Education";
    private static final String COLUMN_ATTENDING_SCHOOL = "Attending_School";
    private static final String COLUMN_REGISTERED_VOTER = "Registered_Voter";
    private static final String COLUMN_JOB = "Job";
    private static final String COLUMN_INDUSTRY_TYPE = "Industry_Type";
    private static final String COLUMN_WORKING_HOURS = "Working_Hours";
    private static final String COLUMN_EMPLOYMENT_STATUS = "Employment_Status";
    private static final String COLUMN_BUSINESS = "Business";
    private static final String COLUMN_INCOME_SOURCE = "Income_Source";
    private static final String COLUMN_MONTHLY_INCOME = "Monthly_Income";
    private static final String COLUMN_MONTHLY_EXPENSES = "Monthly_Expenses";
    private static final String COLUMN_SSS = "SSS";
    private static final String COLUMN_PAGIBIG = "PAGIBIG";
    private static final String COLUMN_GSIS = "GSIS";
    private static final String COLUMN_JOB_SEARCH = "Job_Search";
    private static final String COLUMN_JOB_LOCATION = "Job_Location";
    private static final String COLUMN_JOB_POSITION = "Job_Position";
    private static final String COLUMN_DISABILITY = "Disability";
    private static final String COLUMN_DISABILITY_TYPE = "Disability_Type";
    private static final String COLUMN_HYPERTENSIOND = "Hypertension";
    private static final String COLUMN_DIABETES = "Diabetes";
    private static final String COLUMN_PREGNANT = "Pregnant";
    private static final String COLUMN_DWELLINGS = "Dwellings";
    private static final String COLUMN_HOUSING_MATERIALS = "Housing_Materials";
    private static final String COLUMN_HOUSE_TYPE = "House_Type";
    private static final String COLUMN_USE_OF_STRUCTURE = "Use of Structure";
    private static final String COLUMN_TOILET_TYPE = "Toilet_Type";
    private static final String COLUMN_WATER_SOURCE = "Water_Source";
    private static final String COLUMN_LIGHTING_SYSTEM = "Lighting_System";
    private static final String COLUMN_DRAINAGE_SYSTEM = "Drainage_System";
    private static final String COLUMN_SEPTIC_TANK = "Septic_Tank";
    private static final String COLUMN_SEPTIC_TANK_ACCESS = "Septic_Tank_Access";
    private static final String COLUMN_APPLIANCES = "Appliances";
    private static final String COLUMN_PROPERTIES = "Properties";

    public dbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE '" + TABLE_NAME + "' ('" +
                COLUMN_ID + "' INTEGER PRIMARY KEY AUTOINCREMENT, '" +
                COLUMN_NAME + "' TEXT, '" +
                COLUMN_AGE + "' INTEGER, '" +
                COLUMN_GENDER + "' TEXT, '" +
                COLUMN_BARANGAY + "' TEXT, '" +
                COLUMN_ADDRESS + "' TEXT, '" +
                COLUMN_HOUSING + "' INTEGER, '" +
                COLUMN_BUILDING + "' INTEGER, '" +
                COLUMN_TOTALHOUSEHOLD + "' INTEGER, '" +
                COLUMN_ENUMERATOR + "' TEXT, '" +
                COLUMN_RESPONDENT + "' TEXT, '" +
                COLUMN_TIMESTARTED + "' TEXT " +

                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
        onCreate(db);
    }

    //    add person to the database
    public void addPerson(Person person) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, person.get_name());
        contentValues.put(COLUMN_AGE, person.get_age());
        contentValues.put(COLUMN_GENDER, person.get_gender());
        contentValues.put(COLUMN_ADDRESS, person.get_address());
        contentValues.put(COLUMN_BARANGAY, person.get_barangay());
        contentValues.put(COLUMN_HOUSING, person.get_housing());
        contentValues.put(COLUMN_BUILDING, person.get_bldg());
        contentValues.put(COLUMN_TOTALHOUSEHOLD, person.get_total_household());
        contentValues.put(COLUMN_ENUMERATOR, person.get_name_of_enumerator());
        contentValues.put(COLUMN_RESPONDENT, person.get_name_of_respondent());
        contentValues.put(COLUMN_TIMESTARTED, person.get_time_started());
        SQLiteDatabase db = getWritableDatabase();
        //        db.insertOrThrow(TABLE_NAME, null, contentValues);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    //    delete row/entry from the database
    public void deletePerson(String personsName) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_NAME + " = " + "'" + personsName + "'", null);
        db.close();
    }

    //    insert other details of the person
    public void otherDetails(String name, int age, String gender, String barangay, int housing,
                             int building, int total_household, String enumerator, String respondent,
                             String address, String time_started) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_NAME + " SET " +
                COLUMN_AGE + " = " + age + ", " +
                COLUMN_GENDER + " = '" + gender +
                COLUMN_BARANGAY + " = '" + barangay +
                COLUMN_ADDRESS + " = '" + address +
                COLUMN_HOUSING + " = '" + housing +
                COLUMN_BUILDING + " = '" + building +
                COLUMN_TOTALHOUSEHOLD + " = '" + total_household +
                COLUMN_ENUMERATOR + " = '" + enumerator +
                COLUMN_RESPONDENT + " = '" + respondent +
                COLUMN_TIMESTARTED + " = '" + time_started +
                "' WHERE " +
                COLUMN_NAME + " = '" + name + "';");
        db.close();
    }
}
