# SE-Lab4

# BDD  گزارش آزمایش
در ابتدا پس از افزودن scenario outline که تست خود را run میکنیم به ارور undefined میخوریم:

![Screenshot (42)](https://github.com/user-attachments/assets/c4d76aba-fc37-46bf-a7a5-3a200e3bcf96)


علت این ارور این است که در تست خود اعداد مثبت و منفی را با هم جمع میکنیم اما در کد خود ورودی خود را با regex های (\\d+) تعریف کرده ایم. در کد اصلاح شده اعداد خود را با <arg{int}> تعریف میکنیم و مشکل رفع میشود. در واقع جوابهای سوالات ذکر شده به این ترتیب میشوند:
1. مووارد تست که به مشکل میخورند کدامند؟ آنها که در ورودی هایشان عدد منفی دارند.
2. علت بروز مشکل؟ موفع ورودی دادن، رجکس داده شده در تابع شان رعایت نشده و در نتیجه هنگام خواندن آنها به مشکل میخورند.
3. نحوه رفع آن: اصلاح رجکس ها و استاندارد کردن آنها. به شکل زیر


![Screenshot (41)](https://github.com/user-attachments/assets/d6afb3cd-693a-4cc3-a2e2-8b4c99d5d5f8)


برای خواسته آزمایش، در ادامه سناریو های قبلی سناریویی طراحی کردیم به شکل زیر:(یک سناریو معمولی و دیگری Outline)
![image](https://github.com/user-attachments/assets/50cfb716-dede-40a6-a0cd-75f9496ed4c8)

و با توجه به آن، فایلهای MyStepdefs و RunnerTest را نیز تکمیل کردیم و در نهایت تست ها را ران میکنیم و میبینم که همگی به درستی ران میشوند:
![image](https://github.com/user-attachments/assets/c25b5751-a3dc-4c40-a106-8bf017b74596)

از آنجایی که ما به دنبال فلوی ساده ای از کاربرد BDD در این  آزمایش بودیم، در سناریوی مطرح شده فرض کردیم که اعداد داده شده به صورت ورودی توابع، هم علامت هستند و دومین پارامتر نیز 0 نخواهد بود. در نهایت نیز همه تست های نوشته شده را در کنار همدیگر ران میکنیم و مییبینم که همگی به درستی کار میکنند:
![image](https://github.com/user-attachments/assets/8adf9aa1-920d-4ebc-b119-f09dd3083a33)


# Profiling گزارش آزمایش
قسمت اول
با اجرای برنامه و پروفایل آن، متوجه می شویم تابع temp زمان اجرای زیادی دارد. در این تابع نیز، تابع add مربوط به ArrayList زمان زیادی می گیرد.
![image](https://github.com/user-attachments/assets/a88ce281-7b3b-40b0-8386-4f286f7c6f13)

![image](https://github.com/user-attachments/assets/b126a6bf-fc67-4721-8820-321d93c1aef3)

پس به جای آنکه از آرایه با طول متغیر استفاده کنیم، از آرایه با اندازه ثابت استفاده می‌کنیم. چون اندازه آرایه‌ای که در این تابع وجود دارد ثابت است و تغییر نمی کند. کد تابع temp به صورت زیر در می آید:
![image](https://github.com/user-attachments/assets/101ead52-b923-41a9-8c80-6efb75908ce5)

حال می بینیم که میزان استفاده CPU و زمان اجرا خیلی بهتر شده است و برنامه با موفقیت اجرا می‌شود.

![image](https://github.com/user-attachments/assets/a2f2c020-d457-4ee6-a7c3-0441a75a2439)

![image](https://github.com/user-attachments/assets/1c5c8531-115e-464c-af72-bdf2d2ae3e83)



قسمت دوم
برای این قسمت کدی را نوشتیم که دو عدد از یک آرایه را بیابد که جمع آن‌ها برابر با مقدار مشخصی است. تابع اولیه به صورت زیر است:
![image](https://github.com/user-attachments/assets/d6877b49-9367-4f3d-8b4e-61b4443f5b51)

این تابع از دو حلقه‌ی تو در تو برای پیدا کردن دو عدد استفاده می کند. حال آن را پروفایل می کنیم:
![image](https://github.com/user-attachments/assets/707aeeac-d53a-46d7-91c1-09665724bcdf)

![image](https://github.com/user-attachments/assets/fa10d291-5409-499f-9fc7-0dbf3de0de4e)

![image](https://github.com/user-attachments/assets/f3cfaa6c-7906-4092-8326-d8601cba7389)

حال زمان اجرای آن را بهتر می کنیم. در کد جدید، از یک HashMap برای ذخیره‌ی مقادیر و اندیس‌های آن‌ها استفاده می‌کنیم. این روش پیچیدگی زمانی را به (O(n کاهش می‌دهد. تابع جدید به صورت زیر است:
![image](https://github.com/user-attachments/assets/12c01b82-27b7-486e-a982-ec57d338e56c)

حال این تابع را پروفایل می کنیم و درمی‌یابیم که در میزان مصرف CPU و زمان کاهش قابل توجهی داشتیم:
![image](https://github.com/user-attachments/assets/1178832e-2bbf-4024-8cd8-9b0b2f4949f7)

![image](https://github.com/user-attachments/assets/b66bae79-03ff-4fc3-86bf-c118170ec839)

![image](https://github.com/user-attachments/assets/5abee7be-8dfe-496a-af9b-813a26b11d25)






