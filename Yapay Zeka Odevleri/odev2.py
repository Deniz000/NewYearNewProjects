a = int(input("1. Açıyı Girin: "))
b = int(input("2. Açıyı Girin: "))
c = int(input("3. Açıyı Girin: "))

if a + b + c == 180:
    if a == 90 or b == 90 or c == 90:
        print("Bu bir dik üçgen.")
    elif a > 90 or b > 90 or c > 90:
        print("Bu bir geniş üçgen.")
    else:
        print("Bu bir dar üçgen.")
else:
    print("Bu bir üçgen değildir.")