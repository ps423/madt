# MADT Programs - Savitribai Phule Pune University
## M.Sc. (Computer Science) Sem-II - CS-555-MJP
## Mobile App Development Technologies - Practical Examination 2023-2024

---

## Slip-wise Program Index

| Slip | Q1 Program | Q2 Program |
|------|-----------|-----------|
| Slip 1 | SplashActivity.java | StudentDB_MainActivity.java |
| Slip 2 | PerfectNumberActivity.java | CalculatorActivity.java |
| Slip 3 | ArmstrongActivity.java | PhoneValidationActivity.java |
| Slip 4 | ImageSwitcherActivity.java | MapsActivity.java |
| Slip 5 | AlertDialogActivity.java | LabelFormatActivity.java |
| Slip 6 | LoginActivity.java | MapsActivity.java (same as Slip4) |
| Slip 7 | ProgressBarActivity.java | EmployeeDBActivity.java |
| Slip 8 | ActivityLifecycleDemo.java | CustomerDBActivity.java |
| Slip 9 | PalindromeActivity.java | CalculatorActivity.java (same as Slip2) |
| Slip 10 | ArmstrongToastActivity.java | SpinnerActivity.java |
| Slip 11 | MainActivity.java (Power/Avg) | StringOpsActivity.java |
| Slip 12 | ToggleBulbActivity.java | LabelFormatActivity.java (same as Slip5) |
| Slip 13 | RegistrationActivity.java | ListViewActivity.java |
| Slip 14 | FactorialActivity.java | LoginValidationActivity.java |
| Slip 15 | ArithmeticActivity.java | BankActivity.java |
| Slip 16 | FirstActivity.java (Intent) | FirstActivity.java (same - 2 activities) |
| Slip 17 | ActivityLifecycleDemo.java (same as Slip8) | PhoneGap (HTML5 based) |
| Slip 18 | ColorFontActivity.java | ProjectDBActivity.java |
| Slip 19 | ChangeImageActivity.java | OptionMenuActivity.java |
| Slip 20 | NumberInputActivity.java | SendEmailActivity.java |
| Slip 21 | ActivityLifecycleDemo.java (same as Slip8) | SDCardActivity.java |
| Slip 22 | ChangeImageActivity.java (same as Slip19) | NumericOpsActivity.java |
| Slip 23 | ImplicitIntentActivity.java | LabelFormatActivity.java (same as Slip5) |
| Slip 24 | StringCaseActivity.java | CarDBActivity.java |
| Slip 25 | SMSActivity.java | LoginValidationActivity.java (same as Slip14) |

---

## Important Notes

### XML Layouts
- Each .java file contains the corresponding XML layout as a comment at the bottom.
- Copy the XML content to your `res/layout/` folder with the appropriate filename.

### Permissions Required
| Feature | Permission in AndroidManifest.xml |
|---------|----------------------------------|
| SMS | `SEND_SMS` |
| SD Card | `WRITE_EXTERNAL_STORAGE`, `READ_EXTERNAL_STORAGE` |
| Google Maps | Add API Key in manifest |
| Email | `INTERNET` |

### SQLite DB Programs (Slips 1, 7, 8, 18, 24)
All SQLite programs follow same pattern:
1. `openOrCreateDatabase()` - open/create DB
2. `execSQL()` - create table
3. `execSQL()` - insert records
4. `rawQuery()` - select all records
5. Display using Cursor

### Google Maps (Slips 4 & 6)
- Add dependency in build.gradle: `implementation 'com.google.android.gms:play-services-maps:18.1.0'`
- Add API key in AndroidManifest.xml

---
## How to use these programs in Android Studio

1. Create a new Android project
2. Copy the Java code to `app/src/main/java/...`
3. Copy XML (from comments) to `app/src/main/res/layout/`
4. Add required permissions to `AndroidManifest.xml`
5. Run on emulator or device

---
*Generated for SPPU M.Sc. CS Sem-II Practical Exam 2023-24*
