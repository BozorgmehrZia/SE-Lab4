# SE-Lab4

در ابتدا پس از افزودن scenario outline که تست خود را run میکنیم به ارور undefined میخوریم:

![Screenshot (42)](https://github.com/user-attachments/assets/c4d76aba-fc37-46bf-a7a5-3a200e3bcf96)


علت این ارور این است که در تست خود اعداد مثبت و منفی را با هم جمع میکنیم اما در کد خود ورودی خود را با regex های (\\d+) تعریف کرده ایم. در کد اصلاح شده اعداد خود را با <arg{int}> تعریف میکنیم و مشکل رفع میشود.


![Screenshot (41)](https://github.com/user-attachments/assets/d6afb3cd-693a-4cc3-a2e2-8b4c99d5d5f8)



