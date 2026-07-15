# README

## פרטי הסטודנט

**שם:** מתן שמעיה

---

# תיאור הפרויקט

פרויקט זה כולל בדיקות יחידה (Unit Tests) שנכתבו עבור המחלקה `App` בשפת Java באמצעות **JUnit 5**.

מטרת הפרויקט היא לבדוק את תקינות המתודות השונות במחלקה באמצעות מגוון רחב של תרחישים, הכוללים מקרים רגילים, מקרי קצה, טיפול בחריגות ובדיקת ההתנהגות בפועל של הקוד.

---

# דרישות מקדימות

לפני הרצת הפרויקט יש לוודא שמותקנים במחשב:

* Java JDK (בגרסה המתאימה לפרויקט)
* Git
* Gradle (או שימוש ב־Gradle Wrapper המצורף לפרויקט)
* סביבת פיתוח כגון IntelliJ IDEA או Visual Studio Code

---

# שכפול הפרויקט (Clone)

יש לפתוח מסוף (Terminal או CMD) ולהריץ את הפקודה:

```bash
git clone <Repository-URL>
```

לאחר מכן יש להיכנס לתיקיית הפרויקט:

```bash
cd <Repository-Name>
```

> יש להחליף את `<Repository-URL>` בכתובת מאגר ה־GitHub ואת `<Repository-Name>` בשם התיקייה שנוצרה לאחר השכפול.

---

# הרצת הבדיקות

## באמצעות Gradle Wrapper (מומלץ)

### Windows

```bash
gradlew test
```

### Linux / macOS

```bash
./gradlew test
```

---

## באמצעות Visual Studio Code

1. פתחו את תיקיית הפרויקט ב־Visual Studio Code.
2. המתינו לטעינת הפרויקט ולסיום הסנכרון של Gradle.
3. פתחו את הקובץ:

```
src/test/java/org/example/AppTest.java
```

4. לחצו על **Run Test** או השתמשו בחלונית **Testing** של Visual Studio Code כדי להריץ את כל הבדיקות.

---

## באמצעות IntelliJ IDEA

1. פתחו את הפרויקט.
2. המתינו לטעינת Gradle.
3. פתחו את הקובץ:

```
src/test/java/org/example/AppTest.java
```

4. לחצו באמצעות הכפתור הימני על המחלקה `AppTest` ובחרו באפשרות **Run 'AppTest'**.

---

# תוצאה צפויה

במידה וכל הבדיקות עברו בהצלחה, תופיע הודעה דומה לזו:

```text
BUILD SUCCESSFUL
```

או:

```text
58 tests completed, 58 passed
```

---

# הערות

* הבדיקות נכתבו באמצעות **JUnit 5**.
* הבדיקות בוחנות את ההתנהגות הנוכחית של המחלקה `App`.
* במהלך כתיבת הבדיקות נבדקו גם מקרי קצה, טיפול בחריגות והתנהגות במקרים חריגים (כגון `NullPointerException` ו־Integer Overflow).
* קוד המקור של המחלקה `App` אינו משתנה במהלך הרצת הבדיקות.
