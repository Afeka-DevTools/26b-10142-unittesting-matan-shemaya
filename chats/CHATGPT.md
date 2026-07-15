# Chat Transcript

## Me

> מה הולך, יש לי משימה שבא אני צריך להשתמש ב LLM כדי ליצור פרומפט לבוא
> אחר שמתמשק עם סביבת העבודה שלי במקרה שלי ה LLM COPILOT של VS כדי שהוא
> ייצור לי בדיקות יחידה לאיזה קוד שיש לי

## Chat

> כן, הבנתי את המשימה: אתה צריך להשתמש ב־LLM אחד כדי לבנות פרומפט איכותי
> ל־GitHub Copilot בתוך Visual Studio, כך ש־Copilot יקרא את הקוד שלך
> וייצר עבורו בדיקות יחידה.
>
> כדי לבנות לך פרומפט מדויק, צריך להתאים אותו לשפה, לספריית הבדיקות
> ולמבנה הקוד. למשל, ב־Java אפשר להשתמש ב־JUnit, וב־C# בדרך כלל ב־xUnit,
> NUnit או MSTest.
>
> פרומפט בסיסי טוב יכול להיות:

    Analyze the following code and generate comprehensive unit tests for it.

    Requirements:

> Use the unit testing framework already configured in the project.
> Cover normal cases, edge cases, invalid inputs, and exception
> handling. Test every public method independently. Use clear and
> descriptive test method names. Follow the Arrange-Act-Assert pattern.

    Do not modify the production code.

> Mock external dependencies where necessary. Avoid duplicate or
> redundant tests. Add a short comment above each test explaining what
> behavior it verifies. Make sure all generated tests compile and can
> run in the current project.
>
> Before generating the tests:
>
> Identify the expected behavior of each method. Identify possible edge
> cases and failure scenarios. List any assumptions you are making.
>
> Then generate the complete unit test class or classes for the selected
> code.
>
> אפשר גם לתת ל־Copilot הוראה יותר חזקה שמתייחסת ישירות לקובץ הפתוח:

    Review the currently selected class and create unit tests for all of its public behavior.

> Use the testing framework and conventions already present in this
> solution.
>
> For each public method:
>
> Test at least one valid scenario. Test boundary values. Test invalid
> input where relevant. Test expected exceptions. Verify state changes
> and return values. Verify interactions with dependencies when mocking
> is required.
>
> Additional constraints:
>
> Follow Arrange-Act-Assert. Keep each test focused on one behavior. Use
> descriptive names in the format MethodName_Scenario_ExpectedResult.

    Do not test private methods directly.
    Do not change the implementation code merely to make a test pass.
    If the code is not testable because of tightly coupled dependencies, explain the problem and suggest the smallest possible refactoring separately.

> Return runnable test code, not pseudocode.
>
> כדי שההגשה תהיה טובה יותר, כדאי להסביר שבנית את הפרומפט כך שהוא לא רק
> אומר "תיצור בדיקות", אלא מגדיר:
>
> מה לבדוק. באיזה מבנה לכתוב. מה לא לעשות. כיצד לטפל בחריגות ובתלויות.
> כיצד לוודא שהפלט באמת ניתן להרצה.
>
> תשלח לי את הקוד, השפה וספריית הבדיקות שבה אתם משתמשים, ואבנה לך פרומפט
> מותאם ממש למחלקה שלך.
>
> בהנחה שהפרויקט משתמש ב־JUnit 5, זה פרומפט מותאם שאפשר להדביק ב־GitHub
> Copilot Chat בתוך Visual Studio Code, כאשר הקובץ App.java פתוח או
> מסומן:
>
> You are a Java unit-testing expert.

    Analyze the org.example.App class in the currently open file and generate a complete JUnit 5 test class named AppTest.

    Use:

> Java JUnit 5 (org.junit.jupiter.api) Static assertions from
> org.junit.jupiter.api.Assertions The same package as the production
> class: org.example
>
> Create tests for every public static method in App:
>
> add(int a, int b) isPrime(int n) reverse(String s) factorial(int n)
> isPalindrome(String s) fibonacciUpTo(int n) charFrequency(String
> input) isAnagram(String s1, String s2) average(int\[\] arr)
> filterEvens(List`<Integer>`{=html} list) mostCommonWord(String text)

    Testing requirements:

> Follow the Arrange-Act-Assert structure. Give every test a descriptive
> name using the format: methodName_condition_expectedResult Keep every
> test focused on one behavior. Test normal cases, boundary cases,
> invalid inputs, and exceptions where applicable. Use assertEquals,
> assertTrue, assertFalse, assertThrows, and assertIterableEquals where
> appropriate. Use a delta when comparing double values.

    Do not modify the production code.
    Do not test private implementation details.

> Generate compilable and runnable Java code, not pseudocode. Include
> all necessary imports. Add a short comment above every test explaining
> what it verifies.
>
> Include at least the following scenarios:
>
> add Two positive numbers A positive and a negative number Two negative
> numbers Addition involving zero Integer overflow behavior, verifying
> Java's actual int behavior isPrime Numbers below 2, including a
> negative number, 0, and 1 The smallest prime number, 2 Several prime
> numbers Several composite numbers A perfect square such as 49 A
> relatively large prime number reverse A normal string An empty string
> A one-character string A string containing spaces A string containing
> numbers and symbols Verify the current behavior for a null argument
> using assertThrows factorial factorial(0) returns 1 factorial(1)
> returns 1 A normal value such as 5 A negative value throws
> IllegalArgumentException Verify the current integer-overflow behavior
> for a sufficiently large value such as 13 isPalindrome A simple
> palindrome A non-palindrome Mixed uppercase and lowercase letters A
> phrase containing spaces and punctuation, such as "A man, a plan, a
> canal: Panama" An empty string A string containing only punctuation
> Verify the current behavior for null fibonacciUpTo Limit 0 Limit 1 A
> normal limit such as 10 A limit that is itself a Fibonacci number A
> negative input throws IllegalArgumentException Verify that no returned
> value is greater than the specified limit charFrequency A normal word
> with repeated characters An empty string A string containing spaces A
> string containing uppercase and lowercase versions of the same letter,
> verifying that they are counted separately Verify the current behavior
> for null isAnagram Two basic anagrams Anagrams with different letter
> casing Anagrams containing spaces Two strings that are not anagrams
> Empty strings Strings with repeated letters Verify the current
> behavior when either argument is null average Several positive
> integers Negative integers A mixture of positive and negative integers
> A single-element array Values whose average is not an integer An empty
> array throws IllegalArgumentException Verify the current behavior for
> a null array filterEvens A mixed list of odd and even numbers A list
> containing only odd numbers A list containing only even numbers An
> empty list Negative even numbers Duplicate values Verify that the
> original input list is not modified Verify the current behavior for a
> null list Verify the current behavior when the list contains a null
> element mostCommonWord A normal sentence with one clearly most common
> word Case-insensitive word counting Text containing punctuation A
> single-word input Verify that the returned word is lowercase Avoid
> asserting a specific result when multiple words have the same maximum
> frequency because the implementation uses a HashMap, whose iteration
> order is not guaranteed Verify the current behavior for an empty
> string Verify the current behavior for punctuation-only text Verify
> the current behavior for null

    Before writing the test code, briefly list any ambiguous or potentially problematic behaviors you identified, especially:

> Methods do not explicitly validate null factorial can overflow because
> it returns int add can overflow because it returns int mostCommonWord
> does not define how ties should be resolved Empty or punctuation-only
> text may produce an empty string as a word fibonacciUpTo may
> eventually overflow for very large limits
>
> After that analysis, output the complete contents of AppTest.java in
> one Java code block.
>
> למה הפרומפט הזה טוב
>
> הוא מאלץ את Copilot לבדוק לא רק מקרים רגילים אלא גם מקרי קצה
> והתנהגויות שלא הוגדרו במפורש. למשל, בקוד שלך אין בדיקת null, ולכן
> הפרומפט מבקש לבדוק את ההתנהגות הנוכחית ולא להניח שצריך להיזרק חריג
> מסוים שתכננת מראש.
>
> יש גם כמה נקודות חשובות בקוד:
>
> factorial(13) גורם לחריגת טווח של int, אבל Java לא זורקת חריגה במקרה
> כזה --- התוצאה פשוט גולשת. גם add(Integer.MAX_VALUE, 1) גולש
> ל־Integer.MIN_VALUE. ב־mostCommonWord, אם לשתי מילים אותה שכיחות, אי
> אפשר לדעת בוודאות איזו מהן תוחזר בגלל השימוש ב־HashMap. עבור מחרוזת
> ריקה, split("\\W+") עשוי ליצור מערך שמכיל מחרוזת ריקה, ולכן
> mostCommonWord("") עשויה להחזיר"". חלק מהמתודות יזרקו
> NullPointerException במקרה של null, אף שהדבר לא מתועד ב־JavaDoc.
>
> בהגשה אפשר להסביר שהפרומפט נבנה כדי לגרום ל־LLM לזהות גם דרישות
> מפורשות מהתיעוד וגם התנהגויות שנובעות בפועל מהמימוש.
